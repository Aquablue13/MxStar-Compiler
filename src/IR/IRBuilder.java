package IR;

import AST.*;
import Util.Scope;
import Util.Type.*;
import Util.Error.semanticError;
import Util.globalScope;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

import IR.*;
import IR.Function.IRFuncType;

public class IRBuilder implements ASTVisitor {
    private Scope localScope;
    private globalScope globalScope;
    private ArrayList<ASTNode> vars = new ArrayList<>();
    private boolean fl = false;
    private classType curClass = null;
    private BasicBlocks Blocks;
	private BasicBlock curBlock;
	private int cntLab = 0;
	private int loopStart = 0, loopEnd = 0, loopCont = 0;
	private int ifElse = 0, ifEnd = 0;

    public IRBuilder(BasicBlocks Blocks, globalScope globalScope) {
        this.localScope = this.globalScope = globalScope;
        this.Blocks = Blocks;
    }
	
    @Override
    public void visit(RootNode it) {
		it.body.forEach(unit -> {
    		if (unit instanceof oneVarDefNode) {
    			vars.add(unit);
    		}
    	});
    	it.body.forEach(unit -> unit.accept(this));
    }
	
	@Override
    public void visit(funcDefNode it) {
    	String funcName;
    	if (it.scope.classInfo != null)
            funcName = it.scope.classInfo.name + "." + it.name;
        else
            funcName = it.name;
		curBlock = new BasicBlock();
		curBlock.name = funcName;
		curBlock.lab = updCntLab();
		curBlock.regAlloca = it.scope.regAlloca;
		Blocks.blocks.add(curBlock);
		Function func = new Function(IRFuncType.FUNC, funcName);
		curBlock.funcs.add(func);

		if (curClass == null) {
			for (int i = 0; i < it.parameters.size(); i++) {
				func =  new Function(IRFuncType.MOVE);
				func.regs.add(it.parameters.get(i).regId);
				if (i < 6) func.regs.add(new Register(i + 10, 0, false));
				else func.regs.add(new Register(i - 6, 4, false));
				curBlock.funcs.add(func);
			}
			fl = true;
			if (it.name.equals("main"))
				vars.forEach(unit -> unit.accept(this));
			it.block.accept(this);
			if (it.name.equals("main") && Blocks.haveNoReturn) {
				func = new Function(IRFuncType.MOVE);
				func.regs.add(new Register(10, 0, false));
				func.regs.add(new Register(0, 0, false));
				curBlock.funcs.add(func);
				func = new Function(IRFuncType.JUMP);
				func.label = curBlock.lab;
				curBlock.funcs.add(func);
			}
		} else {
			Register curReg = new Register(0, 1, false);
			func = new Function(IRFuncType.MOVE);
			func.regs.add(curReg);
			func.regs.add(new Register(10, 0, false));
			curBlock.funcs.add(func);
			for (int i = 0; i < it.parameters.size(); i++) {
				func = new Function(IRFuncType.MOVE);
				func.regs.add(it.parameters.get(i).regId);
				if (i < 5) func.regs.add(new Register(i + 11, 0, false));
				else func.regs.add(new Register(i - 5, 4, false));
				curBlock.funcs.add(func);
			}
			it.block.accept(this);
		}
    }

    @Override
    public void visit(classDefNode it) {
		curClass = new classType(it.name);
		if (it.constructor != null)
            it.constructor.accept(this);
		it.funcs.forEach(unit -> unit.accept(this));	
		curClass = null;
    }

    @Override
    public void visit(varDefNode it) {
        it.vars.forEach(unit -> unit.accept(this));
    }

    @Override
    public void visit(oneVarDefNode it) {	
		if (it.scope == globalScope && !fl) {
		}else{
			if (it.expr != null) {
				it.expr.accept(this);
				
				Function func = new Function(IRFuncType.MOVE);
				func.regs.add(it.scope.getRegIdVariable(it.name, false));
				func.regs.add(it.expr.regId);
				curBlock.funcs.add(func);
			}
		}
    }

