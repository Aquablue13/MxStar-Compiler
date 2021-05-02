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

    public int addString(String s) {
        strings.add(s);
        return strings.size() - 1;
    }

	public void print() {
        for (int i = 0; i < strings.size(); i++)
            System.out.println("STR(" + i + ") " + strings.get(i));
        for (int i = 0; i < globals.size(); i++)
            System.out.println("GLO(" + i + ") " + globals.get(i));
        blocks.forEach(unit -> unit.printIR());
    }
/*
    int ArrayList<ArrayList<Integer>> to, rto;
    int [] d;
    int n;
    HashMap<String, int> Id;

    void addEdge() {

    }

    void pre() {
        n = blocks.size();
        d = new int[n];
        to = new ArrayList<>();
        for (int i = 0; i < n; i++) 
            to.add(new ArrayList<>());
        rto = new ArrayList<>();
        for (int i = 0; i < n; i++) 
            rto.add(new ArrayList<>());
        Id = new HashMap<>();
        for (int i = 0; i < n; i++)
            Id.put(blocks.insts.get(0).funcName, i);
    }

    public void getDAG() {
        ArrayList<BasicBlock> curBlocks = new ArrayList<>();
        
        

    }
*/
    public void accept(IRVisitor it) {
        it.visit(this);
    }
}
