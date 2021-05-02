package Backend;

import IR.Operand.Register;
import IR.Instruction.*;
import IR.Instruction.BranchInst.BranchOp;
import IR.Instruction.IcmpInst.IcmpOp;
import IR.Instruction.ArithInst.ArithOp;
import IR.Instruction.BranchInst.BranchOp;
import IR.Instruction.BitwiseInst.BitwiseOp;
import IR.Instruction.LoadInst.LoadOp;
import ASM.*;
import IR.*;
import Backend.IRVisitor;

public class InstSelector implements IRVisitor{
	ASM asm;

	public void run(ASM asm) {
		this.asm = asm;
		new ASMPrinter(asm).work();
		asm.ir.accept(this);
	}

	@Override
	public void visit(IR it) {
		it.blocks.forEach(unit -> unit.accept(this));
	}

	@Override
	public void visit(BasicBlock it) {
		it.prePrint();
		it.insts.forEach(unit -> unit.pBlock = it);
		it.insts.forEach(unit -> unit.accept(this));
		it.endPrint();
	}

	@Override
	public void visit(ArithInst it) {
		switch (it.op) {
			case add:
				System.out.print("\tadd\t");
				System.out.print(it.regs.get(0).toASM() + ",");
				System.out.print(it.regs.get(1).toASM() + ",");
				System.out.println(it.regs.get(2).toASM());
				break;
			case sub:
				System.out.print("\tsub\t");
				System.out.print(it.regs.get(0).toASM() + ",");
				System.out.print(it.regs.get(1).toASM() + ",");
				System.out.println(it.regs.get(2).toASM());
				break;
			case mul:
				System.out.print("\tmul\t");
				System.out.print(it.regs.get(0).toASM() + ",");
				System.out.print(it.regs.get(1).toASM() + ",");
				System.out.println(it.regs.get(2).toASM());
				break;
			case div:
				System.out.print("\tdiv\t");
				System.out.print(it.regs.get(0).toASM() + ",");
				System.out.print(it.regs.get(1).toASM() + ",");
				System.out.println(it.regs.get(2).toASM());
				break;
			case rem:
				System.out.print("\trem\t");
				System.out.print(it.regs.get(0).toASM() + ",");
				System.out.print(it.regs.get(1).toASM() + ",");
				System.out.println(it.regs.get(2).toASM());
				break;
			case addi:
				if (it.regs.get(2).id > 2000 || it.regs.get(2).id < -2000){
					System.out.println("\tli\tt6," + it.regs.get(2).id);
					System.out.print("\tadd\t");
					System.out.print(it.regs.get(0).toASM() + ",");
					System.out.print(it.regs.get(1).toASM() + ",");
					System.out.println("t6");
				}
				else {
					System.out.print("\taddi\t");
					System.out.print(it.regs.get(0).toASM() + ",");
					System.out.print(it.regs.get(1).toASM() + ",");
					System.out.println(it.regs.get(2).id);
				}
				break;
			case muli:
				System.out.println("\tli\tt6," + it.regs.get(2).id);
				System.out.print("\tmul\t");
				System.out.print(it.regs.get(0).toASM() + ",");
				System.out.print(it.regs.get(1).toASM() + ",");
				System.out.println("t6");
				break;
		}
	}

	@Override
	public void visit(BitwiseInst it) {
		switch (it.op) {
			case and:
				System.out.print("\tand\t");
				System.out.print(it.regs.get(0).toASM() + ",");
				System.out.print(it.regs.get(1).toASM() + ",");
				System.out.println(it.regs.get(2).toASM());
				break;
			case or:
				System.out.print("\tor\t");
				System.out.print(it.regs.get(0).toASM() + ",");
				System.out.print(it.regs.get(1).toASM() + ",");
				System.out.println(it.regs.get(2).toASM());
				break;
			case xor:
				System.out.print("\txor\t");
				System.out.print(it.regs.get(0).toASM() + ",");
				System.out.print(it.regs.get(1).toASM() + ",");
				System.out.println(it.regs.get(2).toASM());
				break;
			case shl:
				System.out.print("\tsll\t");
				System.out.print(it.regs.get(0).toASM() + ",");
				System.out.print(it.regs.get(1).toASM() + ",");
				System.out.println(it.regs.get(2).toASM());
				break;
			case shr:
				System.out.print("\tsra\t");
				System.out.print(it.regs.get(0).toASM() + ",");
				System.out.print(it.regs.get(1).toASM() + ",");
				System.out.println(it.regs.get(2).toASM());
				break;
			case andi:
				if (it.regs.get(2).id > 2000 || it.regs.get(2).id < -2000){
					System.out.println("\tli\tt6," + it.regs.get(2).id);
					System.out.print("\tand\t");
					System.out.print(it.regs.get(0).toASM() + ",");
					System.out.print(it.regs.get(1).toASM() + ",");
					System.out.println("t6");
				}else{
					System.out.print("\tandi\t");
					System.out.print(it.regs.get(0).toASM() + ",");
					System.out.print(it.regs.get(1).toASM() + ",");
					System.out.println(it.regs.get(2).id);
				}
				break;
			case not:
				System.out.print("\tnot\t");
				System.out.print(it.regs.get(0).toASM() + ",");
				System.out.println(it.regs.get(1).toASM());
				break;
			case neg:
				System.out.print("\tneg\t");
				System.out.print(it.regs.get(0).toASM() + ",");
				System.out.println(it.regs.get(1).toASM());
				break;
			case lnot:
				System.out.print("\tseqz\t");
				System.out.print(it.regs.get(0).toASM() + ",");
				System.out.println(it.regs.get(1).toASM());
				break;
		}
	}

