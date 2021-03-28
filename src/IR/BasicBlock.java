package IR;

import Util.RegIdAllocator;
import IR.Function.IRFuncType;

import java.util.ArrayList;

public class BasicBlock {
	public String name;
    public ArrayList<Function> funcs = new ArrayList<>();
    public boolean containsCALL = false;
    public int paramNum = 0, lab = 0, loc = 0;
    public RegIdAllocator regAlloca = null;

    public BasicBlock() {
    }

    public void printIR() {
        funcs.forEach(unit -> unit.printIR());
    }

	public void expand() {
		ArrayList<Function> curFuncs = new ArrayList<>();
		for (int i = 0; i < funcs.size(); i++) {
			Function tFunc = funcs.get(i);
			int j = 0;
			boolean fl = false;
			switch (tFunc.funcType) {
				default:
				case LW:
					j = 1;
				case BNEQ:
				case BEQ:
				case SW:
					for (; j < tFunc.regs.size(); j++) {
						Register regId = tFunc.regs.get(j);
						Function func;
						Register tmp = regAlloca.alloc(5);
						Register sec = regId;
						int g = regId.gr;
						if (g == 6)
							sec = new Register(regId.id, 5, false);
						switch (g) {
							case 1:
							case 4:
							case 6:
								func = new Function(IRFuncType.LW);
								func.regs.add(tmp);
								func.regs.add(sec);
								curFuncs.add(func);
								tFunc.regs.set(j, tmp);
								break;
							case 2:
								func = new Function(IRFuncType.LOAD);
								func.regs.add(tmp);
								func.regs.add(sec);
								curFuncs.add(func);
								func = new Function(IRFuncType.LW);
								func.regs.add(tmp);
								func.regs.add(sec);
								func.regs.add(tmp);
								curFuncs.add(func);
								tFunc.regs.set(j, tmp);
								break;
						}
					}
					break;
				case CALL:
					containsCALL = true;
					break;
				case RETURN:
				case FUNC:
				case LABEL:
				case JUMP:
			}
			if (!fl) curFuncs.add(tFunc);
			switch (tFunc.funcType) {
				default:
				case LW:
					Register regId = tFunc.regs.get(0);
					Function func;
					Register tmp = regAlloca.alloc(5);
					Register tmp2 = regAlloca.alloc(5);
					Register sec = regId;
					if (regId != null && regId.gr == 6)
						sec = new Register(regId.id, 5, false);
					if (regId != null)
					switch (regId.gr) {
						case 3:
							if (regId.id >= 6) {
								func = new Function(IRFuncType.SW);
								func.regs.add(tmp);
								Register an_tmp;
								if (regAlloca.size(7) < regId.id - 5) {
									an_tmp = regAlloca.alloc(7);
								}else an_tmp = new Register(regId.id - 6, 7, false);
								func.regs.add(an_tmp);
								curFuncs.add(func);
								tFunc.regs.set(0, tmp);
							}
							break;
						case 1:
						case 4:
						case 6:
							func = new Function(IRFuncType.SW);
							func.regs.add(tmp);
							func.regs.add(sec);
							curFuncs.add(func);
							tFunc.regs.set(0, tmp);
							break;
						case 2:
							func = new Function(IRFuncType.LOAD);
							func.regs.add(tmp2);
							func.regs.add(sec);
							curFuncs.add(func);
							func = new Function(IRFuncType.SW);
							func.regs.add(tmp);
							func.regs.add(sec);
							func.regs.add(tmp2);
							curFuncs.add(func);
							tFunc.regs.set(0, tmp);
							break;
					}
				case BNEQ:
				case BEQ:
				case FUNC:
				case LABEL:
				case JUMP:
				case CALL:
				case RETURN:
				case SW:
			}
		}
		funcs = curFuncs;
		loc = regAlloca.size(1);
	}
	public void expandLocal() {
		ArrayList<Function> curFuncs = new ArrayList<>();
		for (int i = 0; i < funcs.size(); i++) {
			Function tFunc = funcs.get(i);
			int j = 0;
			switch (tFunc.funcType) {
				default:
				case LW:
					j = 1;
				case BNEQ:
				case BEQ:
				case SW:
					for (; j < tFunc.regs.size(); j++) {
						Register regId = tFunc.regs.get(j);
						Function func;
						Register tmp;
						switch (regId.gr) {
							case 1:
								if (regId.id < loc)
									break;
								tmp = regAlloca.alloc(5);
								func = new Function(IRFuncType.LW);
								func.regs.add(tmp);
								func.regs.add(regId);
								curFuncs.add(func);
								tFunc.regs.set(j, tmp);
								break;
						}
					}
					break;
				case CALL:
				case RETURN:
				case FUNC:
				case LABEL:
				case JUMP:
			}
			curFuncs.add(tFunc);
			switch (tFunc.funcType) {
				default:
				case LW:
					Register regId = tFunc.regs.get(0);
					Function func;
					Register tmp;
					if (regId != null)
					switch (regId.gr) {
						case 1:
							if (regId.id < loc) break;
							tmp = regAlloca.alloc(5);
							func = new Function(IRFuncType.SW);
							func.regs.add(tmp);
							func.regs.add(regId);
							curFuncs.add(func);
							tFunc.regs.set(0, tmp);
							break;
					}
				case BNEQ:
				case BEQ:
				case FUNC:
				case LABEL:
				case JUMP:
				case CALL:
				case RETURN:
				case SW:
			}
		}
		funcs = curFuncs;
	}

