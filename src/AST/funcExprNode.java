package AST;

import Util.position;

import java.util.ArrayList;

public class funcExprNode extends ExprNode {
    public ExprNode head;
    public ArrayList<ExprNode> parameters;

    public funcExprNode(position pos) {
        super(pos);
    }

    public funcExprNode(position pos, ExprNode head, ArrayList<ExprNode> para) {
        super(pos);
        this.head = head;
        this.parameters = para;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}