package Util.Type;

public class arrayType extends Type {
	public Type type;
    public int dim = 0;

    public arrayType(Type type, int dim){
        this.type = type;
        this.dim = dim;
    }

    public arrayType(String s, int dim){
    	this.type = new Type(s);
        this.dim = dim;
    }

    @Override
    public boolean equal(Type t) {
        return (t == null) || (t.isNull) || ((this.dim == 0) && (type.equal(t))) || ((t instanceof arrayType) && (this.type.equal(((arrayType) t).type) && this.dim == ((arrayType) t).dim));
    }
}