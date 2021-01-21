package AST;

import Util.Type.*;
import Util.position;

public class typeNode extends ASTNode {
    public String typeName;
    public int dim = 0;

    public typeNode(position pos) {
        super(pos);
    }

    public typeNode(position pos, String s, int dim) {
        super(pos);
        this.typeName = s;
        this.dim = dim;
    }

    public Type getType(){
        if (this.dim == 0)
            return new Type(typeName);
        return new arrayType(typeName, dim);
    }

    public boolean equal(typeNode t) {
        return (this.typeName.equals(t.typeName)) && (this.dim == t.dim);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}