package AST;

import Util.position;
import Util.Scope;
import IR.Operand.Register;

abstract public class ASTNode {
    public position pos;
    public Scope scope;
    public Register regId, pRegId;
    public boolean inClass = false;

    public ASTNode(position pos) {
        this.pos = pos;
    }

    abstract public void accept(ASTVisitor visitor);
}