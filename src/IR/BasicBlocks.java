package IR;

import java.util.ArrayList;
import java.util.HashMap;

public class BasicBlocks {
	public ArrayList<BasicBlock> blocks = new ArrayList<>();
	public ArrayList<String> strings = new ArrayList<>();
    public ArrayList<Integer> globals = new ArrayList<>();
    public HashMap<String, Integer> classSizs = new HashMap<>();
	public boolean haveNoReturn = false;

	public BasicBlocks() {}

    public int addString(String s){
        strings.add(s);
        return strings.size() - 1;
    }

	public void init(){
		blocks.forEach(unit -> unit.expand());
		blocks.forEach(unit -> unit.alloc());
		blocks.forEach(unit -> unit.expandLocal());
		blocks.forEach(unit -> unit.allocLocal());
		blocks.forEach(unit -> unit.remove());
		blocks.forEach(unit -> unit.calcRAM());
	}

	public void print(){
        for (int i = 0; i < strings.size(); i++)
            System.out.println("STRING(" + i + ") " + strings.get(i));
        for (int i = 0; i < globals.size(); i++)
            System.out.println("GLOBAL(" + i + ") " + globals.get(i));
        blocks.forEach(unit -> unit.printIR());
    }

	public void printout(){
		if (strings.size() > 0 || globals.size() > 0)
			System.out.println("\t.text");
		for (int i = 0; i < strings.size(); i++){
			if (i == 0)
				System.out.println("\t.section\t.rodata");
			System.out.println("\t.align\t2");
			System.out.println(".LS" + i + ":");
			System.out.print("\t.string\t");
			System.out.println("\"" + strings.get(i) + "\"");
		}
		for (int i = 0; i < globals.size(); i++){
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
		blocks.forEach(unit -> unit.printout());
	}
}
