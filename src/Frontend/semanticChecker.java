package Frontend;

import AST.*;
import Util.Error.semanticError;
import Util.*;
import Util.Type.*;

public class SemanticChecker implements ASTVisitor {
    public Scope globalScope, localScope;
    public Type returnType;
    public classType curClass;
    public boolean haveReturned;
    public int loopDep = 0;

    public SemanticChecker(Scope global) {
        this.globalScope = global;
        funcType print = new funcType("void");
        print.parameters.add(new Type("string"));
        this.globalScope.funcs.put("print", print);

        funcType println = new funcType("void");
        println.parameters.add(new Type("string"));
        this.globalScope.funcs.put("println", println);

        funcType printInt = new funcType("void");
        printInt.parameters.add(new Type("int"));
        this.globalScope.funcs.put("printInt", printInt);
       		
        funcType printlnInt = new funcType("void");
        printlnInt.parameters.add(new Type("int"));
        this.globalScope.funcs.put("printlnInt", printlnInt);

        funcType getString = new funcType("string");
        this.globalScope.funcs.put("getString", getString);

        funcType getInt = new funcType("int");
        this.globalScope.funcs.put("getInt", getInt);

        funcType toString = new funcType("string");
        toString.parameters.add(new Type("int"));
        this.globalScope.funcs.put("toString", toString);
    }

    @Override
    public void visit(RootNode it) {
    	localScope = globalScope;
    	funcType main = globalScope.getFunctionType("main", false);
        if (main.isInt == false)
        	throw new semanticError("main func return wrong type", it.pos);
        if (main.parameters.size() != 0)
        	throw new semanticError("main func have one more parameter", it.pos);
        it.body.forEach(unit -> unit.accept(this));
    }

    @Override
    public void visit(classDefNode it) {
    	curClass = (classType) globalScope.types.get(it.name);
        localScope = new Scope(localScope);
        curClass.vars.forEach((key, val) -> localScope.defineVariable(key, val, it.pos));
        curClass.funcs.forEach((key, val) -> localScope.defineFunction(key, val, it.pos));
    /*    it.funcs.forEach(unit -> unit.accept(this));
        if (it.constructor != null) {
            if (!it.constructor.equal(it))
            	throw new semanticError("wrong constructor's name", it.pos);
            it.constructor.accept(this);
        }*/
        localScope = localScope.parentScope;
        curClass = null;
    }

    @Override
    public void visit(varDefNode it) {
		it.vars.forEach(unit -> unit.accept(this));
    }

    @Override
    public void visit(funcDefNode it) {
    	haveReturned = false;
    	if (it.type != null)
    		returnType = it.type.type;
        else
        	returnType = new Type("void");
        localScope = new Scope(localScope);/*
        it.parameters.forEach(unit -> localScope.defineVariable(unit.name, unit.type.type, unit.pos));
        it.block.accept(this);
        localScope = localScope.parentScope;
        if (it.name.equal("main")) {
        	haveReturned = true;
        	return;
        }
        if (!it.type.simpleType.equals("void") && it.type != null)
            throw new semanticError("No return", it.pos);*/
    }

    @Override
    public void visit(typeNode it) {}

    @Override
    public void visit(oneVarDefNode it) {
        if (it.type.type.isVoid == true || it.type.type.isNull == true)
        	throw new semanticError("the type of variable is void or null", it.pos);
        if (it.expr != null) {
            it.expr.accept(this);/*
            if (!it.expr.type.equal(it.type.type))
            	throw new semanticError("mismatched variable type & original type", it.pos);*/
        }
        localScope.defineVariable(it.name, it.type.type, it.pos);
    }

    @Override
    public void visit(intExprNode it) {
    	it.type = new Type("int");
    }

    @Override
    public void visit(identifierExprNode it) {
    	it.type = localScope.getVariableType(it.name, true);
    }

    @Override
    public void visit(stringExprNode it) {
    	it.type = new Type("string");
    }
    
    @Override
    public void visit(boolExprNode it) {
    	it.type = new Type("bool");
    }
    
    @Override
    public void visit(thisExprNode it) {
    	if (curClass != null)
    		it.type = curClass;
        else
        	throw new semanticError("No this", it.pos);
    }
    
