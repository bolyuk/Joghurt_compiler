package org.bolyuk.joghurt.interpreter.obj;

import org.bolyuk.joghurt.C;

public class JObject {
    public Object value;
    public C.JType type;

    public JObject(){}

    public JObject(Object value, C.JType type){
        this.value=value;
        this.type=type;
    }

    public final C.JType getJType(){
        return type;
    }

    public final boolean isError(){
        return type == C.JType.ERR;
    }

    public final boolean isFunc(){
        return type == C.JType.FUNC;
    }

    public final boolean isInt(){
        return type == C.JType.INT;
    }

    public final boolean isLiteral(){
        return type == C.JType.LITERAL;
    }

    public final boolean isOperator(){
        return type == C.JType.OPERATOR;
    }

    public final boolean isStatement(){
        return type == C.JType.STATEMENT;
    }

    public final boolean isStruct(){
        return type == C.JType.STRUCT;
    }

    public final boolean isType(){
        return type == C.JType.TYPE;
    }
}
