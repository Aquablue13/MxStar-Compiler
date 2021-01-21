package AST;

import Util.position;

public class oneVarDefNode extends StatNode {
    typeNode type;
    public String name;
    public ExprNode expr;

    public oneVarDefNode(position pos, String name) {
        super(pos);
        this.name = name;
    }

    public oneVarDefNode(position pos, String name, ExprNode expr) {
        super(pos);
        this.name = name;
        this.expr = expr;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}