    @Override
    public void visit(nullExprNode it) {
    	it.type = new Type("null");
    }
    
    @Override
    public void visit(creatorExprNode it) {
		if (it.exprs != null) 
            it.exprs.forEach(x -> {x.accept(this); if (!x.type.isInt) throw new semanticError("not int", x.pos);});
    }

    @Override
    public void visit(memberExprNode it) {
    	it.head.accept(this);

        if (it.head.type instanceof arrayType && it.isFunc && it.member.equals("size")) {
        //    funcType type = new funcType("size");
            it.type = new funcType("int");
            return;
        }
        if (it.head.type.isString && it.isFunc && it.member.equals("length")) {/*
            funcSymbol func = new funcSymbol("length");
            func.returnType = new primitiveType("int");*/
            it.type = new funcType("int");
            return;
        }
        if (it.head.type.isString && it.isFunc && it.member.equals("substring")) {/*
            funcSymbol func = new funcSymbol("substring");
            func.returnType = new primitiveType("string");
            func.paramList.add(new varSymbol("left", new primitiveType("int")));
            func.paramList.add(new varSymbol("right", new primitiveType("int")));
            it.type = func;*/
            it.type = new funcType("string");
            return;
        }
        if (it.head.type.isString && it.isFunc && it.member.equals("parseInt")) {/*
            funcSymbol func = new funcSymbol("parseInt");
            func.returnType = new primitiveType("int");*/
            it.type = new funcType("int");;
            return;
        }
        if (it.head.type.isString && it.isFunc && it.member.equals("ord")) {/*
            funcSymbol func = new funcSymbol("ord");
            func.returnType = new primitiveType("int");
            func.paramList.add(new varSymbol("pos", new primitiveType("int")));*/
            it.type = new funcType("int");
            return;
        }
        if (!(it.head.type instanceof classType)) throw new semanticError("not a class", it.pos);
        classType cur = (classType) it.head.type;

        if (it.isFunc) {
            if (cur.funcs.containsKey(it.member))
            	it.type = cur.funcs.get(it.member);
            else
            	throw new semanticError("find no such member", it.pos);
        } else {
            if (cur.vars.containsKey(it.member))
            	it.type = cur.vars.get(it.member);
            else
            	throw new semanticError("find no such member", it.pos);
        }

    //    it.member.accept(this);  
    }

    @Override
    public void visit(funcExprNode it) {
    	if (it.head instanceof identifierExprNode) 
            it.head.type = localScope.getFunctionType(((identifierExprNode) it.head).name, true);
        else
        	it.head.accept(this);
        if (!(it.head.type instanceof funcType))
        	throw new semanticError("member isn't a function", it.pos);
        it.parameters.forEach(unit -> unit.accept(this));
        if (((funcType) it.head.type).parameters.size() != it.parameters.size())
        	throw new semanticError("mismatched parameter's size", it.pos);
        for (int i = 0; i < ((funcType) it.head.type).parameters.size(); i++) {
            if (!((funcType) it.head.type).parameters.get(i).equals(it.parameters.get(i).type))
                throw new semanticError("mismatched parameter's type", it.pos);
        }
        it.type = it.head.type;
    }

    @Override
    public void visit(exprsExprNode it) {}

    @Override
    public void visit(parenExprNode it) {}

    @Override
    public void visit(subscriptExprNode it) {
    	it.head.accept(this);
        it.index.accept(this);
        if (!it.index.type.isInt)
        	throw new semanticError("index isn't int", it.pos);
        if (!(it.head.type instanceof arrayType))
        	throw new semanticError("subscript not array", it.pos);
        arrayType type = (arrayType) it.head.type;
        if (type.dim - 1 == 0)
        	it.type = type.type;
        else
        	it.type = new arrayType(type.type.name, type.dim - 1);
    }

