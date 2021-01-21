package AST;

import Util.position;

public class parenExprNode extends ExprNode {
    public parenExprNode(position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}