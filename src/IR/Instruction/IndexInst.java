package IR.Instruction;

import IR.Operand.Register;
import IR.BasicBlock;
import IR.Operand.RegisterForSet;
import Backend.IRVisitor;
import java.util.HashSet;
import java.util.ArrayList;

public class IndexInst extends IRInst {

    public IndexInst() {
    }

    public IndexInst(Register dest, Register src1, Register src2) {
        regs.add(dest);
        regs.add(src1);
        regs.add(src2);
    }

    @Override
    public String op() {
        return "index";
    }

    @Override
    public String toString() {
        String str = "\t" + regs.get(0).name() + " = index ";
        for (int i = 1; i < regs.size(); i++)
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