	public int[] free_reg = new int [32];
	public int[] used, firUsed, lasUsed;
	public Register[] used_reg, regUsed;
	public int paramRAM;

	public int get_free_reg(int id) {
		for (int i = 0; i < 32; i++)
			if (free_reg[i] == 1) {
				boolean found = false;
				for (int j = firUsed[id]; j < lasUsed[id]; j++) {
					Function tFunc = funcs.get(j);
					if (tFunc.regs.size() > 0 && tFunc.regs.get(0).gr == 3 && tFunc.regs.get(0).id == i - 10) found=true;
				}
				if (!found) return i;
			}
		return 0;
	}
	public void easyAlloc(Function tFunc, int l, int r) {
		for (int j = l; j < r; j++) {
			Register regId = tFunc.regs.get(j), tmp;
			if (regId != null && regId.gr == 5) {
				if (used_reg[regId.id] == null) {
					if (regUsed[regId.id] != null) {
						tmp = regUsed[regId.id];
					}else{
						int t = get_free_reg(regId.id);
						if (t > 0) {
							free_reg[t] = 0;
							tmp = used_reg[regId.id] = new Register(t, 0, false);
						}else{
							tmp = regUsed[regId.id] = regAlloca.alloc(1);
						}
					}
				}else tmp = used_reg[regId.id];
				tmp.useId = regId.id;
				tFunc.regs.set(j, tmp);
			}
		}
	}
	public void easyRelease(Function tFunc, int l, int r) {
		for (int j = l; j < r; j++) {
			Register regId = tFunc.regs.get(j), tmp;
			if (regId != null && regId.useId != null) {
				if (regUsed[regId.useId] == null) {
					if (--used[regId.useId] == 0) {
						free_reg[used_reg[regId.useId].id] = 1;
					}
				}
			}
		}
	}

