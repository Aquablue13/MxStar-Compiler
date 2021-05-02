package Optimize;

import IR.*;
import IR.IR;
import IR.BasicBlock;
import IR.Instruction.*;
import IR.Operand.RegisterForSet;
import IR.Operand.Register;

import java.util.*;

public class LICM {
    public BasicBlock curBlock;
    public int n, m;
    public boolean[] isAlive;
    public int[] cnt, toLab, toJp;
    public ArrayList<ArrayList<IRInst>> por;

    public LICM(BasicBlock block) {
        curBlock = block;
        n = curBlock.regAlloca.size(5);
        m = curBlock.insts.size();
        isAlive = new boolean[m];
        for (int i = 0; i < m; i++)
        	isAlive[i] = true;
        cnt = new int[n];
        por = new ArrayList<>();
		for (int i = 0; i < m; i++)
			por.add(new ArrayList<>());
        toJp = new int[curBlock.insts.size()];
        toLab = new int[curBlock.cntLab + 1];
    }

    public void trans() {
		ArrayList<IRInst> curInsts = new ArrayList<>();
		for (int i = 0; i < curBlock.insts.size(); i++) {
			IRInst tInst = curBlock.insts.get(i);
            curInsts.addAll(por.get(i));
			if (isAlive[i])
				curInsts.add(tInst);
		}
		curBlock.insts = curInsts;
    }

    public void work() {
        for (int i = 0; i < curBlock.insts.size(); i++){
            IRInst tInst = curBlock.insts.get(i);
            if (tInst instanceof LabelInst){
                toLab[tInst.label] = i;
            }
        }
        for (int i = 0; i < curBlock.insts.size(); i++){
            IRInst tInst = curBlock.insts.get(i);
            if (tInst instanceof BranchInst){
                if (tInst.calling) toJp[i] = toLab[0];
                else toJp[i] = toLab[tInst.label];
            }
        }
        for (int i = curBlock.insts.size() - 1; i >= 0; i--) {
            IRInst tInst = curBlock.insts.get(i);
            if (!tInst.op().equals("jump") || toJp[i] >= i)
                continue;

            for (int j = toJp[i]; j < i; j++) {
                IRInst inst = curBlock.insts.get(j);
                if (inst.defs().isEmpty())
                    continue;
                Register reg = inst.regs.get(0);
                cnt[reg.id] = 0;
            }

            for (int j = toJp[i]; j < i; j++)
                if (isAlive[j]) {
                    IRInst inst = curBlock.insts.get(j);
                    if (inst.defs().isEmpty())
                        continue;
                    Register reg = inst.regs.get(0);
                    if (reg.spec())
                        cnt[reg.id]++;
                }

            int num = 0;
            for (int j = toJp[i]; j < i; j++) {
                if (isAlive[j]) {
                    IRInst inst = curBlock.insts.get(j);
                    if (inst.defs().isEmpty() || tInst.op().equals("load"))
                        continue;
                    Register reg = inst.regs.get(0);
                    if (reg.spec() && cnt[reg.id] == 1) {
                        boolean br = false;
                        for (RegisterForSet treg : tInst.uses()) {
                            Register regId = treg.reg;
                            if (regId.gr != 8 && (regId.gr != 5 || cnt[regId.id] > 0)) {
                                br = true;
                                break;
                            }
                        }
                        if (br || por.get(toJp[i]).size() <= 3)
                            continue;
                        por.get(toJp[i]).add(tInst);
                        isAlive[j] = false;
                        cnt[reg.id]--;
                        num++;
                    }
                }
            }
        }

    	trans();
	}
}