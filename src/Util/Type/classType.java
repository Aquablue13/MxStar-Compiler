package Util.Type;

import java.util.HashMap;

public class classType extends Type {
    public String name;
    public HashMap<String, Type> vars = new HashMap<>();
    public HashMap<String, funcType> funcs = new HashMap<>();
    public funcType constructor = null;

    public classType(String name) {
        this.name = name;
    }

    @Override
    public boolean equal(Type t) {
        return (t.isNull == true) || ((t instanceof classType) && (this.name.equals(((classType) t).name)));
    }
}