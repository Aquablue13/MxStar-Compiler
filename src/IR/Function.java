package IR;

import java.util.ArrayList;

public class Function {
    public enum IRFuncType{
    	EQ, NEQ, GE, GEQ, LE, LEQ, NEG, NOT, LOGICNOT,
    	ADD, SUB, MUL, DIV, MOD, OR, AND, XOR, SHL, SHR,
		BNEQ, BEQ, ADDI, LW, SW,
		FUNC, LABEL, MOVE, JUMP, CALL,
		INDEX, LOAD, LOADSTRING, RETURN
	}
	public IRFuncType funcType;

	public String func = null;
	public int label = 0;
    public ArrayList<Register> regs = new ArrayList<>();

    public Function(IRFuncType funcType) {
        this.funcType = funcType;
    }

    public Function(IRFuncType funcType, String func) {
        this.funcType = funcType;
        this.func = func;
    }

	public void printIR(){
		String name = funcType.toString();
		if (name.equals("FUNC") || name.equals("LABEL")) {
			System.out.print(name);
			if (label > 0){
				System.out.print("(");
				System.out.print(label);
				System.out.print(")");
			}
			if (name.equals("FUNC") && func != null)
				System.out.print(" " + func);
		}
		else {
			System.out.print("\t");
			System.out.print(name);
		}
		for (Register reg : regs){
			if (reg != null)
				System.out.print(" " + reg.name());
		}
		System.out.println();
	}

