package Optimize;

import IR.*;
import IR.IR;
import IR.Instruction.*;
import IR.BasicBlock;
import IR.Instruction.*;
import IR.Operand.RegisterForSet;
import IR.Operand.Register;

import java.util.*;

public class MergeImm {
	public BasicBlock curBlock;

	public MergeImm(BasicBlock block) {
		curBlock = block;
	}

	public void work() {
		ArrayList<IRInst> curInsts = new ArrayList<>();
		for (int i = 0; i < curBlock.insts.size(); i++) {
			IRInst cur = curBlock.insts.get(i);
			IRInst las = (curInsts.isEmpty()) ? null : curInsts.get(curInsts.size() - 1);
			if (las == null || !las.op().equals("addi")) {
				curInsts.add(cur);
				continue;
			}
			if (!cur.op().equals("addi") || !cur.regs.get(1).spec() || cur.regs.get(0).equals(cur.regs.get(1))) {
				curInsts.add(cur);
				continue;
			}
			if (!las.regs.get(0).equals(cur.regs.get(1)) || las.regs.get(0).equals(las.regs.get(1))) {
				curInsts.add(cur);
				continue;
			}
			IRInst res = new ArithInst(ArithInst.ArithOp.addi);
			res.regs.add(cur.regs.get(0));
			res.regs.add(new Register(las.regs.get(2).id + cur.regs.get(2).id, 8, false));
			curInsts.set(curInsts.size() - 1, res);
		}
		curBlock.insts = curInsts;
	}
}