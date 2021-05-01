package ASM;

import Optimize.GraphColoringRegAllocator;
import Optimize.SSAConstruction;
import IR.*;

import java.util.ArrayList;
import java.util.HashMap;

public class ASM {
	public IR ir;

	public ASM(IR ir) {
		this.ir = ir;
	}

	public void trans(){
		ir.blocks.forEach(b -> {
			b.init();
			new SSAConstruction(b).work();
			b.exp();
		});
		ir.blocks.forEach(b -> new GraphColoringRegAllocator(b).main());
		ir.blocks.forEach(b -> {
			b.dowloc();
		//	b.calcRAM();
		});
	}
}
