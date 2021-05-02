package IR;

import IR.Instruction.*;
import IR.Instruction.LoadInst.LoadOp;
import Backend.IRVisitor;
import Util.RegIdAllocator;
import IR.Operand.RegisterForSet;
import IR.Operand.Register;

import java.util.ArrayList;

public class BasicBlock {
	public String name;
    public ArrayList<IRInst> insts = new ArrayList<>();
    public boolean containsCALL = false;
    public int paramNum = 0, lab = 0;
    public int regNum = 0, cntLab = 0, id, spillNum = 0;
    public int totRAM, realRAM, locHead;
    public RegIdAllocator regAlloca = null;

    public BasicBlock() {}

    public int labelAlloc(){
		return ++cntLab;
	}

	public int addrLocal(int p) {
		return locHead - (p + 1) * 4;
	}
	public int addrParam(int p) {
		return p * 4;
	}

    public void printIR() {
        insts.forEach(unit -> System.out.println(unit.toString()));
    }

	public void exp() {
		ArrayList<IRInst> curInsts = new ArrayList<>();
		for (int i = 0; i < insts.size(); i++) {
			IRInst tInst = insts.get(i);
			if (tInst instanceof CallInst)
				containsCALL = true;
			int j;
			for (RegisterForSet treg : tInst.uses()) {
				Register regId = treg.reg;
				j = treg.pos;
				IRInst inst;
				Register tmp = regAlloca.alloc(5);
				Register sec = regId;
				int g = regId.gr;
				if (g == 6)
					sec = new Register(regId.id, 5, false);
				switch (g) {
					case 1:
					case 4:
						IRInst ttInst = new LoadInst(LoadOp.lw);
						ttInst.regs = tInst.regs;
						tInst = ttInst;
						break;
					case 6:
						inst = new LoadInst(LoadOp.lw);
						inst.regs.add(tmp);
						inst.regs.add(sec);
						curInsts.add(inst);
						tInst.regs.set(j, tmp);
						break;
					case 2:
						if (tInst.expanded) break;
						inst = new LoadInst(LoadOp.load);
						inst.regs.add(tmp);
						inst.regs.add(sec);
						curInsts.add(inst);
						inst = new LoadInst(LoadOp.lw);
						inst.regs.add(tmp);
						inst.regs.add(sec);
						inst.regs.add(tmp);
						curInsts.add(inst);
						tInst.regs.set(j, tmp);
						break;
				}
			}
			curInsts.add(tInst);
			if (!(tInst instanceof StoreInst || tInst instanceof BranchInst || tInst instanceof FuncInst ||
				  tInst instanceof LabelInst || tInst instanceof CallInst)) {
				Register regId = tInst.regs.get(0);
				IRInst inst;
				Register tmp = regAlloca.alloc(5);
				Register tmp2 = regAlloca.alloc(5);
				Register sec = regId;
				if (regId != null && regId.gr == 6)
					sec = new Register(regId.id, 5, false);
				if (regId != null)
				switch (regId.gr) {
					case 3:
						if (regId.id >= 8) {
							inst = new StoreInst();
							inst.regs.add(tmp);
							Register an_tmp;
							while (regAlloca.size(7) < regId.id - 7) {
								an_tmp = regAlloca.alloc(7);
							}
								an_tmp = new Register(regId.id - 8, 7, false);
								inst.regs.add(an_tmp);
								curInsts.add(inst);
								tInst.regs.set(0, tmp);
							}
							else {
								tInst.regs.set(0, new Register(regId.id + 10, 0, false));
							}
							break;
						case 1:
						case 4:
						case 6:
							inst = new StoreInst();
							inst.regs.add(tmp);
							inst.regs.add(sec);
							curInsts.add(inst);
							tInst.regs.set(0, tmp);
							break;
						case 2:
							if (tInst.expanded)
								break;
							inst = new LoadInst(LoadOp.load);
							inst.regs.add(tmp2);
							inst.regs.add(sec);
							curInsts.add(inst);
							inst = new StoreInst();
							inst.regs.add(tmp);
							inst.regs.add(sec);
							inst.regs.add(tmp2);
							curInsts.add(inst);
							tInst.regs.set(0, tmp);
							break;
					}
				}
		}
		insts = curInsts;
	}

	public int[] free_reg = new int [32];
	public int[] used, firUsed, lasUsed;
	public Register[] used_reg, regUsed;
	public int paramRAM;

