package org.bolyuk.joghurt.interpreter.obj;

import org.bolyuk.joghurt.C;

public class JError extends JObject {
    public C.JType type = C.JType.ERR;

    public JError(String value){
        this.value=value;
    }
}