    @Override
    public void visit(returnStatNode it) {
        if (it.val != null) {
            it.val.accept(this);
			Function func = new Function(IRFuncType.MOVE);
			func.regs.add(new Register(10, 0, false));
			func.regs.add(it.val.regId);
			curBlock.funcs.add(func);
        }
		Function func = new Function(IRFuncType.JUMP);
		func.label = curBlock.lab;
		curBlock.funcs.add(func);
    }

    @Override
    public void visit(blockStatNode it) {
        it.stats.forEach(unit -> {
            unit.accept(this);
        });
    }

    @Override
    public void visit(exprStatNode it) {
        it.expr.accept(this);
    }
	
	@Override
    public void visit(breakStatNode it) {
		Function func = new Function(IRFuncType.JUMP);
		func.label = loopEnd;
		curBlock.funcs.add(func);
    }
	
	@Override
    public void visit(continueStatNode it) {
		Function func = new Function(IRFuncType.JUMP);
		func.label = loopCont;
		curBlock.funcs.add(func);
    }

	@Override
    public void visit(whileStatNode it) {
		int tLoopStart = loopStart, tLoopEnd = loopEnd;
		int tLoopCont = loopCont;
		loopCont = loopStart = updCntLab();
		loopEnd = updCntLab();

		Function func = new Function(IRFuncType.LABEL);
		func.label = loopStart;
		curBlock.funcs.add(func);

        if (it.cond != null) {
			it.cond.accept(this);

			func = new Function(IRFuncType.BNEQ);
			func.regs.add(it.cond.regId);
			func.regs.add(new Register(0, 0, false));
			func.label = loopEnd;
			curBlock.funcs.add(func);
		}

		it.body.accept(this);

		func = new Function(IRFuncType.JUMP);
		func.label = loopStart;
		curBlock.funcs.add(func);
		func = new Function(IRFuncType.LABEL);
		func.label = loopEnd;
		curBlock.funcs.add(func);

		loopCont = tLoopCont;
		loopStart = tLoopStart;
		loopEnd = tLoopEnd;
    }

    @Override
    public void visit(ifStatNode it) {
		int tIfElse = ifElse, tIfEnd = ifEnd;
		ifEnd = updCntLab();
		if (it.falseStat != null) ifElse = updCntLab();

        it.cond.accept(this);
		Function func = new Function(IRFuncType.BNEQ);
		func.regs.add(it.cond.regId);
		func.regs.add(new Register(0, 0, false));
		if (it.falseStat != null) func.label = ifElse;
		else func.label = ifEnd;
		curBlock.funcs.add(func);

        if (it.trueStat != null) {
			it.trueStat.accept(this);

			if (it.falseStat != null) {
				func = new Function(IRFuncType.JUMP);
				func.label = ifEnd;
				curBlock.funcs.add(func);
			}
		}
        if (it.falseStat != null) {
			func = new Function(IRFuncType.LABEL);
			func.label = ifElse;
			curBlock.funcs.add(func);
			
			it.falseStat.accept(this);
		}

		func = new Function(IRFuncType.LABEL);
		func.label = ifEnd;
		curBlock.funcs.add(func);

		ifElse = tIfElse;
		ifEnd = tIfEnd;
    }
	
