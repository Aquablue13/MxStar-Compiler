package IR.Instruction;

import IR.Operand.Register;
import IR.Operand.RegisterForSet;
import IR.*;
import Backend.*;

import java.util.ArrayList;
import java.util.HashSet;

abstract public class IRInst {
//	public String instName = null;
	public String funcName = null;
	public BasicBlock block = null, pBlock;
	public ArrayList<Register> regs = new ArrayList<>();
	public int label = 0, add_up = 0;
	public boolean expanded = false, calling = false, ignored = false;
	
	public IRInst(){}

	abstract public String op();

	abstract public String toString();

	abstract public boolean isTerminal();

	abstract public HashSet<RegisterForSet> uses();

	abstract public HashSet<RegisterForSet> defs();

	abstract public void accept(IRVisitor it);
}