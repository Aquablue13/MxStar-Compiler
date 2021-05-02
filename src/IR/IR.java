package IR;

import Optimize.GraphColoringRegAllocator;
import Optimize.SSAConstruction;
import IR.*;
import Backend.*;

import java.util.ArrayList;
import java.util.HashMap;

public class IR {
	public ArrayList<BasicBlock> blocks = new ArrayList<>();
	public ArrayList<String> strings = new ArrayList<>();
    public ArrayList<Integer> globals = new ArrayList<>();
    public HashMap<String, Integer> classSizs = new HashMap<>();
	public boolean haveNoReturn = false;

	public IR() {}

    public int addString(String s){
        strings.add(s);
        return strings.size() - 1;
    }

	public void print(){
        for (int i = 0; i < strings.size(); i++)
            System.out.println("STR(" + i + ") " + strings.get(i));
        for (int i = 0; i < globals.size(); i++)
            System.out.println("GLO(" + i + ") " + globals.get(i));
        blocks.forEach(unit -> unit.printIR());
    }

    public void accept(IRVisitor it){
        it.visit(this);
    }
}