    @Override
    public void visit(forStatNode it) {
		int tLoopStart = loopStart, tLoopEnd = loopEnd;
		int tLoopCont = loopCont;
		loopStart = updCntLab();
		loopEnd = updCntLab();
		loopCont = updCntLab();

        if (it.init != null) it.init.accept(this);
		Function func = new Function(IRFuncType.LABEL);
		func.label = loopStart;
		curBlock.funcs.add(func);

        if (it.cond != null) {
			it.cond.accept(this);

			func = new Function(IRFuncType.BNEQ);
			func.regs.add(it.cond.regId);
			func.regs.add(new Register(0, 0, false));
			func.label = loopEnd;
			curBlock.funcs.add(func);
		}
		if (it.body != null) it.body.accept(this);
		func = new Function(IRFuncType.LABEL);
		func.label = loopCont;
		curBlock.funcs.add(func);
        if (it.change != null) it.change.accept(this);
		
		func = new Function(IRFuncType.JUMP);
		func.label = loopStart;
		curBlock.funcs.add(func);
		func = new Function(IRFuncType.LABEL);
		func.label = loopEnd;
		curBlock.funcs.add(func);

		loopStart = tLoopStart;
		loopEnd = tLoopEnd;
		loopCont = tLoopCont;
    }

    @Override
    public void visit(funcExprNode it) {/*
		ArrayList<ExprNode> a = new ArrayList<ExprNode>();
		ExprNode b = a.get(0);*/
		it.head.accept(this);
		if (curBlock.paramNum + 1 < it.parameters.size() + 1)
			curBlock.paramNum = it.parameters.size() - 1 + 1;
		it.parameters.forEach(unit -> unit.accept(this));

		int t = 0;
		String name;
		if (it.head instanceof identifierExprNode)
			name = ((identifierExprNode)it.head).name;
		else
			name = ((memberExprNode)it.head).member.name;
	//	System.out.println(name);
	//	System.out.println("!!!");
		t = it.scope.getFunctionInClass(name, true);

		if (it.parameters.size() >= 0) {
			for (int i = it.parameters.size() - 1; i >= 0; i--) {
				Function func = new Function(IRFuncType.MOVE);
				func.regs.add(new Register(i + t, 3, false));
				func.regs.add(it.parameters.get(i).regId);
				curBlock.funcs.add(func);
			}
		}

		if (t == 1) {
			if (it.head.parent != null) {
				Function func = new Function(IRFuncType.MOVE);
				func.regs.add(new Register(0, 3, false));
				func.regs.add(it.head.regId);
				curBlock.funcs.add(func);
			}else{
				Function func = new Function(IRFuncType.MOVE);
				func.regs.add(new Register(0, 3, false));
				func.regs.add(new Register(0, 1, false));
				curBlock.funcs.add(func);
			}
		}
		Function func = new Function(IRFuncType.CALL);
		func.func = name;
		// !!
		curBlock.funcs.add(func);

		it.regId = curBlock.regAlloca.alloc(5);
		func = new Function(IRFuncType.MOVE);
		func.regs.add(it.regId);
		func.regs.add(new Register(10, 0, false));
		curBlock.funcs.add(func);

    }

    @Override
    public void visit(assignExprNode it) {
        it.num2.accept(this);
        it.num1.accept(this);

		Function func = new Function(IRFuncType.MOVE);
		func.regs.add(it.num1.regId);
		func.regs.add(it.num2.regId);
		curBlock.funcs.add(func);

		it.regId = it.num1.regId;
    }
	
	@Override
    public void visit(suffixExprNode it) {
        it.num.accept(this);

		it.regId = curBlock.regAlloca.alloc(5);
		Function func = new Function(IRFuncType.MOVE);
		func.regs.add(it.regId);
		func.regs.add(it.num.regId);
		curBlock.funcs.add(func);

		func = new Function(IRFuncType.ADDI);
		func.regs.add(it.num.regId);
		func.regs.add(it.num.regId);
		switch (it.op) {
			case "++":
				func.regs.add(new Register(1, 8, false));
				break;
			case "--":
				func.regs.add(new Register(-1, 8, false));

		}
		curBlock.funcs.add(func);
    }
	
