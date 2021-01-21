package Util;

import Util.Type.*;
import Util.Error.semanticError;
import Util.position;

import java.util.HashMap;

public class Scope {
    public HashMap<String, Type> vars = new HashMap<>();
    public HashMap<String, funcType> funcs = new HashMap<>();
    public HashMap<String, Type> types = new HashMap<>();
    public Scope parentScope;

    public Scope(Scope parentScope) {
        this.parentScope = parentScope;
    }

    public void defineVariable(String name, Type type, position pos) {
        if (this.containsType(name, true))
            throw new semanticError("duplicated with type name", pos);
        if (vars.containsKey(name))
            throw new semanticError("variable redefine", pos);
        vars.put(name, type);
    }

    public boolean containsVariable(String name, boolean lookUpon) {
        if (vars.containsKey(name))
            return true;
        else
            if (parentScope != null && lookUpon)
                return parentScope.containsVariable(name, true);
            else
                return false;
    }

    public Type getVariableType(String name, boolean lookUpon) {
        if (vars.containsKey(name))
            return vars.get(name);
        else
            if (parentScope != null && lookUpon)
                return parentScope.getVariableType(name, true);
            else
                return null;
    }

    public void defineFunction(String name, funcType type, position pos) {
        if (this.containsType(name, true))
            throw new semanticError("duplicated with type name", pos);
        if (funcs.containsKey(name))
            throw new semanticError("function redefine", pos);
        funcs.put(name, type);
    }

    public boolean containsFunction(String name, boolean lookUpon) {
        if (funcs.containsKey(name))
            return true;
        else
            if (parentScope != null && lookUpon)
                return parentScope.containsFunction(name, true);
            else
                return false;
    }

    public funcType getFunctionType(String name, boolean lookUpon) {
        if (funcs.containsKey(name))
            return funcs.get(name);
        else
            if (parentScope != null && lookUpon)
                return parentScope.getFunctionType(name, true);
            else
                return null;
    }

    public void defineType(String name, Type value, position pos) {
        if (types.containsKey(name))
            throw new semanticError("class redefine", pos);
        types.put(name, value);
    }

    public boolean containsType(String name, boolean lookUpon) {
        if (types.containsKey(name))
            return true;
        else
            if (parentScope != null && lookUpon)
                return parentScope.containsType(name, true);
            else
                return false;
    }

    public Type getType(String name, boolean lookUpon) {
        if (types.containsKey(name))
            return types.get(name);
        else
            if (parentScope != null && lookUpon)
                return parentScope.getType(name, true);
            else
                return null;
    }
}