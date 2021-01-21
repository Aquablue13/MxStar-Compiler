package AST;

import Util.position;
import java.util.ArrayList;

public class exprsExprNode extends ExprNode {
    public ArrayList<ExprNode> exprs = new ArrayList<>();

    public exprsExprNode(position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}