	public void localloc(IRInst tInst, int l, int r) {
		for (int j = l; j < r; j++) {
			Register regId = tInst.regs.get(j), tmp;
			if (regId != null && regId.gr == 5) {
				if (used_reg[regId.id] == null) {
					if (regUsed[regId.id] != null) {
						tmp = regUsed[regId.id];
					}else{
						int t = 0;
						for (int i = 0; i < 32; i++) {
							if (free_reg[i] == 1) {
								boolean found = false;
								for (int k = firUsed[regId.id]; k < lasUsed[regId.id]; k++) {
									IRInst ttInst = insts.get(k);
									if (ttInst.regs.size() > 0 && ttInst.regs.get(0).gr == 3 && ttInst.regs.get(0).id == i - 10)
										found = true;
								}
								if (!found) {
									t = i;
									break;
								}
							}
						}
						if (t > 0) {
							free_reg[t] = 0;
							tmp = used_reg[regId.id] = new Register(t, 0, false);
						}else{
							tmp = regUsed[regId.id] = regAlloca.alloc(1);
						}
					}
				}else tmp = used_reg[regId.id];
				tmp.useId = regId.id;
				tInst.regs.set(j, tmp);
			}
		}
	}

	public void locrele(IRInst tInst, int l, int r) {
		for (int j = l; j < r; j++) {
			Register regId = tInst.regs.get(j), tmp;
			if (regId != null && regId.useId != null) {
				if (regUsed[regId.useId] == null) {
					if (--used[regId.useId] == 0) {
						free_reg[used_reg[regId.useId].id] = 1;
					}
				}
			}
		}
	}

