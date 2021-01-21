package AST;

import Util.position;

public class subscriptExprNode extends ExprNode {
    public ExprNode head, index;

    public subscriptExprNode(position pos, ExprNode head, ExprNode index) {
        super(pos, true);
        this.head = head;
        this.index = index;
        this.isAssignable = true;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}