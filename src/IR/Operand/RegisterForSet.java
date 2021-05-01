package IR.Operand;

import IR.Operand.Register;

public class RegisterForSet{
	public Register reg;
	public int pos;

	public RegisterForSet(Register reg, int pos) {
		this.reg = reg;
		this.pos = pos;
	}
}