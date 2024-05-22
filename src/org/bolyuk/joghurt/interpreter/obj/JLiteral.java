package org.bolyuk.joghurt.interpreter.obj;

import org.bolyuk.joghurt.C;

public class JLiteral extends JObject{
    public C.JType type = C.JType.LITERAL;

    public JLiteral(String value){
        this.value=value;
    }
}