    @Override
    public void visit(prefixExprNode it) {
        it.num.accept(this);
		Function func;
		switch (it.op) {
			case "++":
				it.regId = it.num.regId;
				func = new Function(IRFuncType.ADDI);
				func.regs.add(it.regId);
				func.regs.add(it.regId);
				func.regs.add(new Register(1, 8, false));
				curBlock.funcs.add(func);
				break;
			case "--":
				it.regId = it.num.regId;
				func = new Function(IRFuncType.ADDI);
				func.regs.add(it.regId);
				func.regs.add(it.regId);
				func.regs.add(new Register(-1, 8, false));
				curBlock.funcs.add(func);
				break;
			case "+":
				it.regId = it.num.regId;
				break;
			case "-":
				it.regId = curBlock.regAlloca.alloc(5);
				func = new Function(IRFuncType.NEG);
				func.regs.add(it.regId);
				func.regs.add(it.num.regId);
				curBlock.funcs.add(func);
				break;
			case "~":
				it.regId = curBlock.regAlloca.alloc(5);
				func = new Function(IRFuncType.NOT);
				func.regs.add(it.regId);
				func.regs.add(it.num.regId);
				curBlock.funcs.add(func);
				break;
			case "!":
				it.regId = curBlock.regAlloca.alloc(5);
				func = new Function(IRFuncType.LOGICNOT);
				func.regs.add(it.regId);
				func.regs.add(it.num.regId);
				curBlock.funcs.add(func);
		}
    }

