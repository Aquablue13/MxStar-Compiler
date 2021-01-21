package AST;

import Util.position;

public class exprStatNode extends StatNode {
    public ExprNode expr;

    public exprStatNodeStmt(position pos, ExprNode expr) {
        super(pos);
        this.expr = expr;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}