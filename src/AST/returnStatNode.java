package AST;

import Util.position;

public class returnStatNode extends StatNode {
    public ExprNode val;

    public returnStatNode(position pos, ExprNode val) {
        super(pos);
        this.val = val;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}