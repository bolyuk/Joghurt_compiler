package org.bolyuk.joghurt.interpreter.obj;

import org.bolyuk.joghurt.C;

public class JOperator extends JObject{
    public C.JType type = C.JType.OPERATOR;

    public JOperator(String operator){
        this.value=operator;
    }
}
