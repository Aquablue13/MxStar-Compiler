package Frontend;

import AST.*;
import Util.Scope;
import Util.Type.*;

public class TypeCollector implements ASTVisitor {
	private Scope globalScope;
    String className = null;

	public TypeCollector(Scope globalScope) {
		this.globalScope = globalScope;
	}

	@Override
	public void visit(RootNode it) {
		it.body.forEach(unit -> unit.accept(this));
	}

	@Override void visit(classDefNode it) {
        className = it.name;
        it.vars.forEach(unit -> unit.accept(this));
        it.funcs.forEach(unit -> unit.accept(this));
        className = null;
	}

    @Override void visit(varDefNode it) {}

    @Override void visit(funcDefNode it) {
        if (className == null) {
            funcType put = globalScope.funcs.put(it.name, funcType(it.type.type));
            it.parameters.forEach(unit -> globalScope.funcs.get(it.name).parameters.add(unit.type.type));
        } else {
            ((classType) globalScope.types.get(className)).funcs.put(it.name, funcType(it.type.type));
            it.parameters.forEach(unit -> ((classType) globalScope.types.get(className)).funcs.get(it.name).parameters.add(unit.type.type));
        }
    }

    @Override void visit(typeNode it) {}

    @Override void visit(oneVarDefNode it) {
        if (className == null)
            globalScope.vars.put(it.name, it.type.type);
        else {
            ((classType)globalScope.types.get(className)).vars.put(it.name, it.type.type);
        }
    }

    @Override void visit(intExprNode it) {}
    @Override void visit(identifierExprNode it) {}
    @Override void visit(stringExprNode it) {}
    @Override void visit(boolExprNode it) {}
    @Override void visit(thisExprNode it) {}
    @Override void visit(nullExprNode it) {}
    @Override void visit(creatorExprNode it) {}
    @Override void visit(memberExprNode it) {}
    @Override void visit(funcExprNode it) {}
    @Override void visit(parenExprNode it) {}
    @Override void visit(subscriptExprNode it) {}
    @Override void visit(prefixExprNode it) {}
    @Override void visit(suffixExprNode it) {}
    @Override void visit(binaryExprNode it) {}
    @Override void visit(assignExprNode it) {}

    @Override void visit(varDefStatNode it) {}
    @Override void visit(continueStatNode it) {}
    @Override void visit(breakStatNode it) {}
    @Override void visit(returnStatNode it) {}
    @Override void visit(blockStatNode it) {}
    @Override void visit(exprStatNode it) {}
    @Override void visit(nullStatNode it) {}
    @Override void visit(forStatNode it) {}
    @Override void visit(ifStatNode it) {}
    @Override void visit(whileStatNode it) {}
}