    @Override
    public void visit(prefixExprNode it) {
		it.num.accept(this);
        switch (it.op) {
            case "++":
            	if (!it.num.isAssignable)
                	throw new semanticError("isn't assignable", it.pos);
            case "--":
                if (!it.num.isAssignable)
                	throw new semanticError("isn't assignable", it.pos);
            case "+":
            	if (!it.num.type.isInt)
            		throw new semanticError("after + isn't int", it.pos);
            	break;
            case "-":
           		if (!it.num.type.isInt)
            		throw new semanticError("after - isn't int", it.pos);
            	break;
            case "~":
                if (!it.num.type.isInt)
            		throw new semanticError("after ~ isn't int", it.pos);
                break;
            case "!":
                if (!it.num.type.isBool)
                	throw new semanticError("after ! isn't bool", it.pos);
                break;
            default:
                break;
        }
        it.type = it.num.type;
    }

    @Override
    public void visit(suffixExprNode it) {
    	it.num.accept(this);
        if (it.num.type.isInt == false)
        	throw new semanticError("suffix isn't int", it.pos);
        if (!it.num.isAssignable)
        	throw new semanticError("suffix isn't assignable", it.pos);
        it.type = it.num.type;
    }

    @Override
    public void visit(binaryExprNode it) {
    	it.num1.accept(this);
		it.num2.accept(this);
		if (!it.num1.type.equal(it.num2.type))
			throw new semanticError("mismatched binaryExpr type", it.pos);
		if (!it.num1.type.isInt && !it.num1.type.isString)
			throw new semanticError("type isn't int or string", it.pos);
		if (it.num1.type.isString && it.op != "+")
			throw new semanticError("string with not add", it.pos);
		it.type = it.num1.type;
    }

    @Override
    public void visit(assignExprNode it) {
    	it.num1.accept(this);
		it.num2.accept(this);
		if (!it.num1.type.equal(it.num2.type))
			throw new semanticError("mismatched binaryExpr type", it.pos);
		if (!it.num1.isAssignable)
			throw new semanticError("invalid assign", it.pos);
		it.type = it.num1.type;
    }

    @Override
    public void visit(varDefStatNode it) {
    	it.vars.forEach(unit -> unit.accept(this));
    }

    @Override
    public void visit(continueStatNode it) {
    	if (loopDep == 0)
    		throw new semanticError("continue not in loop", it.pos);
    }

    @Override
    public void visit(breakStatNode it) {
    	if (loopDep == 0)
    		throw new semanticError("break not in loop", it.pos);
    }

    @Override
    public void visit(returnStatNode it) {
    	haveReturned = true;
        if (it.val == null) {
        	if (returnType.isVoid == false)
        		throw new semanticError("mismatched return type", it.pos);
        } else {
            it.val.accept(this);
            if (!it.val.type.equal(returnType))
            	throw new semanticError("mismatched return type", it.pos);
        }
    }

    @Override
    public void visit(blockStatNode it) {
    	it.stats.forEach(unit -> {
            if (unit instanceof blockStatNode) {
                localScope = new Scope(localScope);
                unit.accept(this);
                localScope = localScope.parentScope;
            } else {
                unit.accept(this);
            }
        });
    }

    @Override
    public void visit(exprStatNode it) {
    	it.expr.accept(this);
    }

    @Override
    public void visit(nullStatNode it) {}

    @Override
    public void visit(forStatNode it) {
    	if (it.init != null)
    		it.init.accept(this);
        if (it.cond != null)
        	it.cond.accept(this);
        if (it.cond != null && !it.cond.type.isBool)
            throw new semanticError("cond of for isn't bool", it.pos);
        if (it.change != null)
        	it.change.accept(this);
        loopDep++;
        localScope = new Scope(localScope);
        it.body.accept(this);
        localScope = localScope.parentScope;
        loopDep--;
    }

    @Override
    public void visit(ifStatNode it) {
        it.cond.accept(this);
        if (!it.cond.type.isBool)
        	throw new semanticError("cond of if isn't bool", it.pos);
        localScope = new Scope(localScope);
        it.trueStat.accept(this);
        localScope = localScope.parentScope;
        if (it.falseStat == null)
        	return;
        localScope = new Scope(localScope);
        it.falseStat.accept(this);
        localScope = localScope.parentScope;
    }

    @Override
    public void visit(whileStatNode it) {
    	it.cond.accept(this);
        if (!it.cond.type.isBool)
        	throw new semanticError("cond of while isn't bool", it.pos);
        loopDep++;
        localScope = new Scope(localScope);
        it.body.accept(this);
        localScope = localScope.parentScope;
        loopDep--;
    }
}