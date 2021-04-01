package Util.Type;

import java.util.ArrayList;

public class funcType extends Type {
    public String funcName;
    public Type type;
    public ArrayList<Type> parameters = new ArrayList<>();

    public funcType(String S){
    	this.type = new Type(S);
    }

    public funcType(String S, ArrayList<Type> paras){
        this.type = new Type(S);
        this.parameters = paras;
    }
/*
    public funcType(Type type) {
    }*/

    @Override
    public boolean equal(Type t) {
        return this.type.equal(t);
    }
}