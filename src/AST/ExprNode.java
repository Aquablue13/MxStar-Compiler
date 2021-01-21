package AST;

import Util.Type.Type;
import Util.position;

abstract public class ExprNode extends ASTNode {
    public Type type;
	public boolean isAssignable = false;

    public ExprNode(position pos) {
        super(pos);
    }

    public ExprNode(position pos, Type type) {
        super(pos);
        this.type = type;
    }

    public ExprNode(position pos, boolean isAssignable) {
        super(pos);
        this.isAssignable = isAssignable;
    }
}