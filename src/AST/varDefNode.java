package AST;

import Util.position;

import java.util.ArrayList;

public class varDefNode extends StatNode {
//    public typeNode type;
    public ArrayList<oneVarDefNode> vars = new ArrayList<>();

    public varDefNode(position pos, typeNode type) {
        super(pos);
//        this.type = type;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}