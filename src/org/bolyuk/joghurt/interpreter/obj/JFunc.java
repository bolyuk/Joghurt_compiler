package org.bolyuk.joghurt.interpreter.obj;

import org.bolyuk.joghurt.C;

//TODO finish
public class JFunc extends JObject{
    public C.JType type = C.JType.FUNC;
    public String name;
    public JType return_value;
    public JObject[] args;
    public JContext context;

    public JStatement body;

}
