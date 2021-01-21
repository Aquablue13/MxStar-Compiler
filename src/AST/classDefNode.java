package AST;

import Util.position;

import java.util.ArrayList;

public class classDefNode extends DefNode {
    public String name;
    public ArrayList<oneVarDefNode> vars = new ArrayList<>();
    public ArrayList<funcDef> funcs = new ArrayList<>();
//    public funcDef constructor = null;

    public classDef(position pos, String name) {
        super(pos);
        this.name = name;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}