	public void dowloc() {
		ArrayList<IRInst> curInsts = new ArrayList<>();
		for (int i = 0; i < insts.size(); i++) {
			IRInst tInst = insts.get(i);
			int j;
			for (RegisterForSet treg : tInst.uses()) {
				Register regId = treg.reg;
				if (regId.gr != 12)
					continue;
				j = treg.pos;
				Register tmp = regAlloca.alloc(5);
				IRInst inst = new LoadInst(LoadOp.lw);
				inst.regs.add(tmp);
				inst.regs.add(regId);
				curInsts.add(inst);
				tInst.regs.set(j, tmp);
			}
			curInsts.add(tInst);
			/*!(tInst instanceof StoreInst || tInst instanceof BranchInst || tInst instanceof FuncInst ||
				  tInst instanceof LabelInst || tInst instanceof CallInst)*/
			if (!tInst.defs().isEmpty()) {
				Register regId = tInst.regs.get(0);
				if (regId.gr != 12)
					continue;
				IRInst inst = new StoreInst();
				Register tmp = regAlloca.alloc(5);
				inst.regs.add(tmp);
				inst.regs.add(regId);
				curInsts.add(inst);
				tInst.regs.set(0, tmp);
			}
		}
		insts = curInsts;

		int tmp_size = regAlloca.size(5);
		used = new int [tmp_size];
		firUsed = new int [tmp_size];
		lasUsed = new int [tmp_size];

		for (int i = 0; i < insts.size(); i++) {
			IRInst tInst = insts.get(i);
			for (int j = 0; j < tInst.regs.size(); j++) {
				Register regId = tInst.regs.get(j);
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
		for (int i = 30; i <= 31; i++) free_reg[i] = 1;
		for (int i = 0; i < insts.size(); i++) {
			IRInst tInst = insts.get(i);
			if (tInst instanceof FuncInst || tInst instanceof LabelInst || tInst.op().equals("jump")){
			} else
			if (tInst instanceof CallInst) {
				for (int j = 30; j <= 31; j++)
					free_reg[j] = 1;
			} else
			if (tInst instanceof BranchInst || tInst instanceof StoreInst) {
				localloc(tInst, 0, tInst.regs.size());
				locrele(tInst, 0, tInst.regs.size());
			}
			else {
				localloc(tInst, 1, tInst.regs.size());
				locrele(tInst, 1, tInst.regs.size());
				localloc(tInst, 0, 1);
				locrele(tInst, 0, 1);
			}
		}
		totRAM = regAlloca.size(12) + regAlloca.size(7) + spillNum;
		locHead = -4 * spillNum; // store s*
		if (containsCALL){
			totRAM++;
			locHead -= 4; // store ra
		}
		realRAM = ((totRAM - 1) / 4 + 1) * 16;
	}

	public int vis_now;
	public int[] vis, toJp, toLab;
	public void upd(){
		toJp = new int[insts.size()];
		toLab = new int[cntLab + 1];
		for (int i = 0; i < insts.size(); i++){
			IRInst tInst = insts.get(i);
			if (tInst instanceof LabelInst){
				toLab[tInst.label] = i;
			}
		}
		for (int i = 0; i < insts.size(); i++){
			IRInst tInst = insts.get(i);
			if (tInst instanceof BranchInst){
				if (tInst.calling) toJp[i] = toLab[0];
				else toJp[i] = toLab[tInst.label];
			}
		}
	}

	public void init(){
		ArrayList<IRInst> curInsts = new ArrayList<>();
		ArrayList<IRInst> lParam = new ArrayList<>();
		containsCALL = false;
		Register call_result = null;
		for (int i = 0; i < insts.size(); i++){
			IRInst inst = insts.get(i);
			if (inst instanceof CallInst){
				if (inst.block != null &&
					inst.block.insts.size() <= 200 && inst.block.containsCALL == false &&
					inst.block != this){
					Register[] t_id = new Register [inst.block.regAlloca.size(5)];
					Integer[] l_id = new Integer [inst.block.cntLab];
					int j = 1, paramid = 0;
					for (;paramid < lParam.size(); paramid++){
						IRInst param_line = inst.block.insts.get(j);
						Register paramReg = lParam.get(lParam.size() - paramid - 1).regs.get(1);
						if (paramReg.gr == 2){
							Register tmp = regAlloca.alloc(5);
							IRInst updInst = new MoveInst();
							updInst.regs.add(tmp);
							updInst.regs.add(paramReg);
							curInsts.add(updInst);
							paramReg = tmp;
						}
						t_id[param_line.regs.get(0).id] = paramReg;
						j++;
					}
					lParam.clear();
					call_result = regAlloca.alloc(5);
					for (;j < inst.block.insts.size(); j++){
						IRInst befInst = inst.block.insts.get(j);
						IRInst updInst = befInst;
						updInst.regs = new ArrayList<>();
						if (befInst instanceof FuncInst);
						else{
							if (befInst instanceof BranchInst || befInst instanceof LabelInst){
									if (l_id[befInst.label] == null){
										l_id[befInst.label] = labelAlloc();
									}
									updInst.label = l_id[befInst.label];
								}
							for (int k = 0; k < befInst.regs.size(); k++){
								Register regId = befInst.regs.get(k);
								if (regId.gr == 5){
									if (t_id[regId.id] == null){
										t_id[regId.id] = regAlloca.alloc(5);
									}
									regId = t_id[regId.id];
								}
								updInst.regs.add(regId);
							}
							if (befInst instanceof MoveInst){
								if (befInst.regs.get(0).gr == 0 && befInst.regs.get(0).id == 10){
									updInst.regs.set(0, call_result);
								}
							}
							updInst.funcName = befInst.funcName;
							updInst.expanded = true;
							curInsts.add(updInst);
						}
					}
				}else{
					containsCALL = true;
					if (lParam.size() > 0){
						curInsts.addAll(lParam);
						lParam.clear();
					}
					curInsts.add(inst);
				}
			}else{
				if (inst instanceof MoveInst){
					if (inst.regs.get(0).gr == 3){
						lParam.add(inst);
					}
					else
					if (call_result != null && inst.regs.get(1).gr == 0 && inst.regs.get(1).id == 10){
						inst.regs.set(1, call_result);
						curInsts.add(inst);
						call_result = null;
					}
					else{
						curInsts.add(inst);
					}
				}else{
					curInsts.add(inst);
				}
			}
		}
		insts = curInsts;
		upd();
	}

	public void prePrint() {
		System.out.println("\t.text");
		System.out.println("\t.align\t2");
		System.out.println("\t.globl\t" + name);
		System.out.println("\t.type\t" + name + ", @function");
		System.out.println(name + ":");

		System.out.println("\taddi\tsp,sp,-" + String.valueOf(realRAM));
		for (int i = 0; i < spillNum; i++)
			System.out.println("\tsw\ts" + i + "," + (realRAM - 4 * (i + 1)) + "(sp)");
		if (containsCALL)
			System.out.println("\tsw\tra," + String.valueOf(realRAM - 4 - 4 * spillNum) + "(sp)");		
	}

	public void endPrint() {
		for (int i = 0; i < spillNum; i++)
			System.out.println("\tlw\ts" + i + "," + (realRAM - 4 * (i + 1)) + "(sp)");
		if (containsCALL) System.out.println("\tlw\tra," + String.valueOf(realRAM - 4 - 4 * spillNum) + "(sp)");
		System.out.println("\taddi\tsp,sp," + String.valueOf(realRAM));
		System.out.println("\tjr\tra");
		
		System.out.println("\t.size\t" + name + ", .-" + name);
	}

	public void accept(IRVisitor it){
        it.visit(this);
    }
}
