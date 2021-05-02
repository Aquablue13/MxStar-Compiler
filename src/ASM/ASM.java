package ASM;

import Optimize.*;
import IR.*;

import java.util.ArrayList;
import java.util.HashMap;

public class ASM {
	public IR ir;

	public ASM(IR ir) {
		this.ir = ir;
	}

	public void trans(){
		ir.getDAG();
		ir.blocks.forEach(b -> {
			b.init();
			new AddImm(b).work();
			new MergeImm(b).work();
		});
		ir.blocks.forEach(b -> {
			new SSAConstruction(b).work();
			b.exp();
		});
		ir.blocks.forEach(b -> new ADCE(b).work());
		ir.blocks.forEach(b -> new LICM(b).work());
		ir.blocks.forEach(b -> new GraphColoringRegAllocator(b).main());
		ir.blocks.forEach(b -> b.dowloc());
	}
}
