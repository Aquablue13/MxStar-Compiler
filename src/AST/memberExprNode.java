package AST;

import Util.position;

public class memberExprNode extends ExprNode {
    public ExprNode head;
    public String member;
    public boolean isFunc = false;

    public memberExprNode(position pos, ExprNode head, String member) {
        super(pos, true);
        this.head = head;
        this.member = member;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}