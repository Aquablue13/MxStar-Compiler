package AST;

import Util.position;

public class ifStatNode extends StatNode {
    public ExprNode cond;
    public StatNode trueStat, falseStat;

    public ifStatNode(position pos, ExprNode cond, StatNode trueStat, StatNode falseStat) {
        super(pos);
        this.cond = cond;
        this.trueStat = trueStat;
        this.falseStat = falseStat;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}