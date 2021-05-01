package Util;

import IR.Operand.Register;

public class RegIdAllocator {

    private int[] nowRegId = new int[20];

    public Register alloc(int gr){
        if (gr == 5)
            return new Register(nowRegId[gr]++, gr, false);
        return new Register(nowRegId[gr]++, gr, false);
    }

    public int size(int gr){
        return nowRegId[gr];
    }

    public RegIdAllocator() {
    }
}