    @Override //*
    public void visit(binaryExprNode it) {
		it.regId = curBlock.regAlloca.alloc(5);
		Function func = null;
		switch (it.op) {
			case "&&":
				int short_circuit = updCntLab(), expr_end = updCntLab();

				it.num1.accept(this);
				func = new Function(IRFuncType.BNEQ);
				func.regs.add(it.num1.regId);
				func.regs.add(new Register(0, 0, false));
				func.label = short_circuit;
				curBlock.funcs.add(func);

				it.num2.accept(this);
				func = new Function(IRFuncType.BNEQ);
				func.regs.add(it.num2.regId);
				func.regs.add(new Register(0, 0, false));
				func.label = short_circuit;
				curBlock.funcs.add(func);

				func = new Function(IRFuncType.LOAD);
				func.regs.add(it.regId);
				func.regs.add(new Register(1, 8, false));
				curBlock.funcs.add(func);
				func = new Function(IRFuncType.JUMP);
				func.label = expr_end;
				curBlock.funcs.add(func);
				func = new Function(IRFuncType.LABEL);
				func.label = short_circuit;
				curBlock.funcs.add(func);
				func = new Function(IRFuncType.LOAD);
				func.regs.add(it.regId);
				func.regs.add(new Register(0, 8, false));
				curBlock.funcs.add(func);
				func = new Function(IRFuncType.LABEL);
				func.label = expr_end;
				curBlock.funcs.add(func);
				return;
			case "||":
				short_circuit = updCntLab();
				expr_end = updCntLab();

				it.num1.accept(this);
				func = new Function(IRFuncType.BEQ);
				func.regs.add(it.num1.regId);
				func.regs.add(new Register(0, 0, false));
				func.label = short_circuit;
				curBlock.funcs.add(func);

				it.num2.accept(this);
				func = new Function(IRFuncType.BEQ);
				func.regs.add(it.num2.regId);
				func.regs.add(new Register(0, 0, false));
				func.label = short_circuit;
				curBlock.funcs.add(func);
				
				func = new Function(IRFuncType.LOAD);
				func.regs.add(it.regId);
				func.regs.add(new Register(0, 8, false));
				curBlock.funcs.add(func);
				func = new Function(IRFuncType.JUMP);
				func.label = expr_end;
				curBlock.funcs.add(func);
				func = new Function(IRFuncType.LABEL);
				func.label = short_circuit;
				curBlock.funcs.add(func);
				func = new Function(IRFuncType.LOAD);
				func.regs.add(it.regId);
				func.regs.add(new Register(1, 8, false));
				curBlock.funcs.add(func);
				func = new Function(IRFuncType.LABEL);
				func.label = expr_end;
				curBlock.funcs.add(func);

				return;
		}
        it.num1.accept(this);
        it.num2.accept(this);
		if (it.num1.type.isString && it.num2.type.isString) {
			func = new Function(IRFuncType.MOVE);
			func.regs.add(new Register(1, 3, false));
			func.regs.add(it.num2.regId);
			curBlock.funcs.add(func);
			func = new Function(IRFuncType.MOVE);
			func.regs.add(new Register(0, 3, false));
			func.regs.add(it.num1.regId);
			curBlock.funcs.add(func);
			switch (it.op) {
				case "==":
					func = new Function(IRFuncType.CALL);
					func.func = "my_string_eq";
					curBlock.funcs.add(func);
					break;
				case "!=":
					func = new Function(IRFuncType.CALL);
					func.func = "my_string_neq";
					curBlock.funcs.add(func);
					break;
				case ">":
					func = new Function(IRFuncType.CALL);
					func.func = "my_string_ge";
					curBlock.funcs.add(func);
					break;
				case ">=":
					func = new Function(IRFuncType.CALL);
					func.func = "my_string_geq";
					curBlock.funcs.add(func);
					break;
				case "<":
					func = new Function(IRFuncType.CALL);
					func.func = "my_string_le";
					curBlock.funcs.add(func);
					break;
				case "<=":
					func = new Function(IRFuncType.CALL);
					func.func = "my_string_leq";
					curBlock.funcs.add(func);
					break;
				case "+":
					func = new Function(IRFuncType.CALL);
					func.func = "my_string_plus";
					curBlock.funcs.add(func);
					break;
			}
			func = new Function(IRFuncType.MOVE);
			func.regs.add(it.regId);
			func.regs.add(new Register(10, 0, false));
			curBlock.funcs.add(func);
			return;
		}
		switch (it.op) {
			case "==":
				func = new Function(IRFuncType.EQ);
				break;
			case "!=":
				func = new Function(IRFuncType.NEQ);
				break;
			case ">":
				func = new Function(IRFuncType.GE);
				break;
			case ">=":
				func = new Function(IRFuncType.GEQ);
				break;
			case "<":
				func = new Function(IRFuncType.LE);
				break;
			case "<=":
				func = new Function(IRFuncType.LEQ);
				break;
			case "+":
				func = new Function(IRFuncType.ADD);
				break;
			case "|":
				func = new Function(IRFuncType.OR);
				break;
			case "&":
				func = new Function(IRFuncType.AND);
				break;
			case "-":
				func = new Function(IRFuncType.SUB);
				break;
			case "^":
				func = new Function(IRFuncType.XOR);
				break;
			case "<<":
				func = new Function(IRFuncType.SHL);
				break;
			case ">>":
				func = new Function(IRFuncType.SHR);
				break;
			case "*":
				func = new Function(IRFuncType.MUL);
				break;
			case "/":
				func = new Function(IRFuncType.DIV);
				break;
			case "%":
				func = new Function(IRFuncType.MOD);
		}
		func.regs.add(it.regId);
		func.regs.add(it.num1.regId);
		func.regs.add(it.num2.regId);
		curBlock.funcs.add(func);
    }
	
	@Override //*
    public void visit(subscriptExprNode it) {
		it.head.accept(this);
		it.index.accept(this);
		Register tmp = curBlock.regAlloca.alloc(5);
		Function func = new Function(IRFuncType.ADDI);
		func.regs.add(tmp);
		func.regs.add(it.index.regId);
		func.regs.add(new Register(1, 8, false));
		curBlock.funcs.add(func);
		Register regId = curBlock.regAlloca.alloc(5);
		func = new Function(IRFuncType.INDEX);
		func.regs.add(regId);
		func.regs.add(it.head.regId);
		func.regs.add(tmp);
		curBlock.funcs.add(func);

		it.regId = new Register(regId.id, regId.gr, true);
	}
	
