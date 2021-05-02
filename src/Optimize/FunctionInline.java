package Optimize;

import IR.*;
import IR.IR;
import IR.BasicBlock;
import IR.Instruction.*;
import IR.Operand.RegisterForSet;
import IR.Operand.Register;

import java.util.*;

public class FunctionInline {
	public BasicBlock curBlock;

	Register[] params, tr;
	Register num;

	public FunctionInline(BasicBlock block) {
		this.curBlock = block;
		params = new Register[block.regNum];
		tr = new Register[block.regNum];
		num = null;
	}

	public void work() {
		boolean found = false, fl = false;
		for (int i = 0; i < curBlock.insts.size(); i++) {
			IRInst curInst = curBlock.insts.get(i);
			if (curInst instanceof CallInst) {
				found = true;
				if (curInst.block != curBlock) return;
				if (i + 3 < curBlock.insts.size() && curBlock.insts.get(i + 3).op().equals("jump") && curBlock.insts.get(i + 3).label == 0)
					continue;
				if (i + 4 < curBlock.insts.size() && curBlock.insts.get(i + 4).op().equals("jump") && curBlock.insts.get(i + 4).label == 0) {
					IRInst inst1 = curBlock.insts.get(i + 1);
					IRInst inst2 = curBlock.insts.get(i + 2);
					IRInst inst3 = curBlock.insts.get(i + 3);
					if (inst2.op().equals("addi") && inst2.regs.get(0).equals(inst3.regs.get(1)) && inst2.regs.get(1).equals(inst1.regs.get(0))) {
						fl = true;
						curInst.add_up = inst2.regs.get(2).id;
						continue;
					}
					return;
				}
				return;
			}
		}
		if (found && curBlock.regNum <= 10) {
			ArrayList<IRInst> curInsts = new ArrayList<>();
			int ret = curBlock.labelAlloc();
			for (int i = 0; i < curBlock.regNum; i++)
				tr[i] = curBlock.regAlloca.alloc(5);
			num = curBlock.regAlloca.alloc(5);
			for (int i = 0; i < curBlock.insts.size(); i++) {
				IRInst cur = curBlock.insts.get(i);
				IRInst inst;
				if (cur instanceof CallInst) {
					for (int j = curBlock.regNum; j > 0; j--) {
						inst = new MoveInst(params[j - 1], tr[j - 1]);
						curInsts.add(inst);
					}
					if (cur.add_up != 0) {
						inst = new ArithInst(ArithInst.ArithOp.addi, num, num, new Register(cur.add_up, 8, false));
						curInsts.add(inst);
					}
					inst = new BranchInst(BranchInst.BranchOp.jump);
					inst.label = ret;
					curInsts.add(inst);
				} else {
					if (i > curBlock.regNum) {
						if (fl && cur instanceof MoveInst && cur.regs.get(0).equals(new Register(10, 0, false))) {
							Register tmp = curBlock.regAlloca.alloc(5);
							inst = new ArithInst(ArithInst.ArithOp.add, tmp, cur.regs.get(1), num);
							curInsts.add(inst);
							cur.regs.set(1, tmp);
						}
						if (cur instanceof MoveInst && cur.regs.get(0).gr == 3)
							cur.regs.set(0, tr[cur.regs.get(0).id]);
					} else if (i != 0) {
						params[i - 1] = cur.regs.get(0);
					}
					curInsts.add(cur);
					if (i == curBlock.regNum) {
						if (fl) {
							inst = new MoveInst(num, new Register(0, 0, false));
							curInsts.add(inst);
						}
						inst = new LabelInst(ret);
						curInsts.add(inst);
					}
				}
			}
			curBlock.insts = curInsts;
			curBlock.containsCALL = false;
		}
	}
}