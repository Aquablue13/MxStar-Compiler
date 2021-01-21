package Util.Type;

public class arrayType extends Type {
	public Type type;
    public int dim = 0;

    public arrayType(String s, int dim){
    	this.type = new Type(s);
        this.dim = dim;
    }

    @Override
    public boolean equal(Type t) {
        return (t.isNull) || ((t instanceof arrayType) && (this.type.equal(((arrayType) t).type) && this.dim == ((arrayType) t).dim));
    }
}