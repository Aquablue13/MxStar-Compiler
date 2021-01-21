package Frontend;

import AST.*;
import Util.Scope;
import Util.Type.*;

public class symbolCollector implements ASTVisitor {
	private Scope globalScope, localScope;

	public symbolCollector(Scope globalScope) {
		this.globalScope = globalScope;
	}

	@Override
	public void visit(RootNode it) {
		globalScope.addType("bool", new Type("bool"), it.pos);
		globalScope.addType("int", new Type("int"), it.pos);
		globalScope.addType("string", new Type("string"), it.pos);
		globalScope.addType("void", new Type("void"), it.pos);
		globalScope.addType("null", new Type("null"), it.pos);
		localScope = globalScope;
		it.body.forEach(unit -> unit.accept(this));
	}

	@Override void visit(classDefNode it) {
		localScope = new Scope(localScope);
        classType tmp = new classType(it.name);
        it.vars.forEach(unit -> unit.accept(this));
        it.funcs.forEach(unit -> unit.accept(this));
        tmp.vars = localScope.vars;
        tmp.funcs = localScope.funcs;
        localScope = localScope.parentScope;
        localScope.defineType(it.name, tmp, it.pos);
	}

    @Override void visit(varDefNode it) {}

    @Override void visit(funcDefNode it) {
		localScope.defineFunction(it.name, new funcType(), it.pos);
    }

    @Override void visit(typeNode it) {}

    @Override void visit(oneVarDefNode it) {
    	localScope.defineVariable(it.name, new Type(), it.pos);
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