	@Override
	public void visit(BranchInst it) {
		switch (it.op) {
			case jump:
				System.out.println("\tj\t" + ".b" + it.pBlock.id + "l" + it.label);
				break;
			case beq:
				System.out.print("\tbne\t");
				System.out.print(it.regs.get(0).toASM() + ",");
				System.out.print(it.regs.get(1).toASM() + ",");
				System.out.println(".b" + it.pBlock.id + "l" + it.label);
				break;
			case bneq:
				System.out.print("\tbeq\t");
				System.out.print(it.regs.get(0).toASM() + ",");
				System.out.print(it.regs.get(1).toASM() + ",");
				System.out.println(".b" + it.pBlock.id + "l" + it.label);
				break;
		}
	}

	@Override
	public void visit(IndexInst it) {
		System.out.print("\tslli\t");
		System.out.print("t6,");
		System.out.print(it.regs.get(2).toASM() + ",");
		System.out.println(2);
		System.out.print("\tadd\t");
		System.out.print(it.regs.get(0).toASM() + ",");
		System.out.print(it.regs.get(1).toASM() + ",");
		System.out.println("t6");
	}

	@Override
	public void visit(CallInst it) {
		System.out.println("\tcall\t" + it.funcName);
	}

	@Override
	public void visit(FuncInst it) {
	}

	@Override
	public void visit(IcmpInst it) {
		switch (it.op) {
			case seq:
				System.out.print("\tsub\t");
				System.out.print("t5,");
				System.out.print(it.regs.get(1).toASM() + ",");
				System.out.println(it.regs.get(2).toASM());
				System.out.print("\tseqz\t");
				System.out.print(it.regs.get(0).toASM() + ",");
				System.out.println("t5");
				break;
			case sne:
				System.out.print("\tsub\t");
				System.out.print("t5,");
				System.out.print(it.regs.get(1).toASM() + ",");
				System.out.println(it.regs.get(2).toASM());
				System.out.print("\tsnez\t");
				System.out.print(it.regs.get(0).toASM() + ",");
				System.out.println("t5");
				break;
			
			case sgt:
				System.out.print("\tsgt\t");
				System.out.print(it.regs.get(0).toASM() + ",");
				System.out.print(it.regs.get(1).toASM() + ",");
				System.out.println(it.regs.get(2).toASM());
				break;
			case sge:
				System.out.print("\tslt\t");
				System.out.print(it.regs.get(0).toASM() + ",");
				System.out.print(it.regs.get(1).toASM() + ",");
				System.out.println(it.regs.get(2).toASM());
				System.out.print("\txori\t");
				System.out.print(it.regs.get(0).toASM() + ",");
				System.out.print(it.regs.get(0).toASM() + ",");
				System.out.println(1);
				break;

			case slt:
				System.out.print("\tslt\t");
				System.out.print(it.regs.get(0).toASM() + ",");
				System.out.print(it.regs.get(1).toASM() + ",");
				System.out.println(it.regs.get(2).toASM());
				break;
			case sle:
				System.out.print("\tsgt\t");
				System.out.print(it.regs.get(0).toASM() + ",");
				System.out.print(it.regs.get(1).toASM() + ",");
				System.out.println(it.regs.get(2).toASM());
				System.out.print("\txori\t");
				System.out.print(it.regs.get(0).toASM() + ",");
				System.out.print(it.regs.get(0).toASM() + ",");
				System.out.println(1);
				break;

			case seqi:
				if (it.regs.get(2).id > 2000 || it.regs.get(2).id < -2000){
					System.out.println("\tli\tt6," + it.regs.get(2).id);
					System.out.print("\tadd\t");
					System.out.print("t5" + ",");
					System.out.print(it.regs.get(1).toASM() + ",");
					System.out.println("t6");
					System.out.print("\tseqz\t");
					System.out.print(it.regs.get(0).toASM() + ",");
					System.out.println("t5");
				}else{
					System.out.print("\taddi\t");
					System.out.print("t5" + ",");
					System.out.print(it.regs.get(1).toASM() + ",");
					System.out.println(it.regs.get(2).id);
					System.out.print("\tseqz\t");
					System.out.print(it.regs.get(0).toASM() + ",");
					System.out.println("t5");
				}
				break;

			case slti:
				if (it.regs.get(2).id > 2000 || it.regs.get(2).id < -2000){
					System.out.println("\tli\tt6," + it.regs.get(2).id);
					System.out.print("\tslt\t");
					System.out.print(it.regs.get(0).toASM() + ",");
					System.out.print(it.regs.get(1).toASM() + ",");
					System.out.println("t6");
				}else{
					System.out.print("\tslti\t");
					System.out.print(it.regs.get(0).toASM() + ",");
					System.out.print(it.regs.get(1).toASM() + ",");
					System.out.println(it.regs.get(2).id);
				}
				break;
		}
	}

