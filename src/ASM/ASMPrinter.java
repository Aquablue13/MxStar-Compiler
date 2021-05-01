package ASM;

import java.util.ArrayList;
import java.util.HashMap;
import IR.*;
import Backend.*;

public class ASMPrinter {
	public ASM asm;

	public ASMPrinter(ASM asm) {
		this.asm = asm;
	}

	public void printStr() {
		for (int i = 0; i < asm.ir.strings.size(); i++){
			if (i == 0)
				System.out.println("\t.section\t.rodata");
			System.out.println("\t.align\t2");
			System.out.println(".LS" + i + ":");
			System.out.print("\t.string\t");
			System.out.println("\"" + asm.ir.strings.get(i) + "\"");
		}
	}

	public void printGlo() {
		for (int i = 0; i < asm.ir.globals.size(); i++){
			String s = ".G" + String.valueOf(i);
			System.out.println("\t.globl\t" + s);
			if (i == 0)
				System.out.println("\t.section\t.sbss,\"aw\",@nobits");
			System.out.println("\t.align\t2");
			System.out.println("\t.type\t" + s + ", @object");
			System.out.println("\t.size\t" + s + ", 4");
			System.out.println(s + ":");
			System.out.println("\t.zero\t4");
		}
	}

	public void work(){
		if (asm.ir.strings.size() > 0 || asm.ir.globals.size() > 0)
			System.out.println("\t.text");
		printStr();
		printGlo();
	}

}