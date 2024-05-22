package org.bolyuk.joghurt.interpreter.obj;

import org.bolyuk.joghurt.C;

//TODO finish
public class JStruct extends JObject{
    public C.JType type = C.JType.STRUCT;

    public JContext context = new JContext();

    public JStruct put(String name, JObject value){
        context.create(name, value);
        return this;
    }
}
