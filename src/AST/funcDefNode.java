package AST;

import Util.position;

import java.util.ArrayList;

public class funcDefNode extends DefNode {
    public typeNode type;
    public String name;
    public ArrayList<oneVarDefNode> parameters;
    public blockStatNode block;

    public funcDefNode(position pos) {
        super(pos);
    }

    public funcDefNode(position pos, typeNode type, String name, ArrayList<oneVarDefNode> paras, blockStatNode block) {
        super(pos);
        this.type = type;
        this.name = name;
        this.parameters = paras;
        this.block = block;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}