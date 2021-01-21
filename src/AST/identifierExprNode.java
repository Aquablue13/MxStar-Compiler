package AST;

import Util.position;

public class identifierExprNode extends ExprNode {
    public String name;

    public identifierExprNode(position pos, String name) {
        super(pos, true);
        this.name = name;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}