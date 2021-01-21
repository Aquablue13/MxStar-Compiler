package AST;

import Util.position;

public class stringExprNode extends ExprNode {
	public String val;

    public stringExprNode(position pos) {
        super(pos);
        this.val = val;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}