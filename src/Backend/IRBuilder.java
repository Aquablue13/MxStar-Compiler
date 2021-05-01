package Backend;

import AST.*;
import Util.Scope;
import Util.Type.*;
import Util.Error.semanticError;
import Util.globalScope;
import IR.*;
import IR.Operand.Register;
import IR.Instruction.*;
import IR.Instruction.BranchInst.BranchOp;
import IR.Instruction.IcmpInst.IcmpOp;
import IR.Instruction.ArithInst.ArithOp;
import IR.Instruction.BranchInst.BranchOp;
import IR.Instruction.BitwiseInst.BitwiseOp;
import IR.Instruction.LoadInst.LoadOp;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class IRBuilder implements ASTVisitor {
    private Scope localScope;
    private globalScope globalScope;
    private ArrayList<ASTNode> vars = new ArrayList<>();
    private boolean fl = false;
    private classType curClass = null;
    private IR Blocks;
	private BasicBlock curBlock;
	private int cntLab = 0;
	private int loopStart = 0, loopEnd = 0, loopCont = 0;
	private int ifElse = 0, ifEnd = 0;

    public IRBuilder(IR Blocks, globalScope globalScope) {
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
    /*	if (it.scope.classInfo != null)
            funcName = it.scope.classInfo.name + "." + it.name;
        else*/
        funcName = (it.scope.getFunctionType(it.name, true)).funcName;
		curBlock = new BasicBlock();
		curBlock.name = funcName;
		curBlock.lab = updCntLab();
		curBlock.id = Blocks.blocks.size() - 1;
		curBlock.regAlloca = it.scope.regAlloca;
		Blocks.blocks.add(curBlock);
		IRInst inst = new FuncInst(funcName);
		curBlock.insts.add(inst);

		if (curClass == null) {
			for (int i = 0; i < it.parameters.size(); i++) {
				inst =  new MoveInst();
				inst.regs.add(it.parameters.get(i).regId);
				if (i < 6) inst.regs.add(new Register(i + 10, 0, false));
				else inst.regs.add(new Register(i - 6, 4, false));
				curBlock.insts.add(inst);
			}
			fl = true;
			if (it.name.equals("main"))
				vars.forEach(unit -> unit.accept(this));
			fl = false;
			it.block.accept(this);
			if (it.name.equals("main") && Blocks.haveNoReturn) {
				inst = new MoveInst();
				inst.regs.add(new Register(10, 0, false));
				inst.regs.add(new Register(0, 0, false));
				curBlock.insts.add(inst);
				inst = new BranchInst(BranchOp.jump);
				inst.label = curBlock.lab;
				curBlock.insts.add(inst);
			}
		} else {
			Register curReg = new Register(0, 1, false);
			inst = new MoveInst();
			inst.regs.add(curReg);
			inst.regs.add(new Register(10, 0, false));
			curBlock.insts.add(inst);
			for (int i = 0; i < it.parameters.size(); i++) {
				inst = new MoveInst();
				inst.regs.add(it.parameters.get(i).regId);
				if (i < 7) inst.regs.add(new Register(i + 11, 0, false));
				else inst.regs.add(new Register(i - 7, 4, false));
				curBlock.insts.add(inst);
			}
			curBlock.regNum = it.parameters.size() + 1;
			it.block.accept(this);
		}
		inst = new LabelInst();
		inst.label = curBlock.lab;
		curBlock.insts.add(inst);
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
				
				IRInst inst = new MoveInst();
				inst.regs.add(it.scope.getRegIdVariable(it.name, false));
				inst.regs.add(it.expr.regId);
				curBlock.insts.add(inst);
			}
		}
    }

    @Override
    public void visit(returnStatNode it) {
        if (it.val != null) {
            it.val.accept(this);
			IRInst inst = new MoveInst();
			inst.regs.add(new Register(10, 0, false));
			inst.regs.add(it.val.regId);
			curBlock.insts.add(inst);
        }
		IRInst inst = new BranchInst(BranchOp.jump);
		inst.label = curBlock.lab;
		curBlock.insts.add(inst);
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
		IRInst inst = new BranchInst(BranchOp.jump);
		inst.label = loopEnd;
		curBlock.insts.add(inst);
    }
	
	@Override
    public void visit(continueStatNode it) {
		IRInst inst = new BranchInst(BranchOp.jump);
		inst.label = loopCont;
		curBlock.insts.add(inst);
    }

	@Override
    public void visit(whileStatNode it) {
		int tLoopStart = loopStart, tLoopEnd = loopEnd;
		int tLoopCont = loopCont;
		loopCont = loopStart = updCntLab();
		loopEnd = updCntLab();

		IRInst inst = new LabelInst();
		inst.label = loopStart;
		curBlock.insts.add(inst);

        if (it.cond != null) {
			it.cond.accept(this);

			inst = new BranchInst(BranchOp.bneq);
			inst.regs.add(it.cond.regId);
			inst.regs.add(new Register(0, 0, false));
			inst.label = loopEnd;
			curBlock.insts.add(inst);
		}

		it.body.accept(this);

		inst = new BranchInst(BranchOp.jump);
		inst.label = loopStart;
		curBlock.insts.add(inst);
		inst = new LabelInst();
		inst.label = loopEnd;
		curBlock.insts.add(inst);

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
        IRInst inst;
        if (it.cond.regId.cst){
			if (it.cond.regId.val == 0){
				inst = new BranchInst(BranchOp.jump);
				if (it.falseStat != null) inst.label = ifElse;
				else inst.label = ifEnd;
				curBlock.insts.add(inst);
			}
		}
		else {
			inst = new BranchInst(BranchOp.bneq);
			inst.regs.add(it.cond.regId);
			inst.regs.add(new Register(0, 0, false));
			if (it.falseStat != null)
				inst.label = ifElse;
			else
				inst.label = ifEnd;
			curBlock.insts.add(inst);
		}

        if (it.trueStat != null) {
			it.trueStat.accept(this);

			if (it.falseStat != null) {
				inst = new BranchInst(BranchOp.jump);
				inst.label = ifEnd;
				curBlock.insts.add(inst);
			}
		}
        if (it.falseStat != null) {
			inst = new LabelInst();
			inst.label = ifElse;
			curBlock.insts.add(inst);
			
			it.falseStat.accept(this);
		}

		inst = new LabelInst();
		inst.label = ifEnd;
		curBlock.insts.add(inst);

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
		IRInst inst = new LabelInst();
		inst.label = loopStart;
		curBlock.insts.add(inst);

        if (it.cond != null) {
			it.cond.accept(this);

			inst = new BranchInst(BranchOp.bneq);
			inst.regs.add(it.cond.regId);
			inst.regs.add(new Register(0, 0, false));
			inst.label = loopEnd;
			curBlock.insts.add(inst);
		}
		if (it.body != null) it.body.accept(this);
		inst = new LabelInst();
		inst.label = loopCont;
		curBlock.insts.add(inst);
        if (it.change != null) it.change.accept(this);
		
		inst = new BranchInst(BranchOp.jump);
		inst.label = loopStart;
		curBlock.insts.add(inst);
		inst = new LabelInst();
		inst.label = loopEnd;
		curBlock.insts.add(inst);

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
				IRInst inst = new MoveInst();
				inst.regs.add(new Register(i + t, 3, false));
				inst.regs.add(it.parameters.get(i).regId);
				curBlock.insts.add(inst);
			}
		}

		if (t == 1) {
			if (it.head.parent != null) {
				IRInst inst = new MoveInst();
				inst.regs.add(new Register(0, 3, false));
				inst.regs.add(it.head.regId);
				curBlock.insts.add(inst);
			}else{
				IRInst inst = new MoveInst();
				inst.regs.add(new Register(0, 3, false));
				inst.regs.add(new Register(0, 1, false));
				curBlock.insts.add(inst);
			}
		}
		IRInst inst = new CallInst();
		if (t == 0)
			inst.funcName = name;
		else
			inst.funcName = (it.scope.getFunctionType(name, true)).funcName;
		// !!
		curBlock.insts.add(inst);

		it.regId = curBlock.regAlloca.alloc(5);
		inst = new MoveInst();
		inst.regs.add(it.regId);
		inst.regs.add(new Register(10, 0, false));
		curBlock.insts.add(inst);

    }

    @Override
    public void visit(assignExprNode it) {
        it.num2.accept(this);
        it.num1.accept(this);

		IRInst inst = new MoveInst();
		inst.regs.add(it.num1.regId);
		inst.regs.add(it.num2.regId);
		curBlock.insts.add(inst);

		it.regId = it.num1.regId;
    }
	
	@Override
    public void visit(suffixExprNode it) {
        it.num.accept(this);

		it.regId = curBlock.regAlloca.alloc(5);
		IRInst inst = new MoveInst();
		inst.regs.add(it.regId);
		inst.regs.add(it.num.regId);
		curBlock.insts.add(inst);

		inst = new ArithInst(ArithOp.addi);
		inst.regs.add(it.num.regId);
		inst.regs.add(it.num.regId);
		switch (it.op) {
			case "++":
				inst.regs.add(new Register(1, 8, false));
				break;
			case "--":
				inst.regs.add(new Register(-1, 8, false));

		}
		curBlock.insts.add(inst);
    }
	
    @Override
    public void visit(prefixExprNode it) {
        it.num.accept(this);
		IRInst inst;
		switch (it.op) {
			case "++":
				it.regId = it.num.regId;
				inst = new ArithInst(ArithOp.addi);
				inst.regs.add(it.regId);
				inst.regs.add(it.regId);
				inst.regs.add(new Register(1, 8, false));
				curBlock.insts.add(inst);
				break;
			case "--":
				it.regId = it.num.regId;
				inst = new ArithInst(ArithOp.addi);
				inst.regs.add(it.regId);
				inst.regs.add(it.regId);
				inst.regs.add(new Register(-1, 8, false));
				curBlock.insts.add(inst);
				break;
			case "+":
				it.regId = it.num.regId;
				break;
			case "-":
				it.regId = curBlock.regAlloca.alloc(5);
				inst = new BitwiseInst(BitwiseOp.neg);
				inst.regs.add(it.regId);
				inst.regs.add(it.num.regId);
				curBlock.insts.add(inst);
				break;
			case "~":
				it.regId = curBlock.regAlloca.alloc(5);
				inst = new BitwiseInst(BitwiseOp.not);
				inst.regs.add(it.regId);
				inst.regs.add(it.num.regId);
				curBlock.insts.add(inst);
				break;
			case "!":
				it.regId = curBlock.regAlloca.alloc(5);
				inst = new BitwiseInst(BitwiseOp.lnot);
				inst.regs.add(it.regId);
				inst.regs.add(it.num.regId);
				curBlock.insts.add(inst);
		}
    }

    @Override //*
    public void visit(binaryExprNode it) {
		it.regId = curBlock.regAlloca.alloc(5);
		IRInst inst = null;
		switch (it.op) {
			case "&&":
				it.num1.accept(this);
				int pos = curBlock.insts.size();
				it.num2.accept(this);
				if (it.num1.regId.cst && it.num2.regId.cst){
					Register regId = new Register(
						it.num1.regId.val & it.num2.regId.val, 8, false);
					regId.cst = true;
					regId.val = regId.id;
					inst = new LoadInst(LoadOp.load);	
					inst.regs.add(it.regId);
					inst.regs.add(regId);
					curBlock.insts.add(inst);
					it.regId.cst_agn(regId);
					return;
				}

				int short_circuit = updCntLab(), expr_end = updCntLab();

				inst = new BranchInst(BranchOp.bneq);
				inst.regs.add(it.num1.regId);
				inst.regs.add(new Register(0, 0, false));
				inst.label = short_circuit;
				curBlock.insts.add(pos, inst);

				inst = new BranchInst(BranchOp.bneq);
				inst.regs.add(it.num2.regId);
				inst.regs.add(new Register(0, 0, false));
				inst.label = short_circuit;
				curBlock.insts.add(inst);

				inst = new LoadInst(LoadOp.load);
				inst.regs.add(it.regId);
				inst.regs.add(new Register(1, 8, false));
				curBlock.insts.add(inst);
				inst = new BranchInst(BranchOp.jump);
				inst.label = expr_end;
				curBlock.insts.add(inst);
				inst = new LabelInst();
				inst.label = short_circuit;
				curBlock.insts.add(inst);
				inst = new LoadInst(LoadOp.load);
				inst.regs.add(it.regId);
				inst.regs.add(new Register(0, 8, false));
				curBlock.insts.add(inst);
				inst = new LabelInst();
				inst.label = expr_end;
				curBlock.insts.add(inst);
				return;
			case "||":
				short_circuit = updCntLab();
				expr_end = updCntLab();

				it.num1.accept(this);
				inst = new BranchInst(BranchOp.beq);
				inst.regs.add(it.num1.regId);
				inst.regs.add(new Register(0, 0, false));
				inst.label = short_circuit;
				curBlock.insts.add(inst);

				it.num2.accept(this);
				inst = new BranchInst(BranchOp.beq);
				inst.regs.add(it.num2.regId);
				inst.regs.add(new Register(0, 0, false));
				inst.label = short_circuit;
				curBlock.insts.add(inst);
				
				inst = new LoadInst(LoadOp.load);
				inst.regs.add(it.regId);
				inst.regs.add(new Register(0, 8, false));
				curBlock.insts.add(inst);
				inst = new BranchInst(BranchOp.jump);
				inst.label = expr_end;
				curBlock.insts.add(inst);
				inst = new LabelInst();
				inst.label = short_circuit;
				curBlock.insts.add(inst);
				inst = new LoadInst(LoadOp.load);
				inst.regs.add(it.regId);
				inst.regs.add(new Register(1, 8, false));
				curBlock.insts.add(inst);
				inst = new LabelInst();
				inst.label = expr_end;
				curBlock.insts.add(inst);

				return;
		}
        it.num1.accept(this);
        it.num2.accept(this);
		if (it.num1.type.isString && it.num2.type.isString) {
			inst = new MoveInst();
			inst.regs.add(new Register(1, 3, false));
			inst.regs.add(it.num2.regId);
			curBlock.insts.add(inst);
			inst = new MoveInst();
			inst.regs.add(new Register(0, 3, false));
			inst.regs.add(it.num1.regId);
			curBlock.insts.add(inst);
			switch (it.op) {
				case "==":
					inst = new CallInst();
					inst.funcName = "my_string_eq";
					curBlock.insts.add(inst);
					break;
				case "!=":
					inst = new CallInst();
					inst.funcName = "my_string_neq";
					curBlock.insts.add(inst);
					break;
				case ">":
					inst = new CallInst();
					inst.funcName = "my_string_ge";
					curBlock.insts.add(inst);
					break;
				case ">=":
					inst = new CallInst();
					inst.funcName = "my_string_geq";
					curBlock.insts.add(inst);
					break;
				case "<":
					inst = new CallInst();
					inst.funcName = "my_string_le";
					curBlock.insts.add(inst);
					break;
				case "<=":
					inst = new CallInst();
					inst.funcName = "my_string_leq";
					curBlock.insts.add(inst);
					break;
				case "+":
					inst = new CallInst();
					inst.funcName = "my_string_plus";
					curBlock.insts.add(inst);
					break;
			}
			inst = new MoveInst();
			inst.regs.add(it.regId);
			inst.regs.add(new Register(10, 0, false));
			curBlock.insts.add(inst);
			return;
		}
		boolean flag = it.num1.regId.cst && it.num2.regId.cst;
		if (flag) {
			Register regId;
			switch (it.op) {
				case "==":
					regId = new Register(
						(it.num1.regId.val == it.num2.regId.val) ? 1 : 0, 8, false);
					break;
				case "!=":
					regId = new Register(
						(it.num1.regId.val != it.num2.regId.val) ? 1 : 0, 8, false);
					break;
				case ">":
					regId = new Register(
						(it.num1.regId.val > it.num2.regId.val) ? 1 : 0, 8, false);
					break;
				case ">=":
					regId = new Register(
						(it.num1.regId.val >= it.num2.regId.val) ? 1 : 0, 8, false);
					break;
				case "<":
					regId = new Register(
						(it.num1.regId.val < it.num2.regId.val) ? 1 : 0, 8, false);
					break;
				case "<=":
					regId = new Register(
						(it.num1.regId.val <= it.num2.regId.val) ? 1 : 0, 8, false);
					break;
				case "+":
					regId = new Register(
						it.num1.regId.val + it.num2.regId.val, 8, false);
					break;
				case "|":
					regId = new Register(
						it.num1.regId.val | it.num2.regId.val, 8, false);
					break;
				case "&":
					regId = new Register(
						it.num1.regId.val & it.num2.regId.val, 8, false);
					break;
				case "-":
					regId = new Register(
						it.num1.regId.val - it.num2.regId.val, 8, false);
					break;
				case "^":
					regId = new Register(
						it.num1.regId.val ^ it.num2.regId.val, 8, false);
					break;
				case "<<":
					regId = new Register(
						it.num1.regId.val << it.num2.regId.val, 8, false);
					break;
				case ">>":
					regId = new Register(
						it.num1.regId.val >> it.num2.regId.val, 8, false);
					break;
				case "*":
					regId = new Register(
						it.num1.regId.val * it.num2.regId.val, 8, false);
					break;
				case "/":
					regId = new Register(
						(it.num2.regId.val != 0) ? it.num1.regId.val / it.num2.regId.val : 114514, 8, false);
					break;
				case "%":
					regId = new Register(
						(it.num2.regId.val != 0) ? it.num1.regId.val % it.num2.regId.val : 1919810, 8, false);
					break;
				default:
					regId = null;
			}
			regId.cst = true;
			regId.val = regId.id;
			inst = new LoadInst(LoadOp.load);	
			inst.regs.add(it.regId);
			inst.regs.add(regId);
			curBlock.insts.add(inst);
			it.regId.cst_agn(regId);
			return;
		}
		switch (it.op) {
			case "==":
				inst = new IcmpInst(IcmpOp.seq);
				break;
			case "!=":
				inst = new IcmpInst(IcmpOp.sne);
				break;
			case ">":
				inst = new IcmpInst(IcmpOp.sgt);
				break;
			case ">=":
				inst = new IcmpInst(IcmpOp.sge);
				break;
			case "<":
				inst = new IcmpInst(IcmpOp.slt);
				break;
			case "<=":
				inst = new IcmpInst(IcmpOp.sle);
				break;
			case "+":
				inst = new ArithInst(ArithOp.add);
				break;
			case "|":
				inst = new BitwiseInst(BitwiseOp.or);
				break;
			case "&":
				inst = new BitwiseInst(BitwiseOp.and);
				break;
			case "-":
				inst = new ArithInst(ArithOp.sub);
				break;
			case "^":
				inst = new BitwiseInst(BitwiseOp.xor);
				break;
			case "<<":
				inst = new BitwiseInst(BitwiseOp.shl);
				break;
			case ">>":
				inst = new BitwiseInst(BitwiseOp.shr);
				break;
			case "*":
				inst = new ArithInst(ArithOp.mul);
				break;
			case "/":
				inst = new ArithInst(ArithOp.div);
				break;
			case "%":
				inst = new ArithInst(ArithOp.rem);
		}
		inst.regs.add(it.regId);
		inst.regs.add(it.num1.regId);
		inst.regs.add(it.num2.regId);
		curBlock.insts.add(inst);
    }
	
	@Override //*
    public void visit(subscriptExprNode it) {
		it.head.accept(this);
		it.index.accept(this);
		Register tmp = curBlock.regAlloca.alloc(5);
		IRInst inst = new ArithInst(ArithOp.addi);
		inst.regs.add(tmp);
		inst.regs.add(it.index.regId);
		inst.regs.add(new Register(1, 8, false));
		curBlock.insts.add(inst);
		Register regId = curBlock.regAlloca.alloc(5);
		inst = new IndexInst();
		inst.regs.add(regId);
		inst.regs.add(it.head.regId);
		inst.regs.add(tmp);
		curBlock.insts.add(inst);

		it.regId = new Register(regId.id, regId.gr, true);
	}
	
	@Override
    public void visit(memberExprNode it) {
		it.head.accept(this);
		it.member.pRegId = it.head.regId;
		it.member.accept(this);
		if (it.member.inClass){
			Register regId = curBlock.regAlloca.alloc(5);
			IRInst inst = new IndexInst();
			inst.regs.add(regId);
			inst.regs.add(it.head.regId);
			inst.regs.add(it.member.regId);
			curBlock.insts.add(inst);

			it.regId = new Register(regId.id, regId.gr, true);
		}else{
			it.regId = it.head.regId;
		}
	}

	public Register newMalloc(creatorExprNode it, int i) {
		if (i >= it.exprs.size()) {
			if ((it.type instanceof classType) || Blocks.classSizs.containsKey(it.typeNode.typeName) && it.exprs.size() == ((arrayType)it.type).dim) {
				IRInst inst = new LoadInst(LoadOp.load);
				inst.regs.add(new Register(0, 3, false));
				inst.regs.add(new Register(Blocks.classSizs.get(it.typeNode.typeName) << 2, 8, false));
				curBlock.insts.add(inst);
				
				inst = new CallInst();
				inst.funcName = "malloc";
				curBlock.insts.add(inst);

				Register nowRegId = curBlock.regAlloca.alloc(5);
				inst = new MoveInst();
				inst.regs.add(nowRegId);
				inst.regs.add(new Register(10, 0, false));
				curBlock.insts.add(inst);

				Scope tmp_scope = globalScope.getScopeFromName(it.typeNode.typeName);
				if (tmp_scope.containsFunction(it.typeNode.typeName, false)) {

					inst = new CallInst();
					inst.funcName = it.typeNode.typeName + "." + it.typeNode.typeName;
					curBlock.insts.add(inst);
				};
				return nowRegId;
			}else{
				return new Register(0, 0, false);
			}
		}
		Register iter = curBlock.regAlloca.alloc(1);
		Register nowRegId = curBlock.regAlloca.alloc(1);
		Register ttmp = curBlock.regAlloca.alloc(5);
		IRInst inst = new MoveInst();
		inst.regs.add(iter);
		inst.regs.add(it.exprs.get(i).regId);
		curBlock.insts.add(inst);

		inst = new MoveInst();
		inst.regs.add(ttmp);
		inst.regs.add(it.exprs.get(i).regId);
		curBlock.insts.add(inst);

		inst = new MoveInst();
		inst.regs.add(new Register(10, 0, false));
		inst.regs.add(ttmp);
		curBlock.insts.add(inst);

		inst = new CallInst();
		inst.funcName = "my_array_alloc";
		curBlock.insts.add(inst);
		inst = new MoveInst();
		inst.regs.add(nowRegId);
		inst.regs.add(new Register(10, 0, false));
		curBlock.insts.add(inst);


		if (i < it.exprs.size() - 1 ||
			(it.type instanceof classType) || Blocks.classSizs.containsKey(it.typeNode.typeName) && it.exprs.size() == ((arrayType)it.type).dim) {
			int loopStart = updCntLab(), loopEnd = updCntLab();
			inst = new LabelInst();
			inst.label = loopStart;
			curBlock.insts.add(inst);
			inst = new BranchInst(BranchOp.bneq);
			inst.regs.add(iter);
			inst.regs.add(new Register(0, 0, false));
			inst.label = loopEnd;
			curBlock.insts.add(inst);

			Register next_result = newMalloc(it, i + 1);

			if (!next_result.equals(new Register(0, 0, false))){
				Register result = curBlock.regAlloca.alloc(5);
				inst = new IndexInst();
				inst.regs.add(result);
				inst.regs.add(nowRegId);
				inst.regs.add(iter);
				curBlock.insts.add(inst);
		
				inst = new MoveInst();
				inst.regs.add(new Register(result.id, result.gr, true));
				inst.regs.add(next_result);
				curBlock.insts.add(inst);
			}

			inst = new ArithInst(ArithOp.addi);
			inst.regs.add(iter);
			inst.regs.add(iter);
			inst.regs.add(new Register(-1, 8, false));
			curBlock.insts.add(inst);
			inst = new BranchInst(BranchOp.jump);
			inst.label = loopStart;
			curBlock.insts.add(inst);

			inst = new LabelInst();
			inst.label = loopEnd;
			curBlock.insts.add(inst);
		}

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
		IRInst inst = new LoadInst(LoadOp.load);
		Register regId = new Register(it.val, 8, false);
    	regId.cst = true;
    	regId.val = it.val;
		inst.regs.add(it.regId);
		inst.regs.add(regId);
		curBlock.insts.add(inst);
		it.regId.cst_agn(regId);
    }

    @Override
    public void visit(identifierExprNode it) {
    	Scope cur = it.scope;
		while (cur != null){
			if (cur.containsVariable(it.name, false)){
				if (it.pRegId != null){
					it.regId = curBlock.regAlloca.alloc(5);
					IRInst inst = new LoadInst(LoadOp.load);
					inst.regs.add(it.regId);
					inst.regs.add(new Register(cur.getVariableID(it.name, false), 8, false));
					curBlock.insts.add(inst);
					it.inClass = true;
				} else{
					if (it.regId.gr == 11){
						Register tmp = curBlock.regAlloca.alloc(5);
						IRInst inst = new LoadInst(LoadOp.load);
						inst.regs.add(tmp);
						inst.regs.add(new Register(it.regId.id, 8, false));
						curBlock.insts.add(inst);

						Register regId = curBlock.regAlloca.alloc(5);
						inst = new IndexInst();
						inst.regs.add(regId);
						inst.regs.add(new Register(0, 1, false));
						inst.regs.add(tmp);
						curBlock.insts.add(inst);

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
		IRInst inst = new LoadInst(LoadOp.loadstr);
		inst.regs.add(it.regId);
		String s = it.val;
		Register regId = new Register(Blocks.addString(s.substring(1, s.length() - 1)), 9, false);
		inst.regs.add(regId);
		curBlock.insts.add(inst);
		it.regId.cst_agn(regId);
    }
    
    @Override //*
    public void visit(boolExprNode it) {
    	it.regId = curBlock.regAlloca.alloc(5);
    	IRInst inst = new LoadInst(LoadOp.load);
    	Register regId = new Register(it.val == true ? 1 : 0, 8, false);
    	regId.cst = true;
    	regId.val = it.val == true ? 1 : 0;
		inst.regs.add(it.regId);
		inst.regs.add(regId);
		curBlock.insts.add(inst);
		it.regId.cst_agn(regId);
    }
    
    @Override //*
    public void visit(nullExprNode it) {
    	it.regId = curBlock.regAlloca.alloc(5);
		IRInst inst = new LoadInst(LoadOp.load);
		Register regId = new Register(0, 8, false);
    	regId.cst = true;
    	regId.val = 0;
		inst.regs.add(it.regId);
		inst.regs.add(regId);
		curBlock.insts.add(inst);
		it.regId.cst_agn(regId);
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
		return curBlock.labelAlloc();
	}
}
