package AST;

import Util.position;

public class intExprNode extends ExprNode {
	public int val;

    public intExprNode(position pos) {
        super(pos);
        this.val = val;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}