	@Override
    public void visit(memberExprNode it) {
		it.head.accept(this);
		it.member.pRegId = it.head.regId;
		it.member.accept(this);
		if (it.head.type instanceof classType){
			Register regId = curBlock.regAlloca.alloc(5);
			Function func = new Function(IRFuncType.INDEX);
			func.regs.add(regId);
			func.regs.add(it.head.regId);
			func.regs.add(it.member.regId);
			curBlock.funcs.add(func);

			it.regId = new Register(regId.id, regId.gr, true);
		}else{
			it.regId = it.head.regId;
		}
	}

	public Register newMalloc(creatorExprNode it, int i) {
		if (i >= it.exprs.size()) {
			if ((it.type instanceof classType) || Blocks.classSizs.containsKey(it.typeNode.typeName) && it.exprs.size() == ((arrayType)it.type).dim) {
				Function func = new Function(IRFuncType.LOAD);
				func.regs.add(new Register(10, 0, false));
				func.regs.add(new Register(Blocks.classSizs.get(it.typeNode.typeName) << 2, 8, false));
				curBlock.funcs.add(func);
				
				func = new Function(IRFuncType.CALL);
				func.func = "malloc";
				curBlock.funcs.add(func);

				Register nowRegId = curBlock.regAlloca.alloc(5);
				func = new Function(IRFuncType.MOVE);
				func.regs.add(nowRegId);
				func.regs.add(new Register(10, 0, false));
				curBlock.funcs.add(func);

				Scope tmp_scope = globalScope.getScopeFromName(it.typeNode.typeName);
				if (tmp_scope.containsFunction(it.typeNode.typeName, false)) {

					func = new Function(IRFuncType.CALL);
					func.func = "my_c_" + it.typeNode.typeName + "_" + it.typeNode.typeName;
					curBlock.funcs.add(func);
				};
				return nowRegId;
			}else{
				return new Register(0, 0, false);
			}
		}
		Register iter = curBlock.regAlloca.alloc(1);
		Register nowRegId = curBlock.regAlloca.alloc(1);
		Register ttmp = curBlock.regAlloca.alloc(5);
		Function func = new Function(IRFuncType.MOVE);
		func.regs.add(iter);
		func.regs.add(it.exprs.get(i).regId);
		curBlock.funcs.add(func);

		func = new Function(IRFuncType.MOVE);
		func.regs.add(ttmp);
		func.regs.add(it.exprs.get(i).regId);
		curBlock.funcs.add(func);

		func = new Function(IRFuncType.MOVE);
		func.regs.add(new Register(10, 0, false));
		func.regs.add(ttmp);
		curBlock.funcs.add(func);

		func = new Function(IRFuncType.CALL);
		func.func = "my_array_alloc";
		curBlock.funcs.add(func);
		func = new Function(IRFuncType.MOVE);
		func.regs.add(nowRegId);
		func.regs.add(new Register(10, 0, false));
		curBlock.funcs.add(func);

		int loopStart = updCntLab(), loopEnd = updCntLab();
		func = new Function(IRFuncType.LABEL);
		func.label = loopStart;
		curBlock.funcs.add(func);
		func = new Function(IRFuncType.BNEQ);
		func.regs.add(iter);
		func.regs.add(new Register(0, 0, false));
		func.label = loopEnd;
		curBlock.funcs.add(func);

		Register next_result = newMalloc(it, i + 1);
		Register result = curBlock.regAlloca.alloc(5);
		func = new Function(IRFuncType.INDEX);
		func.regs.add(result);
		func.regs.add(nowRegId);
		func.regs.add(iter);
		curBlock.funcs.add(func);
		
		func = new Function(IRFuncType.MOVE);
		func.regs.add(new Register(result.id, result.gr, true));
		func.regs.add(next_result);
		curBlock.funcs.add(func);
		func = new Function(IRFuncType.ADDI);
		func.regs.add(iter);
		func.regs.add(iter);
		func.regs.add(new Register(-1, 8, false));
		curBlock.funcs.add(func);
		func = new Function(IRFuncType.JUMP);
		func.label = loopStart;
		curBlock.funcs.add(func);

		func = new Function(IRFuncType.LABEL);
		func.label = loopEnd;
		curBlock.funcs.add(func);

		return nowRegId;
	}

