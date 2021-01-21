package AST;

import Util.position;

public class assignExprNode extends ExprNode {
    public ExprNode num1, num2;
    public String op;

    public assignExprNode(position pos, ExprNode num1, ExprNode num2, String op) {
        super(pos);
        this.num1 = num1;
        this.num2 = num2;
        this.op = op;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}