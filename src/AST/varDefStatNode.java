package AST;

import Util.position;

import java.util.ArrayList;

public class varDefStatNode extends StatNode {
//    public typeNode type;
    public ArrayList<oneVarDefNode> vars = new ArrayList<>();

    public varDefStatNode(position pos, typeNode type) {
        super(pos);
//        this.type = type;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}