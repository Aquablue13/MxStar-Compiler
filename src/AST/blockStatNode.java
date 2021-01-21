package AST;

import Util.position;

import java.util.ArrayList;

public class blockStatNode extends StatNode {
    public ArrayList<StatNode> stats = new ArrayList<>();

    public blockStatNode(position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}