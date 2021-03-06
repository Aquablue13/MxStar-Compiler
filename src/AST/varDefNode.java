package AST;

import Util.position;

import java.util.ArrayList;

public class varDefNode extends StatNode {
    public ArrayList<oneVarDefNode> vars = new ArrayList<>();

    public varDefNode(position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}