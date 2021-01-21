package AST;

import Util.position;

public class continueStatNode extends StatNode {
    public continueStatNode(position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}