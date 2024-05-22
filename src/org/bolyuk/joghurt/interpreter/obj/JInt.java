package org.bolyuk.joghurt.interpreter.obj;

import org.bolyuk.joghurt.C;

public class JInt extends JObject{
    public C.JType type = C.JType.INT;

    public int value;

    public JInt(int value){
        this.value=value;
    }

}
