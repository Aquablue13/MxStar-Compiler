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

	@Override public void visit(classDefNode it) {
        className = it.name;
        it.vars.forEach(unit -> unit.accept(this));
        it.funcs.forEach(unit -> unit.accept(this));
        className = null;
	}

    @Override public void visit(varDefNode it) {}

    @Override public void visit(funcDefNode it) {
	    Type get = globalScope.getType(it.type);
        if (className == null) {
            globalScope.funcs.get(it.name).type = get;
            it.parameters.forEach(unit -> globalScope.funcs.get(it.name).parameters.add(globalScope.getType(unit.type)));
        } else {
            ((classType) globalScope.types.get(className)).funcs.get(it.name).type = get;
            it.parameters.forEach(unit -> ((classType) globalScope.types.get(className)).funcs.get(it.name).parameters.add(globalScope.getType(unit.type)));
        }
    }

    @Override public void visit(typeNode it) {}

    @Override public void visit(oneVarDefNode it) {
	    Type get = globalScope.getType(it.type);
        if (className == null)
            globalScope.vars.put(it.name, get);
        else
            ((classType)globalScope.types.get(className)).vars.put(it.name, get);
    }

    @Override public void visit(intExprNode it) {}
    @Override public void visit(identifierExprNode it) {}
    @Override public void visit(stringExprNode it) {}
    @Override public void visit(boolExprNode it) {}
    @Override public void visit(thisExprNode it) {}
    @Override public void visit(nullExprNode it) {}
    @Override public void visit(creatorExprNode it) {}
    @Override public void visit(memberExprNode it) {}
    @Override public void visit(funcExprNode it) {}
    @Override public void visit(exprsExprNode it) {}
    @Override public void visit(parenExprNode it) {}
    @Override public void visit(subscriptExprNode it) {}
    @Override public void visit(prefixExprNode it) {}
    @Override public void visit(suffixExprNode it) {}
    @Override public void visit(binaryExprNode it) {}
    @Override public void visit(assignExprNode it) {}

    @Override public void visit(varDefStatNode it) {}
    @Override public void visit(continueStatNode it) {}
    @Override public void visit(breakStatNode it) {}
    @Override public void visit(returnStatNode it) {}
    @Override public void visit(blockStatNode it) {}
    @Override public void visit(exprStatNode it) {}
    @Override public void visit(nullStatNode it) {}
    @Override public void visit(forStatNode it) {}
    @Override public void visit(ifStatNode it) {}
    @Override public void visit(whileStatNode it) {}
}