	public void printout(BasicBlock block){
		String name = funcType.toString();
		name = name.toLowerCase();
		switch (funcType){
			case FUNC: break;
			case LABEL:
				System.out.println(".LAB" + String.valueOf(label) + ":");
				break;
			case MOVE:
				System.out.print("\tmv\t");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.println(regs.get(1).toASM());
				break;
			case JUMP:
				System.out.println("\tj\t" + ".LAB" + String.valueOf(label));
				break;
			case CALL:
				System.out.println("\tcall\t" + func);
				break;
			case BNEQ:
				System.out.print("\tbeq\t");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.print(regs.get(1).toASM() + ",");
				System.out.println(".LAB" + String.valueOf(label));
				break;
			case BEQ:
				System.out.print("\tbne\t");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.print(regs.get(1).toASM() + ",");
				System.out.println(".LAB" + String.valueOf(label));
				break;
			case NEG:
				System.out.print("\tneg\t");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.println(regs.get(1).toASM());
				break;
			case NOT:
				System.out.print("\tnot\t");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.println(regs.get(1).toASM());
				break;
			case LOGICNOT:
				System.out.print("\tseqz\t");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.println(regs.get(1).toASM());
				break;
			case NEQ:
				System.out.print("\tsub\t");
				System.out.print(regs.get(1).toASM() + ",");
				System.out.print(regs.get(1).toASM() + ",");
				System.out.println(regs.get(2).toASM());
				System.out.print("\tsnez\t");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.println(regs.get(1).toASM());
				break;
			case EQ:
				System.out.print("\tsub\t");
				System.out.print(regs.get(1).toASM() + ",");
				System.out.print(regs.get(1).toASM() + ",");
				System.out.println(regs.get(2).toASM());
				System.out.print("\tseqz\t");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.println(regs.get(1).toASM());
				break;
			case GE:
				System.out.print("\tsgt\t");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.print(regs.get(1).toASM() + ",");
				System.out.println(regs.get(2).toASM());
				break;
			case LE:
				System.out.print("\tslt\t");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.print(regs.get(1).toASM() + ",");
				System.out.println(regs.get(2).toASM());
				break;
			case GEQ:
				System.out.print("\tslt\t");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.print(regs.get(1).toASM() + ",");
				System.out.println(regs.get(2).toASM());
				System.out.print("\txori\t");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.println(1);
				break;
			case LEQ:
				System.out.print("\tsgt\t");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.print(regs.get(1).toASM() + ",");
				System.out.println(regs.get(2).toASM());
				System.out.print("\txori\t");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.println(1);
				break;
			case ADD:
				System.out.print("\tadd\t");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.print(regs.get(1).toASM() + ",");
				System.out.println(regs.get(2).toASM());
				break;
			case SUB:
				System.out.print("\tsub\t");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.print(regs.get(1).toASM() + ",");
				System.out.println(regs.get(2).toASM());
				break;
			case MUL:
				System.out.print("\tmul\t");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.print(regs.get(1).toASM() + ",");
				System.out.println(regs.get(2).toASM());
				break;
			case DIV:
				System.out.print("\tdiv\t");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.print(regs.get(1).toASM() + ",");
				System.out.println(regs.get(2).toASM());
				break;
			case MOD:
				System.out.print("\trem\t");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.print(regs.get(1).toASM() + ",");
				System.out.println(regs.get(2).toASM());
				break;
			case OR:
				System.out.print("\tor\t");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.print(regs.get(1).toASM() + ",");
				System.out.println(regs.get(2).toASM());
				break;
			case AND:
				System.out.print("\tand\t");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.print(regs.get(1).toASM() + ",");
				System.out.println(regs.get(2).toASM());
				break;
			case XOR:
				System.out.print("\txor\t");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.print(regs.get(1).toASM() + ",");
				System.out.println(regs.get(2).toASM());
				break;
			case SHL:
				System.out.print("\tsll\t");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.print(regs.get(1).toASM() + ",");
				System.out.println(regs.get(2).toASM());
				break;
			case SHR:
				System.out.print("\tsra\t");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.print(regs.get(1).toASM() + ",");
				System.out.println(regs.get(2).toASM());
				break;
			case INDEX:
				System.out.print("\tslli\t");
				System.out.print(regs.get(2).toASM() + ",");
				System.out.print(regs.get(2).toASM() + ",");
				System.out.println(2);
				System.out.print("\tadd\t");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.print(regs.get(1).toASM() + ",");
				System.out.println(regs.get(2).toASM());
				break;
			case LOADSTRING:
			case LOAD:
				switch (regs.get(1).gr){
					case 2:
						System.out.print("\tlui\t");
						System.out.print(regs.get(0).toASM() + ",");
						System.out.println("%hi(" + regs.get(1).toGASM() + ")");
						break;
					case 8:
						System.out.print("\tli\t");
						System.out.print(regs.get(0).toASM() + ",");
						System.out.println(regs.get(1).id);
						break;
					case 9:
						System.out.print("\tlui\t");
						System.out.print(regs.get(0).toASM() + ",");
						System.out.println("%hi(" + regs.get(1).toSASM() + ")");
						System.out.print("\taddi\t");
						System.out.print(regs.get(0).toASM() + ",");
						System.out.print(regs.get(0).toASM() + ",");
						System.out.println("%lo(" + regs.get(1).toSASM() + ")");
						break;
				}
				break;
			case RETURN: System.out.print("\tRETURN"); break;
			case ADDI:
				System.out.print("\taddi\t");
				System.out.print(regs.get(0).toASM() + ",");
				System.out.print(regs.get(1).toASM() + ",");
				System.out.println(regs.get(2).id);
				break;
			case SW:
				System.out.print("\tsw\t");
				System.out.print(regs.get(0).toASM() + ",");
				switch (regs.get(1).gr){
					case 0:
						System.out.print(0);
						System.out.println("(" + regs.get(1).toASM() + ")");
						break;
					case 1:
						System.out.print(block.addrLocal(regs.get(1).id));
						System.out.println("(s0)");
						break;
					case 2:
						System.out.print("%lo(" + regs.get(1).toGASM() + ")");
						System.out.println("(" + regs.get(2).toASM() + ")");
						break;
					case 4:
						System.out.print(block.addrParam(regs.get(1).id));
						System.out.println("(s0)");
						break;
					case 7:
						System.out.print(block.addrParam(regs.get(1).id));
						System.out.println("(sp)");
						break;
				}
				break;
			case LW:
				System.out.print("\tlw\t");
				System.out.print(regs.get(0).toASM() + ",");
				switch (regs.get(1).gr){
					case 0:
						System.out.print(0);
						System.out.println("(" + regs.get(1).toASM() + ")");
						break;
					case 1:
						System.out.print(block.addrLocal(regs.get(1).id));
						System.out.println("(s0)");
						break;
					case 2:
						System.out.print("%lo(" + regs.get(1).toGASM() + ")");
						System.out.println("(" + regs.get(2).toASM() + ")");
						break;
					case 4:
						System.out.print(block.addrParam(regs.get(1).id));
						System.out.println("(s0)");
						break;
				}
				break;
		}
	}
}
