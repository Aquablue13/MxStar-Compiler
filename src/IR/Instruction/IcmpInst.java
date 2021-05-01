package IR.Instruction;

import IR.Operand.Register;
import IR.BasicBlock;
import IR.Operand.RegisterForSet;
import Backend.IRVisitor;
import java.util.HashSet;
import java.util.ArrayList;

public class IcmpInst extends IRInst {
	public enum IcmpOp {
        seq, sne, sgt, sge, slt, sle,
        seqi, slti
    }
    public IcmpOp op;

    public IcmpInst(IcmpOp op) {
        this.op = op;
    }

    public IcmpInst(IcmpOp op, Register dest, Register src1, Register src2) {
        this.op = op;
        regs.add(dest);
        regs.add(src1);
        regs.add(src2);
    }

    @Override
    public String op() {
        return op.toString();
    }

    @Override
    public String toString() {
        String str = "\t" + regs.get(0).name() + " = " + op.toString() + " " + regs.get(1).name() + " " + regs.get(2).name();
        if (label > 0)
            str = str + " (" + label + ")";
        return str;
    }

    @Override
    public boolean isTerminal() {
        return false;
    }

    @Override
    public HashSet<RegisterForSet> uses() {
        HashSet<RegisterForSet> set = new HashSet<>();
        for (int i = 1; i < regs.size(); i++)
            set.add(new RegisterForSet(regs.get(i), i));
        return set;
    }

    @Override
    public HashSet<RegisterForSet> defs() {
        HashSet<RegisterForSet> set = new HashSet<>();
        set.add(new RegisterForSet(regs.get(0), 0));
        return set;
    }

    @Override
    public void accept(IRVisitor it) {
        it.visit(this);
    }
}