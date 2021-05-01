package Optimize;

import IR.Instruction.*;
import IR.*;
import IR.Operand.RegisterForSet;
import IR.Operand.Register;
import IR.BasicBlock;

import java.util.*;

public class GraphColoringRegAllocator {
    BasicBlock curBlock;

    public int vis_now;
    public int[] vis, jmp_target, label_target;
    public int[] reach, t_end, t_begin;
    boolean[] flag;
    int reach_num;
    public int[] reach_dad, reach_state;
    public ArrayList<ArrayList<Integer>> reach_to;

    public int Num;
    public ArrayList<ArrayList<Integer> > to = new ArrayList<>();
    public boolean[] saved;
     public int[] deg, color_arr;
    public int color_arr_num;
    public boolean[] spilled, colored;
    public int max_color = 0, normal_color = 13;
    public int[] color = {10, 11, 12, 13, 14, 15, 16, 17, 5, 6, 7, 28, 29, 8, 9, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27};
    public int[] c = {10, 11, 12, 13, 14, 15, 16, 17, 5, 6};
    public int[] val;

    public GraphColoringRegAllocator(BasicBlock block) {
        this.curBlock = block;
    }

    public void graphInit(int n) {
        Num = n + c.length;
        for (int i = 0; i < Num; i++) to.add(new ArrayList<>());
        saved = new boolean[Num];
    }

    public void add(int x, int y){
        if (x == y) return;
        to.get(x).add(y);
        to.get(y).add(x);
    }
   
    public void work(){
        for (int i = 0; i < Num; i++){
            HashSet<Integer> hs = new HashSet<Integer>(to.get(i));
            to.set(i, new ArrayList<Integer>(hs));
            /*System.out.print(i + " : ");
            System.out.println(to.get(i));*/
        }
        val = new int [Num];
        spilled = new boolean [Num];
        colored = new boolean [Num];
        for (int i = 0; i < Num; i++) val[i] = -1;

        deg = new int[Num];
        ArrayList<Integer> spill_arr = new ArrayList<>();
        ArrayList<Integer> saved_arr = new ArrayList<>();
        for (int i = 0; i < Num; i++){
            if (saved[i]){
                //spilled[i] = true;
                saved_arr.add(i);
                to.get(i).forEach(x -> {
                    deg[x]++;
                });
            }else{
                to.get(i).forEach(x -> {
                    if (!saved[x]) deg[x]++;
                });
            }
        }
        for (int i = Num - c.length; i < Num; i++){
            val[i] = i - (Num - c.length);
            colored[i] = true;
        }
        color_arr = new int [Num];
        color_arr_num = 0;

        for (int j = 0; j < saved_arr.size(); j++){
            int i = saved_arr.get(j);
            if (deg[i] < color.length - normal_color){
                color_arr[color_arr_num++] = i;
                colored[i] = true;
            }else{
                spill_arr.add(i);
            }
        }
 
        for (int i = 0, head = 0; ; i++){
            while (i == color_arr_num && head < spill_arr.size()){
                int x = spill_arr.get(head++);
                if (!colored[x] && !spilled[x]){
                    spilled[x] = true;
                    to.get(x).forEach(y -> {
                        if (!colored[y] && !spilled[y]){
                            if (--deg[y] < color.length - normal_color && saved[y]){
                                color_arr[color_arr_num++] = y;
                                colored[y] = true;
                            }
                        }
                    });
                }
            }
            if (i >= color_arr_num) break;
            int v = color_arr[i];
            to.get(v).forEach(x -> {
                if (saved[x] && !colored[x] && !spilled[x]){
                    if (--deg[x] < color.length - normal_color){
                        color_arr[color_arr_num++] = x;
                        colored[x] = true;
                    }
                }
            });
        }

        for (int i = color_arr_num - 1; i >= 0; i--){
            int v = color_arr[i];
            boolean[] used = new boolean[color.length];
            for (int j = 0; j < to.get(v).size(); j++){
                int x = to.get(v).get(j);
                if (!spilled[x] && val[x] != -1) used[val[x]] = true;
            };
            int now = normal_color;
            while (used[now]) now++;
            val[v] = now;
            if (now > max_color) max_color = now;
        }

        color_arr_num = 0;
        spill_arr.clear();
        for (int i = 0; i < Num; i++){
            if (!colored[i] && !spilled[i] && deg[i] < color.length){
                color_arr[color_arr_num++] = i;
                colored[i] = true;
            }
            spill_arr.add(i);
        }
        
        for (int i = 0, head = 0; ; i++){
            while (i == color_arr_num && head < spill_arr.size()){
                int x = spill_arr.get(head++);
                if (!colored[x] && !spilled[x]){
                    spilled[x] = true;
                    to.get(x).forEach(y -> {
                        if (!colored[y] && !spilled[y]){
                            if (--deg[y] < color.length){
                                color_arr[color_arr_num++] = y;
                                colored[y] = true;
                            }
                        }
                    });
                }
            }
            if (i >= color_arr_num) break;
            int v = color_arr[i];
            to.get(v).forEach(x -> {
                if (!colored[x] && !spilled[x]){
                    if (--deg[x] < color.length){
                        color_arr[color_arr_num++] = x;
                        colored[x] = true;
                    }
                }
            });
        }
        for (int i = color_arr_num - 1; i >= 0; i--){
            int v = color_arr[i];
            boolean[] used = new boolean[color.length];
            for (int j = 0; j < to.get(v).size(); j++){
                int x = to.get(v).get(j);
                if (!spilled[x] && val[x] != -1) used[val[x]] = true;
            };
            int now = 0;
            while (used[now]) now++;
            val[v] = now;
            if (now > max_color) max_color = now;
        }
    }