	@Override
    public void visit(creatorExprNode it) {
		for (ExprNode unit : it.exprs) {
			unit.accept(this);
		}
		it.regId = newMalloc(it, 0);
	}

	@Override //*
    public void visit(intExprNode it) {
    	it.regId = curBlock.regAlloca.alloc(5);
		Function func = new Function(IRFuncType.LOAD);
		func.regs.add(it.regId);
		func.regs.add(new Register(it.val, 8, false));
		curBlock.funcs.add(func);
    }

    @Override
    public void visit(identifierExprNode it) {
    	Scope cur = it.scope;
		while (cur != null){
			if (cur.containsVariable(it.name, false)){
				if (it.pRegId != null){
					it.regId = curBlock.regAlloca.alloc(5);
					Function func = new Function(IRFuncType.LOAD);
					func.regs.add(it.regId);
					func.regs.add(new Register(cur.getVariableID(it.name, false), 8, false));
					curBlock.funcs.add(func);
				//	it.inClass = true;
				} else{
					if (it.regId.gr == 11){
						Register tmp = curBlock.regAlloca.alloc(5);
						Function func = new Function(IRFuncType.LOAD);
						func.regs.add(tmp);
						func.regs.add(new Register(it.regId.id, 8, false));
						curBlock.funcs.add(func);

						Register regId = curBlock.regAlloca.alloc(5);
						func = new Function(IRFuncType.INDEX);
						func.regs.add(regId);
						func.regs.add(new Register(0, 1, false));
						func.regs.add(tmp);
						curBlock.funcs.add(func);

						it.regId = new Register(regId.id, regId.gr, true);
					}
				}
				break;
			}
			else if (cur.containsFunction(it.name, false)){
				if (it.pRegId != null){
					it.regId = it.pRegId;
				}
				break;
			}
			cur = cur.parentScope;
		}
    }

    @Override
    public void visit(stringExprNode it) {
    	it.regId = curBlock.regAlloca.alloc(5);
		Function func = new Function(IRFuncType.LOADSTRING);
		func.regs.add(it.regId);
		String s = it.val;
		func.regs.add(new Register(Blocks.addString(s.substring(1, s.length() - 1)), 9, false));
		curBlock.funcs.add(func);
    }
    
    @Override //*
    public void visit(boolExprNode it) {
    	it.regId = curBlock.regAlloca.alloc(5);
    	Function func = new Function(IRFuncType.LOAD);
		func.regs.add(it.regId);
		func.regs.add(new Register(it.val == true ? 1 : 0, 8, false));
		curBlock.funcs.add(func);
    }
    
    @Override //*
    public void visit(nullExprNode it) {
    	it.regId = curBlock.regAlloca.alloc(5);
		Function func = new Function(IRFuncType.LOAD);
		func.regs.add(it.regId);
		func.regs.add(new Register(0, 8, false));
		curBlock.funcs.add(func);
    }

	@Override
    public void visit(thisExprNode it) {
		it.regId = new Register(0, 1, false);
    }

    @Override
    public void visit(varDefStatNode it) {
    	it.vars.forEach(unit -> unit.accept(this));
    }

    @Override
    public void visit(exprsExprNode it) {}

    @Override
    public void visit(parenExprNode it) {}

    @Override
    public void visit(nullStatNode it) {}

    @Override
    public void visit(typeNode it) {}

    public int updCntLab() {
		return ++cntLab;
	}
}