	public void alloc() {
		int tmp_size = regAlloca.size(5);
		used = new int [tmp_size];
		firUsed = new int [tmp_size];
		lasUsed = new int [tmp_size];
		for (int i = 0; i < funcs.size(); i++) {
			Function tFunc = funcs.get(i);
			for (int j = 0; j < tFunc.regs.size(); j++) {
				Register regId = tFunc.regs.get(j);
				if (regId != null && regId.gr == 5) {
					used[regId.id]++;
					if (firUsed[regId.id] == 0) firUsed[regId.id] = i;
					lasUsed[regId.id] = i;
				}
			}
		}
		used_reg = new Register [tmp_size];
		regUsed = new Register [tmp_size];
		for (int i = 0; i < 32; i++)
			free_reg[i] = (i >= 10 && i <= 15) ? 1 : 0;
		for (int i = 0; i < funcs.size(); i++) {
			Function tFunc = funcs.get(i);
			
			switch (tFunc.funcType) {
				default:
				case LW:
					easyAlloc(tFunc, 1, tFunc.regs.size());
					easyRelease(tFunc, 1, tFunc.regs.size());
					Register tmp = tFunc.regs.get(0);
					if (tmp != null && tmp.gr == 3) {
						if (tmp.id < 6) {
							free_reg[tmp.id + 10] = 0;
							tFunc.regs.set(0, new Register(tmp.id + 10, 0, false));
						}else{
							tFunc.regs.set(0, regAlloca.alloc(7));
						}
					}else{
						easyAlloc(tFunc, 0, 1);
						easyRelease(tFunc, 0, 1);
					}
					break;
				case BNEQ:
				case BEQ:
				case SW:
					easyAlloc(tFunc, 0, tFunc.regs.size());
					easyRelease(tFunc, 0, tFunc.regs.size());
					break;
				case CALL:
					for (int j = 0; j < tmp_size; j++) {
						if (used[j] > 0) {
							if (used_reg[j] != null) {
								Register new_reg = regAlloca.alloc(1);
								used_reg[j].id = new_reg.id;
								used_reg[j].gr = new_reg.gr;
								used_reg[j].pointer = new_reg.pointer;
								used[j] = 0;
							}
						}
					}
					for (int j = 10; j <= 15; j++) {
						free_reg[j] = 1;
					}
					break;
				case FUNC:
				case LABEL:
				case JUMP:
				case RETURN:
			}
		}
	}
	public void allocLocal() {
		int tmp_size = regAlloca.size(5);
		used = new int [tmp_size];
		firUsed = new int [tmp_size];
		lasUsed = new int [tmp_size];

		for (int i = 0; i < funcs.size(); i++) {
			Function tFunc = funcs.get(i);
			for (int j = 0; j < tFunc.regs.size(); j++) {
				Register regId = tFunc.regs.get(j);
				if (regId != null && regId.gr == 5) {
					used[regId.id]++;
					if (firUsed[regId.id] == 0) firUsed[regId.id] = 0;
					lasUsed[regId.id] = 0;
				}
			}
		}
		used_reg = new Register [tmp_size];
		regUsed = new Register [tmp_size];
		for (int i = 0; i < 32; i++) free_reg[i] = 0;
		for (int i = 16; i <= 17; i++) free_reg[i] = 1;
		for (int i = 0; i < funcs.size(); i++) {
			Function tFunc = funcs.get(i);
			switch (tFunc.funcType) {
				default:
				case LW:
					easyAlloc(tFunc, 1, tFunc.regs.size());
					easyRelease(tFunc, 1, tFunc.regs.size());
					easyAlloc(tFunc, 0, 1);
					easyRelease(tFunc, 0, 1);
					break;
				case BNEQ:
				case BEQ:
				case SW:
					easyAlloc(tFunc, 0, tFunc.regs.size());
					easyRelease(tFunc, 0, tFunc.regs.size());
					break;
				case CALL:
					for (int j = 16; j <= 17; j++) {
						free_reg[j] = 1;
					}
					break;
				case FUNC:
				case LABEL:
				case JUMP:
				case RETURN:
			}
		}
	}

	public void remove() {
		ArrayList<Function> curFuncs = new ArrayList<>();
		for (int i = 0; i < funcs.size(); i++) {
			Function tFunc = funcs.get(i);
			if (tFunc.funcType == IRFuncType.MOVE) {
				if (tFunc.regs.get(0).id == tFunc.regs.get(1).id) {
					continue;
				}
			}
			curFuncs.add(tFunc);
		}
		funcs = curFuncs;
	}

	public int totalRAM, realRAM, addrStartLocal;
	public void calcRAM() {
		totalRAM = regAlloca.size(1) + regAlloca.size(7) + 1;
		addrStartLocal = -4;
		if (containsCALL) {
			totalRAM++;
			addrStartLocal -= 4;
		}
		realRAM = ((totalRAM - 1) / 4 + 1) * 16;
	}

	public int addrLocal(int id) {
		return addrStartLocal + (id + 1) * -4;
	}
	public int addrParam(int id) {
		return id * 4;
	}

	public void printout() {
		System.out.println("\t.text");
		System.out.println("\t.align\t2");
		System.out.println("\t.globl\t" + name);
		System.out.println("\t.type\t" + name + ", @function");
		System.out.println(name + ":");
		System.out.println("\taddi\tsp,sp,-" + String.valueOf(realRAM));
		System.out.println("\tsw\ts0," + String.valueOf(realRAM - 4) + "(sp)");
		if (containsCALL)
			System.out.println("\tsw\tra," + String.valueOf(realRAM - 8) + "(sp)");
		System.out.println("\taddi\ts0,sp," + String.valueOf(realRAM));
		
        funcs.forEach(l -> l.printout(this));
		System.out.println(".LAB" + String.valueOf(lab) + ":");
		System.out.println("\tlw\ts0," + String.valueOf(realRAM - 4) + "(sp)");
		if (containsCALL)
			System.out.println("\tlw\tra," + String.valueOf(realRAM - 8) + "(sp)");
		System.out.println("\taddi\tsp,sp," + String.valueOf(realRAM));
		System.out.println("\tjr\tra");
		System.out.println("\t.size\t" + name + ", .-" + name);
	}
}
