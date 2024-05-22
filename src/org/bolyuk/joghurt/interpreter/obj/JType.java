package org.bolyuk.joghurt.interpreter.obj;

import org.bolyuk.joghurt.C;

public class JType extends JObject {
    public C.JType type = C.JType.TYPE;

    public String value;

    public JType(String value){
        this.value=value;
    }
}
