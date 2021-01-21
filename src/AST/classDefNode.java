package AST;

import Util.position;

import java.util.ArrayList;

public class classDefNode extends DefNode {
    public String name;
    public ArrayList<oneVarDefNode> vars = new ArrayList<>();
    public ArrayList<funcDefNode> funcs = new ArrayList<>();
    public funcDefNode constructor = null;

    public classDefNode(position pos, String name) {
        super(pos);
        this.name = name;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}