	@Override
	public void visit(LabelInst it) {
		System.out.println(".b" + it.pBlock.id + "l" + it.label + ":");
	}

	@Override
	public void visit(LoadInst it) {
		switch (it.op) {
			case load:
			case loadstr:
				switch (it.regs.get(1).gr){
					case 2:
						System.out.print("\tlui\t");
						System.out.print(it.regs.get(0).toASM() + ",");
						System.out.println("%hi(" + it.regs.get(1).toGASM() + ")");
						break;
					case 8:
						System.out.print("\tli\t");
						System.out.print(it.regs.get(0).toASM() + ",");
						System.out.println(it.regs.get(1).id);
						break;
					case 9:
						System.out.print("\tlui\t");
						System.out.print(it.regs.get(0).toASM() + ",");
						System.out.println("%hi(" + it.regs.get(1).toSASM() + ")");
						System.out.print("\taddi\t");
						System.out.print(it.regs.get(0).toASM() + ",");
						System.out.print(it.regs.get(0).toASM() + ",");
						System.out.println("%lo(" + it.regs.get(1).toSASM() + ")");
						break;
				}
				break;
			default:
				System.out.print("\tlw\t");
				System.out.print(it.regs.get(0).toASM() + ",");
				switch (it.regs.get(1).gr){
					case 0:
						System.out.print(0);
						System.out.println("(" + it.regs.get(1).toASM() + ")");
						break;
					case 12:
						System.out.print(it.pBlock.addrLocal(it.regs.get(1).id) + it.pBlock.realRAM);
						System.out.println("(sp)");
						break;
					case 2:
						System.out.print("%lo(" + it.regs.get(1).toGASM() + ")");
						System.out.println("(" + it.regs.get(2).toASM() + ")");
						break;
					case 4:
						System.out.print(it.pBlock.addrParam(it.regs.get(1).id) + it.pBlock.realRAM);
						System.out.println("(sp)");
						break;
				}
				break;
		}
	}

	@Override
	public void visit(StoreInst it) {
		System.out.print("\tsw\t");
		System.out.print(it.regs.get(0).toASM() + ",");
		switch (it.regs.get(1).gr){
			case 0:
				System.out.print(0);
				System.out.println("(" + it.regs.get(1).toASM() + ")");
				break;
			case 12:
				System.out.print(it.pBlock.addrLocal(it.regs.get(1).id) + it.pBlock.realRAM);
				System.out.println("(sp)");
				break;
			case 2:
				System.out.print("%lo(" + it.regs.get(1).toGASM() + ")");
				System.out.println("(" + it.regs.get(2).toASM() + ")");
				break;
			case 4:
				System.out.print(it.pBlock.addrParam(it.regs.get(1).id) + it.pBlock.realRAM);
				System.out.println("(sp)");
				break;
			case 7:
				System.out.print(it.pBlock.addrParam(it.regs.get(1).id));
				System.out.println("(sp)");
				break;
		}
	}

	@Override
	public void visit(MoveInst it) {
		System.out.print("\tmv\t");
		System.out.print(it.regs.get(0).toASM() + ",");
		System.out.println(it.regs.get(1).toASM());
	}
}