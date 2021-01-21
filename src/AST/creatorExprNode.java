package AST;

import Util.position;

import java.util.ArrayList;

public class creatorExprNode extends ExprNode {
    public typeNode type;
    public ArrayList<ExprNode> exprs;

    public creatorExprNode(position pos, typeNode type, ArrayList<ExprNode> exprs) {
        super(pos);
        this.type = type;
        this.exprs = exprs;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}