package Util;

import IR.Register;

public class RegIdAllocator {

    private int[] nowRegId = new int[20];

    public Register alloc(int typ){
        return new Register(nowRegId[typ]++, typ, false);
    }

    public int size(int typ){
        return nowRegId[typ];
    }

    public RegIdAllocator() {
    }
}
