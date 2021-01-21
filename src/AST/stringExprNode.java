package AST;

import Util.position;

public class stringExprNode extends ExprNode {
	public String val;

    public stringExprNode(position pos, String val) {
        super(pos);
        this.val = val;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}