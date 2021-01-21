package AST;

import Util.position;

public class whileStatNode extends StatNode {
    public ExprNode cond;
    public StatNode body;

    public whileStatNode(position pos, ExprNode cond, StatNode body) {
        super(pos);
        this.cond = cond;
        this.body = body;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}