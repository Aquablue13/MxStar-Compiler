package AST;

import Util.Type.Type;
import Util.position;

abstract public class ExprNode extends ASTNode {
    public Type type = new Type();
	public boolean isAssignable = false;

    public ExprNode(position pos) {
        super(pos);
    }

    public ExprNode(position pos, boolean isAssignable) {
        super(pos);
        this.isAssignable = isAssignable;
    }
}