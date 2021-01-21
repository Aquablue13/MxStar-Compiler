package AST;

import Util.position;

public class nullStatNode extends StatNode {
    public nullStatNode(position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}