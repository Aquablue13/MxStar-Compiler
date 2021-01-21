package AST;

import Util.position;

public class boolExprNode extends ExprNode {
	public boolean val;

    public boolExprNode(position pos) {
        super(pos);
        this.val = val;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}