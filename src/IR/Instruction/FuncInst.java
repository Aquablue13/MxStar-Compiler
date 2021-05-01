package IR.Instruction;

import IR.Operand.Register;
import IR.BasicBlock;
import IR.Operand.RegisterForSet;
import Backend.IRVisitor;
import java.util.HashSet;
import java.util.ArrayList;

public class FuncInst extends IRInst {

    public FuncInst(String name) {
        this.funcName = name;
    }

    @Override
    public String op() {
        return "func";
    }
    
    @Override
    public String toString() {
        String str = "func" + funcName;
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
        return new HashSet<>();
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