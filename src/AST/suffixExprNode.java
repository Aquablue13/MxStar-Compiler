package AST;

import Util.position;

public class suffixExprNode extends ExprNode {
    public ExprNode num;
    public String op;

    public suffixExprNode(position pos, ExprNode num, String op) {
        super(pos);
        this.num = num;
        this.op = op;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}