    public boolean isSpill(int x) {
        return (val[x] < 0);
    }

    public int getColor(int x){
        if (val[x] >= 0) return color[val[x]];
        return -1;
    }

    public int useSaved(){
        if (max_color >= normal_color) return max_color - normal_color + 1;
        return 0;
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

    public void reach_pass(int id) {
        int[] b = new int [curBlock.insts.size()];
        int tail = 0;

        for (int i = t_begin[id] + 1; i <= t_end[id]; i++){
            IRInst tInst = curBlock.insts.get(i);
            Register regId;
			for (RegisterForSet treg : tInst.uses()) {
				regId = treg.reg;
                if (regId.gr == 5 && id == regId.id){
                    reach[i] = vis_now;
                    b[tail++] = i;
                }
            }
        }

        for (int i = 0; i < tail; i++){
            int v = b[i];
            for (int j = 0; j < reach_to.get(v).size(); j++){
                int x = reach_to.get(v).get(j);
                IRInst inst = curBlock.insts.get(x);
                if (reach[x] < vis_now && !(!inst.defs().isEmpty() && inst.regs.get(0).gr == 5 && inst.regs.get(0).id == id)){
                    reach[x] = vis_now;
                    b[tail++] = x;
                }
            }
        }

        for (int i = 0; i < tail; i++){
            IRInst tInst = curBlock.insts.get(b[i]);
            if (tInst instanceof CallInst){
                saved[id] = true;
            }
            Register regId;
			for (RegisterForSet treg : tInst.uses()) {
				regId = treg.reg;
                if (regId.gr == 5)
                    add(id, regId.id);
                else if (regId.gr == 0 && regId.id >= 10){
                    add(id, regId.id - 10 + curBlock.regAlloca.size(5));
                }
            }
            if (!tInst.defs().isEmpty() && b[i] + 1 < curBlock.insts.size() && reach[b[i] + 1] == vis_now){
                regId = tInst.regs.get(0);
                if (regId.gr == 5){
                    add(id, regId.id);
                }
                else if (regId.gr == 0 && regId.id >= 10){
                    add(id, regId.id - 10 + curBlock.regAlloca.size(5));
                }
            }

        }
    }

    public void palloc_pass(int i, int id){
        while (i < curBlock.insts.size()){
            IRInst tInst = curBlock.insts.get(i);
            for (int j = 0; j < tInst.regs.size(); j++){
                Register regId = tInst.regs.get(j);
                if (regId.gr == 5) add(id, regId.id);
            }
            if (tInst instanceof CallInst || tInst.calling) break;
            i++;
        }
    }

    public void init() {
        vis = new int[curBlock.insts.size()];
        reach = new int[curBlock.insts.size()];
        reach_state = new int[curBlock.insts.size()];
        reach_dad = new int[curBlock.insts.size()];
        t_end = new int[curBlock.regAlloca.size(5)];
        t_begin = new int[curBlock.regAlloca.size(5)];
        flag = new boolean[curBlock.regAlloca.size(5)];
        graphInit(curBlock.regAlloca.size(5));
        vis_now = 1;
    }

    public void build() {
        reach_to = new ArrayList<>();
        for (int i = 0; i < curBlock.insts.size(); i++) reach_to.add(new ArrayList<>());
        for (int i = 0; i < curBlock.insts.size(); i++){
            IRInst inst = curBlock.insts.get(i);
            if (inst instanceof BranchInst){
                    reach_to.get(jmp_target[i]).add(i);
                }
            if (!inst.op().equals("jump") && i + 1 < curBlock.insts.size()) reach_to.get(i + 1).add(i);
        }


        for (int i = 0; i < curBlock.insts.size(); i++){
            IRInst tInst = curBlock.insts.get(i);
            for (int j = 0; j < tInst.regs.size(); j++){
                if (tInst.regs.get(j).gr == 5){
                    t_end[tInst.regs.get(j).id] = i;
                }
            }
        }
        for (int i = 0; i < curBlock.insts.size(); i++){
            IRInst tInst = curBlock.insts.get(i);
            if (tInst.ignored) continue;
            if (!tInst.defs().isEmpty()){
                Register regId = tInst.regs.get(0);
                if (regId.gr == 5){
                    if (flag[regId.id] == false){
                        flag[regId.id] = true;
                        t_begin[regId.id] = i;
                        vis_now++;
                        reach_pass(regId.id);
                        //alloc_pass(i + 1, regId.id);
                    }
                }else if (regId.gr == 0){
                    //System.out.println(regId.id + " " + (regId.id - 10 + curBlock.regAlloca.size(5)));
                    palloc_pass(i + 1, regId.id - 10 + curBlock.regAlloca.size(5));
                }
            }
        }
    }

    void clear() {
        ArrayList<IRInst> curInsts = new ArrayList<>();
        for (int i = 0; i < curBlock.insts.size(); i++) {
            IRInst tInst = curBlock.insts.get(i);
            if (tInst instanceof MoveInst) {
                if (tInst.regs.get(0).id == tInst.regs.get(1).id && tInst.regs.get(0).gr == tInst.regs.get(1).gr) {
                    continue;
                }
            }
            curInsts.add(tInst);
        }
        curBlock.insts = curInsts;
    }

    void rewriteProgram() {
        Register[] spill_reg = new Register[curBlock.regAlloca.size(5)];
        for (int i = 0; i < curBlock.insts.size(); i++){
            IRInst tInst = curBlock.insts.get(i);
            for (int j = 0; j < tInst.regs.size(); j++){
                Register regId = tInst.regs.get(j);
                if (regId.gr == 5){
                    int id = regId.id;
                    if (getColor(id) == -1){
                        if (spill_reg[id] == null) tInst.regs.set(j, spill_reg[id] = curBlock.regAlloca.alloc(12));
                        else tInst.regs.set(j, spill_reg[id]);
                    }else{
                        tInst.regs.set(j, new Register(getColor(id), 0, false));
                    }
                }else if (regId.gr == 0 && regId.id >= 10){
                    regId.id = c[regId.id - 10];
                }
            }
        }
    }

    public void main() {
        init();
        pre();
        build();
        work();

        rewriteProgram();
        curBlock.spillNum = useSaved();
        clear();
    //    curBlock.remove();
        
    }

    public void use() {
    //    Blocks.forEach(b -> {t = new GraphColoringRegAllocator(b); t.main();});
    }
}