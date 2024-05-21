package org.bolyuk.joghurt.obj;

import java.util.ArrayList;

public class JStatement extends JObject{
    public ArrayList<JObject> data = new ArrayList<>();

    public void put(JObject o){
        data.add(o);
    }
}
