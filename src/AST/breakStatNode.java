package AST;

import Util.position;

public class breakStatNode extends StatNode {
    public breakStatNode(position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}