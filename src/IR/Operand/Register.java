package IR.Operand;

public class Register{
	String nameStr = "LGPFTTLiSQC";
	public int id, gr, val;
	public boolean pointer, mult = false, cst = false;
	public Integer useId = null;
	
	public Register(int id, int gr, boolean pointer){
		this.id = id;
		this.gr = (pointer ? 6 : gr);
		this.pointer = pointer;
	}

	public boolean dcec() {
		return (gr == 5 || gr == 0 || gr == 2 || gr == 7);
	}

	public boolean spec() {
		return (gr == 5);
	}

	public void assign(Register other){
		id = other.id;
		gr = other.gr;
		mult = other.mult;
	}
	public void cst_agn(Register other){
		cst = other.cst;
		val = other.val;
	}
	public boolean equals(Register other){
		if (other == null)
			return false;
		return id == other.id && gr == other.gr;
	}

	public String name(){
		String ans = "";
		if (gr == 6)
			ans = "*";
		if (gr == 7)
			ans = "LP";
		else
			if (gr == 12)
				ans = "SP";
			else {
				if (gr > 0)
					ans = ans + nameStr.charAt(gr - 1);
			}
		ans += id;
		return ans;
	}

	public String toGASM(){
		return ".G" + String.valueOf(id);
	}

	public String toSASM(){
		return ".LS" + String.valueOf(id);
	}

	public String toASM(){
		switch (id) {
			case 0: return "zero";
			case 1: return "ra";
			case 2: return "sp";
			case 3: return "gp";
			case 4: return "tp";
			case 5: return "t0";
			case 6: return "t1";
			case 7: return "t2";
			case 8: return "s0";
			case 9: return "s1";
			case 10: return "a0";
			case 11: return "a1";
			case 12: return "a2";
			case 13: return "a3";
			case 14: return "a4";
			case 15: return "a5";
			case 16: return "a6";
			case 17: return "a7";
			case 18: return "s2";
			case 19: return "s3";
			case 20: return "s4";
			case 21: return "s5";
			case 22: return "s6";
			case 23: return "s7";
			case 24: return "s8";
			case 25: return "s9";
			case 26: return "s10";
			case 27: return "s11";
			case 28: return "t3";
			case 29: return "t4";
			case 30: return "t5";
			case 31: return "t6";
		}
		return null;
	}
}