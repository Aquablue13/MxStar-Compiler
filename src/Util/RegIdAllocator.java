package Util;

import IR.Register;

public class RegIdAllocator {

    private int[] nowRegId = new int[20];

    public Register alloc(int gr){
        return new Register(nowRegId[gr]++, gr, false);
    }

    public int size(int gr){
        return nowRegId[gr];
    }

    public RegIdAllocator() {
    }
}
