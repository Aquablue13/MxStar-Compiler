package AST;

import Util.Type.*;
import Util.position;

public class typeNode extends ASTNode {
    public Type type;
    public int dim = 0;

    public typeNode(position pos) {
        super(pos);
    }

    public typeNode(position pos, String s, int dim) {
        super(pos);
        this.type = new Type(s);
        this.dim = dim;
    }

    public Type getType(){
        if (this.dim == 0)
            return type;
        return new arrayType(type.name, dim);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}