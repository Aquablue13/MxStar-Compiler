package AST;

import Util.Type.*;
import Util.position;

public class typeNode extends ASTNode {
    public Type type;

    public typeNode(position pos) {
        super(pos);
    }

    public typeNode(position pos, Type type) {
        super(pos);
        this.type = type;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}