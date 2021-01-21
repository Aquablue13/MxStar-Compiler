package Util.Type;

abstract public class Type {
    String name;
    public boolean isInt = false, isBool = false, isString = false, isVoid = false, isNull = false;

    public Type(String name) {
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
        return this.name == t.name;
    }
}