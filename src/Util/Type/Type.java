package Util.Type;

public class Type {
    public String name;
    public boolean isInt = false, isBool = false, isString = false, isVoid = false, isNull = false;

    public Type() {}

    public Type(String name) {
        if (name == null) {
            isNull = true;
            return;
        }
        this.name = name;
        switch (name) {
            case "int" -> isInt = true;
            case "bool" -> isBool = true;
            case "string" -> isString = true;
            case "void" -> isVoid = true;
            case "null" -> isNull = true;
        }
    }

    public boolean equal(Type t) {
        return ((this.name == null) && (t.name == null)) || ((this.name != null) && (t.name != null) && (this.name.equals(t.name)));
    }
}