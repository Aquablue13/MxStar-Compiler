package IR.Instruction;

import IR.Operand.Register;
import IR.BasicBlock;
import IR.Operand.RegisterForSet;
import Backend.IRVisitor;
import java.util.HashSet;
import java.util.ArrayList;

public class MoveInst extends IRInst {

    public MoveInst() {
    }

    public MoveInst(Register dest, Register src) {
        regs.add(dest);
        regs.add(src);
    }

    @Override
    public String op() {
        return "move";
    }

    @Override
    public String toString() {
        String str = "\t" + regs.get(0).name() + " = move " + regs.get(1).name();
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