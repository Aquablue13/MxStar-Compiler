package Backend;

import IR.Operand.Register;
import IR.Instruction.*;
import IR.*;

public interface IRVisitor {
    void visit(IR it);
    void visit(BasicBlock it);

    void visit(ArithInst it);
    void visit(BitwiseInst it);
    void visit(BranchInst it);
    void visit(IndexInst it);
    void visit(CallInst it);
    void visit(FuncInst it);
    void visit(IcmpInst it);
    void visit(LoadInst it);
    void visit(StoreInst it);
    void visit(MoveInst it);
    void visit(LabelInst it);
}
