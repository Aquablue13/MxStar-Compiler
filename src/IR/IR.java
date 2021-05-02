package IR;

import Optimize.GraphColoringRegAllocator;
import Optimize.SSAConstruction;
import IR.*;
import IR.Instruction.*;
import Backend.*;

import java.util.ArrayList;
import java.util.*;

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

    ArrayList<ArrayList<Integer>> to, rto;
    int [] d;
    int n;
    boolean[] vis;
    public Queue<Integer> q;
    HashMap<String, Integer> Id;

    void addEdge(int u, int v) {
        if (u == v)
            return;
        to.get(u).add(v);
        d[u]++;
        rto.get(v).add(u);
    }

    void pre() {
        n = blocks.size();
        d = new int[n];
        q = new LinkedList<Integer>();
        to = new ArrayList<>();
        for (int i = 0; i < n; i++) 
            to.add(new ArrayList<>());
        rto = new ArrayList<>();
        for (int i = 0; i < n; i++) 
            rto.add(new ArrayList<>());
        Id = new HashMap<>();
        for (int i = 0; i < n; i++)
            Id.put(blocks.get(i).insts.get(0).funcName, i);
        vis = new boolean[n];
        for (int i = 0; i < n; i++)
            vis[i] = false;
    }

    public void getDAG() {
        pre();
        ArrayList<BasicBlock> curBlocks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            BasicBlock curBlock = blocks.get(i);
            for (IRInst inst : curBlock.insts)
                if (inst instanceof CallInst) {
                    if (Id.containsKey(inst.funcName)) {
                        int v = Id.get(inst.funcName);
                    //    inst.block = blocks.get(v);
                        addEdge(i, v);
                    }
                }
            if (d[i] == 0){
                vis[i] = true;
                q.add(i);
                curBlocks.add(blocks.get(i));
            }
        }
        while (!q.isEmpty()) {
            int t = q.poll();
            for (int pt : rto.get(t)) {
                d[pt]--;
                if (!vis[pt] && d[pt] == 0) {
                    vis[pt] = true;
                    q.add(pt);
                    curBlocks.add(blocks.get(pt));
                }
            }
        }
        for (int i = 0; i < n; i++) 
            if (!vis[i])
                curBlocks.add(blocks.get(i));
        blocks = curBlocks;
    }

    public void accept(IRVisitor it) {
        it.visit(this);
    }
}
