package Util;

import Util.Type.*;
import Util.Error.semanticError;
import Util.Error.internalError;
import Util.position;
import Util.RegIdAllocator;
import IR.Register;
import AST.*;

import java.util.HashMap;

public class Scope {
    public enum ScopeType {
        initScope, classScope, funcScope, loopScope
    }

    public ScopeType scopeType;
    public RegIdAllocator regAlloca = new RegIdAllocator();
    public HashMap<String, Type> vars = new HashMap<>();
    public HashMap<String, Integer> varIDs = new HashMap<>();
    public HashMap<String, Register> variablesRegId = new HashMap<>();
    public HashMap<String, funcType> funcs = new HashMap<>();
    private HashMap<String, Integer> funcsInClass = new HashMap<>();
    public HashMap<String, Type> types = new HashMap<>();
    public Scope parentScope;
    public classType classInfo = null;
    int cnt = 0;

    public Scope(Scope parentScope) {
        this.parentScope = parentScope;
        this.scopeType = ScopeType.initScope;
        this.regAlloca = new RegIdAllocator();
        if (parentScope != null)
            regAlloca = parentScope.regAlloca;
    }
/*
    public boolean isClassScope() {
        if (scopeType == initScope)
            return false;
        if (scopeType == classScope)
            return true;
        return parentScope.isClassScope();
    }

    public boolean isFuncScope() {
        if (scopeType == initScope)
            return false;
        if (scopeType == funcScope)
            return true;
        return parentScope.isFuncScope();
    }

    public boolean isLoopScope() {
        if (scopeType == initScope)
            return false;
        if (scopeType == loopScope)
            return true;
        return parentScope.isLoopScope();
    }
*/
    public Register defineVariable(String name, Type type, position pos, int typ) {
        if (this.containsType(name, true))
            throw new semanticError("duplicated with type name", pos);
        if (vars.containsKey(name))
            throw new semanticError("variable redefine", pos);
        vars.put(name, type);
        varIDs.put(name, cnt++);
        Register result = regAlloca.alloc(typ);
        variablesRegId.put(name, result);
        return result;
    }

    public void defineVariable(String name, Type type, position pos) {
        if (this.containsType(name, true))
            throw new semanticError("duplicated with type name", pos);
        if (vars.containsKey(name))
            throw new semanticError("variable redefine", pos);
        vars.put(name, type);
    //    varIDs.put(name, cnt++);
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

    public int getVariableID(String name, boolean lookUpon) {
        if (varIDs.containsKey(name))
            return varIDs.get(name);
        else
            if (parentScope != null && lookUpon)
                return parentScope.getVariableID(name, true);
            else
                return 0;
    }

    public Register getRegIdVariable(String name, boolean lookUpon) {
        if (variablesRegId.containsKey(name))
            return variablesRegId.get(name);
        else
            if (parentScope != null && lookUpon)
                return parentScope.getRegIdVariable(name, true);
            else
                throw new internalError("getRegIdVariable failed", new position(0, 0));
    }

    public void defineFunction(String name, funcType type, position pos) {
        if (this.containsType(name, true))
            throw new semanticError("duplicated with type name", pos);
        if (funcs.containsKey(name))
            throw new semanticError("function redefine", pos);
        funcs.put(name, type);
        if (classInfo == null) {
            funcsInClass.put(name, 0);
        }
        else {
            funcsInClass.put(name, 1);
        }
    }

    public void defineFunction(String name, funcType type, position pos, Integer classes) {
        if (this.containsType(name, true))
            throw new semanticError("duplicated with type name", pos);
        if (funcs.containsKey(name))
            throw new semanticError("function redefine", pos);
        funcs.put(name, type);
        funcsInClass.put(name, classes);
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

    public Integer getFunctionInClass(String name, boolean lookUpon) {
        if (funcsInClass.containsKey(name))
            return funcsInClass.get(name);
        else
            if (parentScope != null && lookUpon)
                return parentScope.getFunctionInClass(name, true);
            else
                return 0;
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

    public Type getType(typeNode type) {
        if (type.dim == 0)
            return types.get(type.typeName);
        else
            return new arrayType(types.get(type.typeName), type.dim);
    }
}