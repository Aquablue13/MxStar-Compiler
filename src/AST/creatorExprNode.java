package AST;

import Util.position;
import Util.Type.Type;

import java.util.ArrayList;

public class creatorExprNode extends ExprNode {
    public typeNode typeNode;
    public ArrayList<ExprNode> exprs;

    public creatorExprNode(position pos, Type type, typeNode typeNode, ArrayList<ExprNode> exprs) {
        super(pos, type);
        this.typeNode = typeNode;
        this.exprs = exprs;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}