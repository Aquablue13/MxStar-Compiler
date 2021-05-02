package Optimize;

import IR.*;
import IR.IR;
import IR.BasicBlock;
import IR.Instruction.BranchInst;
import IR.Instruction.IRInst;
import IR.Instruction.LabelInst;
import IR.Operand.RegisterForSet;
import IR.Operand.Register;

import java.util.*;

public class SSAConstruction {
    public BasicBlock curBlock;
    public int n;
    public int vis_now = 1;
    public int[] vis, jmp_target, label_target;
    public int[] fa;
    public ArrayList<ArrayList<ArrayList<Integer>>> pred;
    public Register[] tReg;
    
    public SSAConstruction(BasicBlock block) {
        curBlock = block;
        n = curBlock.insts.size();
    }

    void init() {
        vis = new int[n];
        vis = new int[n];
        pred = new ArrayList<>();
        for (int i = 0; i < n; i++){
            pred.add(new ArrayList<>());
            for (int j = 0; j < curBlock.insts.get(i).regs.size(); j++)
                pred.get(i).add(new ArrayList<>());
        }
        fa = new int[n];
        for (int i = 0; i < n; i++)
            fa[i] = i;
        tReg = new Register[n];
    }

    int getFa(int x) {
        return (fa[x] == x ? x : getFa(fa[x]));
    }

    public void pre(){
        jmp_target = new int[curBlock.insts.size()];
        label_target = new int[curBlock.cntLab + 1];
        for (int i = 0; i < curBlock.insts.size(); i++){
            IRInst tInst = curBlock.insts.get(i);
            if (tInst instanceof LabelInst){
                label_target[tInst.label] = i;
            }
        }
        for (int i = 0; i < curBlock.insts.size(); i++){
            IRInst tInst = curBlock.insts.get(i);
            if (tInst instanceof BranchInst){
                if (tInst.calling) jmp_target[i] = label_target[0];
                else jmp_target[i] = label_target[tInst.label];
            }
        }
    }

    public void colPred(int i, int id, int pos){
        while (i < curBlock.insts.size() && vis[i] < vis_now){
            vis[i] = vis_now;
            IRInst tInst = curBlock.insts.get(i);
            Register regId;
			int j;
			for (RegisterForSet treg : tInst.uses()) {
				regId = treg.reg;
				j = treg.pos;
                if (regId.gr == 1 && regId.id == id){
                    pred.get(i).get(j).add(pos);
                    //tInst.regs.set(j, tReg[pos]);
                }
            }
            if (!tInst.defs().isEmpty() && 
                tInst.regs.get(0).gr == 1 && tInst.regs.get(0).id == id){
                pred.get(i).get(0).add(pos);
                break;
            }

            if (tInst.op().equals("jump")){
                i = jmp_target[i];
            }else{
                if (tInst instanceof BranchInst){
                    colPred(jmp_target[i], id, pos);
                }
                i++;
            }
        }
    }
    public void visSucc(int i, int id, int pos){
        while (i < curBlock.insts.size() && vis[i] < vis_now){
            vis[i] = vis_now;
            IRInst tInst = curBlock.insts.get(i);
            Register regId;
			int j;
			for (RegisterForSet treg : tInst.uses()) {
				regId = treg.reg;
				j = treg.pos;
                if (regId.gr == 1 && regId.id == id){
                    tInst.regs.set(j, tReg[pos]);
                }
            }
            if (!tInst.defs().isEmpty() && 
                tInst.regs.get(0).gr == 1 && tInst.regs.get(0).id == id){
                break;
            }

            if (tInst.op().equals("jump")){
                i = jmp_target[i];
            }else{
                if (tInst instanceof BranchInst){
                    visSucc(jmp_target[i], id, pos);
                }
                i++;
            }
        }
    }

    public void rename() {
        for (int i = 0; i < curBlock.insts.size(); i++){
            for (int j = 0; j < curBlock.insts.get(i).regs.size(); j++) {
                if (pred.get(i).get(j).isEmpty())
                    continue;
                for (int k = 0; k < pred.get(i).get(j).size(); k++) {
                    int x = pred.get(i).get(j).get(k);
                    tReg[x].mult = true;
                }
                int fir = pred.get(i).get(j).get(0);
                for (int k = 1; k < pred.get(i).get(j).size(); k++) {
                    int x = getFa(fir);
                    int y = getFa(pred.get(i).get(j).get(k));
                    if (x != y)
                        fa[y] = x;
                }
            } 
        }

        for (int i = 0; i < curBlock.insts.size(); i++){
            IRInst tInst = curBlock.insts.get(i);
            if (!tInst.defs().isEmpty() && tInst.regs.get(0).gr == 1){
                tReg[i].assign(tReg[getFa(i)]);
                vis_now++;
                visSucc(i + 1, tInst.regs.get(0).id, i);
                tInst.regs.set(0, tReg[i]);
            }
        }
    }

    public void work() {
        init();
        pre();

        for (int i = 0; i < curBlock.insts.size(); i++){
            IRInst tInst = curBlock.insts.get(i);
            if (!tInst.defs().isEmpty() && tInst.regs.get(0).gr == 1){
                vis_now++;
                tReg[i] = curBlock.regAlloca.alloc(5);
                colPred(i + 1, tInst.regs.get(0).id, i);
            }
        }

        rename();
    }
}