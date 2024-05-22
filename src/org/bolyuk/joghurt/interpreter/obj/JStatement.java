package org.bolyuk.joghurt.interpreter.obj;

import org.bolyuk.joghurt.C;

import java.util.ArrayList;

public class JStatement extends JObject{
    public C.JType type = C.JType.STATEMENT;

    public ArrayList<JObject> data = new ArrayList<>();

    public void put(JObject o){
        data.add(o);
    }
}
