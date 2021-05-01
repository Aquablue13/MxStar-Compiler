package IR.Instruction;

import IR.Operand.Register;
import IR.BasicBlock;
import IR.Operand.RegisterForSet;
import Backend.IRVisitor;
import java.util.HashSet;
import java.util.ArrayList;

public class BranchInst extends IRInst {
    public enum BranchOp {
        jump, beq, bneq
    }
    public BranchOp op;

    public BranchInst(BranchOp op) {
        this.op = op;
    }

    public BranchInst(BranchOp op, Register dest, Register src1, Register src2) {
        this.op = op;
        regs.add(dest);
        regs.add(src1);
        regs.add(src2);
    }

    public BranchInst(BranchOp op, Register dest, Register src) {
        this.op = op;
        regs.add(dest);
        regs.add(src);
    }

    @Override
    public String op() {
        return op.toString();
    }

    @Override
    public String toString() {
        String str = "\t" + op.toString();
        for (int i = 0; i < regs.size(); i++)
            str = str + " " + regs.get(i).name();
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
        if (!(op().equals("jump"))) {
            for (int i = 0; i < regs.size(); i++)
                set.add(new RegisterForSet(regs.get(i), i));
        }
        return set;
    }

    @Override
    public HashSet<RegisterForSet> defs() {
        return new HashSet<>();
    }

    @Override
    public void accept(IRVisitor it) {
        it.visit(this);
    }
}