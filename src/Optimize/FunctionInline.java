package Optimize;

import IR.*;
import IR.IR;
import IR.BasicBlock;
import IR.Instruction.*;
import IR.Operand.RegisterForSet;
import IR.Operand.Register;

import java.util.*;

public class FunctionInline {
	public BasicBlock curBlock;

	public FunctionInline(BasicBlock block) {
		curBlock = block;
	}
}