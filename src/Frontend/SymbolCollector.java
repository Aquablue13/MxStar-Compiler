package Frontend;

import AST.*;
import Util.Scope;
import Util.globalScope;
import Util.Type.*;

public class SymbolCollector implements ASTVisitor {
	private Scope localScope;
    private globalScope globalScope;
    private Boolean inClass = false;

	public SymbolCollector(globalScope globalScope) {
		this.globalScope = globalScope;
	}

	@Override
	public void visit(RootNode it) {
		globalScope.defineType("bool", new Type("bool"), it.pos);
		globalScope.defineType("int", new Type("int"), it.pos);
		globalScope.defineType("string", new Type("string"), it.pos);
		globalScope.defineType("void", new Type("void"), it.pos);
		globalScope.defineType("null", new Type("null"), it.pos);
		
        localScope = globalScope;
		it.body.forEach(unit -> unit.accept(this));
	}

	@Override public void visit(classDefNode it) {
	    inClass = true;
		localScope = new Scope(localScope);
        classType tmp = new classType(it.name);
        it.vars.forEach(unit -> unit.accept(this));
        it.funcs.forEach(unit -> unit.accept(this));
        tmp.vars = localScope.vars;
        tmp.funcs = localScope.funcs;
        localScope.classInfo = tmp;
        globalScope.addType(it.name, localScope, it.pos);
        localScope = localScope.parentScope;
        localScope.defineType(it.name, tmp, it.pos);
        inClass = false;
	}

    @Override public void visit(varDefNode it) {
        it.vars.forEach(unit -> unit.accept(this));
    }

    @Override public void visit(funcDefNode it) {
		localScope.defineFunction(it.name, new funcType(it.type.getType().name), it.pos);
    }

    @Override public void visit(typeNode it) {}

    @Override public void visit(oneVarDefNode it) {
        if (globalScope == localScope){
            localScope.defineVariable(it.name, new Type(it.type.getType().name), it.pos, 2);
         //   System.out.println(it.name + ":2");
        }
        else
            if (inClass){
                localScope.defineVariable(it.name, new Type(it.type.getType().name), it.pos, 11);
            //    System.out.println(it.name + ":11");
            }
            else {
                localScope.defineVariable(it.name, new Type(it.type.getType().name), it.pos, 1);
            //    System.out.println(it.name + ":1");
            }
    //    localScope.defineVariable(it.name, new Type(it.type.getType().name), it.pos);
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