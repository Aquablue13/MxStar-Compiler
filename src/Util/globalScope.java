package Util;

import Util.Error.semanticError;

import java.util.HashMap;
import java.util.ArrayList;

public class globalScope extends Scope {
    public HashMap<String, Scope> scopes = new HashMap<>();

    public globalScope(Scope parentScope) {
        super(parentScope);
    }

    public void addType(String name, Scope t, position pos) {
        if (scopes.containsKey(name))
            throw new semanticError("Multiple definition of " + name, pos);
        if (t.classInfo != null)
            t.classInfo.name = name;
        scopes.put(name, t);
    }

	public boolean containsType(String name){
		return scopes.containsKey(name);
	}

    public Scope getScopeFromName(String name, position pos) {
        if (scopes.containsKey(name)) return scopes.get(name);
        throw new semanticError("No such type: " + name, pos);
    }
    
    public Scope getScopeFromName(String name) {
        return scopes.get(name);
    }
}
