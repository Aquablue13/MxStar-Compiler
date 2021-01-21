package AST;

import Util.Type.Type;
import Util.position;

public class atomExprNode extends ExprNode {
    public int intVal;
    public String stringVal;
    public boolean boolVal;

    public atomExprNode(position pos) {
        super(pos);
        this.type.isNull = true;
    }

    public atomExprNode(int value, position pos) {
        super(pos);
        this.intVal = value;
        this.type.isInt = true;
    }

    public atomExprNode(boolean value, position pos) {
        super(pos);
        this.boolVal = value;
        this.type.isBool = true;
    }

    public atomExprNode(String value, position pos) {
        super(pos);
        this.stringVal = value;
        this.type.isString = true;
    }    

    @Override
    public atomExprNode accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }
}