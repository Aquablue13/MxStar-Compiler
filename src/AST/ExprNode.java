package AST;

import Util.Type.Type;
import Util.position;
//import IR.Operand.Operand;

abstract public class ExprNode extends ASTNode {
    public Type type = new Type();
    public Type parent = null;
    public boolean isAssignable = false;
    public String funcName;
    /*
    public Operand operand;
    public Operand addr = null;*/

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