package AST;

import Util.position;

public class forStatNode extends StatNode {
    public ExprNode init, cond, change;
    public StatNode body;

    public forStatNode(position pos, ExprNode init, ExprNode cond, ExprNode change, StatNode body) {
        super(pos);
        this.init = init;
        this.cond = cond;
        this.change = change;
        this.body = body;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}