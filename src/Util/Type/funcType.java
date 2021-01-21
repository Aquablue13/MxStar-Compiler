package Util.Type;

import java.util.ArrayList;

public class funcType extends Type {
    public ArrayList<Type> parameters;

    public funcType(String S){
    	super(S);
    }

    public funcType(String S, ArrayList<Type> paras){
    	super(S);
        this.parameters = paras;
    }

    @Override
    public boolean equal(Type t) {
        return t.name == this.name;
    }
}