package Optimize;

import IR.*;
import IR.IR;
import IR.Instruction.*;
import IR.BasicBlock;
import IR.Instruction.*;
import IR.Operand.RegisterForSet;
import IR.Operand.Register;

import java.util.*;

public class AddImm {
	public BasicBlock curBlock;

	public AddImm(BasicBlock block) {
		curBlock = block;
	}

	public void work() {
		ArrayList<IRInst> curInsts = new ArrayList<>();
		for (int i = 0; i < curBlock.insts.size(); i++) {
			IRInst cur = curBlock.insts.get(i);
			IRInst las = (curInsts.isEmpty()) ? null : curInsts.get(curInsts.size() - 1);
			if (las == null || !las.op().equals("load") || las.regs.isEmpty()
				|| !las.regs.get(0).spec() || las.regs.get(1).gr == 8) {
				curInsts.add(cur);
				continue;
			}
			if (!cur.defs().isEmpty() && !cur.regs.get(0).spec()) {
				curInsts.add(cur);
				continue;
			}
			Register [] reg = new Register[3];
			reg[1] = cur.regs.get(1);
			if (cur.regs.size() > 2)
				reg[2] = cur.regs.get(2);
			else
				reg[2] = null;
			int pos = 0;
			for (int o = 1; o <= 2; o++)
				if (las.regs.get(0).equals(reg[o])) {
					pos = o;
					break;
				}
			if (pos == 0) {
				curInsts.add(cur);
				continue;
			}
			IRInst res = new ArithInst(ArithInst.ArithOp.addi);
			boolean fl = false;
			switch (cur.op()) {
				case "add":
					res = new ArithInst(ArithInst.ArithOp.addi);
					break;
				case "mul":
					res = new ArithInst(ArithInst.ArithOp.muli);
					break;
				case "seq":
					res = new IcmpInst(IcmpInst.IcmpOp.seqi);
					break;
				case "slt":
					res = new IcmpInst(IcmpInst.IcmpOp.slti);
					break;
				case "and":
					res = new BitwiseInst(BitwiseInst.BitwiseOp.andi);
					break;
				case "move":
					res = new LoadInst(LoadInst.LoadOp.load);
					if (pos == 2)
						fl = true;
					break;
				default:
					fl = true;
			}
			if (fl) {
				curInsts.add(cur);
				continue;
			}
			if (cur.op().equals("move")) {
				res.regs.add(cur.regs.get(0));
				res.regs.add(las.regs.get(1));
				curInsts.set(curInsts.size() - 1, res);
				continue;
			}
			if (cur.op().equals("seq")) {
				if (las.regs.get(0).equals(reg[2])) {
					res.regs.add(cur.regs.get(0));
					res.regs.add(cur.regs.get(1));
					res.regs.add(new Register(-las.regs.get(1).id, 8, false));
					curInsts.set(curInsts.size() - 1, res);
				}
				else 
					curInsts.add(cur);
				continue;
			}
			if (true) {
				res.regs.add(cur.regs.get(0));
				res.regs.add(reg[pos]);
				res.regs.add(las.regs.get(1));
				curInsts.set(curInsts.size() - 1, res);
				continue;
			}
		}
		curBlock.insts = curInsts;
	}
}