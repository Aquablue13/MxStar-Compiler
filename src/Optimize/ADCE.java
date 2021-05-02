package Optimize;

import IR.*;
import IR.IR;
import IR.BasicBlock;
import IR.Instruction.*;
import IR.Operand.RegisterForSet;
import IR.Operand.Register;

import java.util.*;

public class ADCE {
    public BasicBlock curBlock;
    public int n, m;
    public Queue<Integer> q;
    public boolean[] isLive;
    public ArrayList<ArrayList<Integer>> p;

    public ADCE(BasicBlock block) {
        curBlock = block;
        n = curBlock.regAlloca.size(5);
        m = curBlock.insts.size();
        q = new LinkedList<Integer>();
        isLive = new boolean[n];
        for (int i = 0; i < n; i++)
        	isLive[i] = false;
        p = new ArrayList<>();
		for (int i = 0; i < n; i++)
			p.add(new ArrayList<>());
    }

    public void pre() {
    	for (int i = 0; i < curBlock.insts.size(); i++) {
    		IRInst tInst = curBlock.insts.get(i);
    		if (tInst instanceof StoreInst || tInst instanceof BranchInst) {
    			for (Register reg : tInst.regs) {
    				if (reg.gr == 5) {
    					isLive[reg.id] = true;
    					q.add(reg.id);
    				}
    			}
    		} else
    		if (!tInst.defs().isEmpty()) {
    			Register dest = tInst.regs.get(0);
    			if (!dest.dcec())
    				continue;
    			for (int j = 1; j < tInst.regs.size(); j++) 
    				if (tInst.regs.get(j).gr == 5) {
    					int x = tInst.regs.get(j).id;
    					if (dest.gr == 5)
    						p.get(dest.id).add(x);
    					else{
    						isLive[x] = true;
    						q.add(x);
    					}
    				}
    		}
    	}
    }

    public void bfs() {
        while (!q.isEmpty()) {
            int t = q.poll();
            for (int pt : p.get(t)) {
            	if (!isLive[pt]) {
            		isLive[pt] = true;
            		q.add(pt);
            	}
            }
        }
    }

    public void clear() {
		ArrayList<IRInst> curInsts = new ArrayList<>();
		for (int i = 0; i < curBlock.insts.size(); i++) {
			IRInst tInst = curBlock.insts.get(i);
			if (tInst.defs().isEmpty() || tInst.regs.get(0).gr != 5 || isLive[tInst.regs.get(0).id])
				curInsts.add(tInst);
		}
		curBlock.insts = curInsts;
    }

    public void work() {
    	pre();
    	bfs();
    	clear();
	}
}