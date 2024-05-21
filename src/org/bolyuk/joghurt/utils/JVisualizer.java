package org.bolyuk.joghurt.utils;

import org.bolyuk.joghurt.obj.JObject;
import org.bolyuk.joghurt.obj.JStatement;

public class JVisualizer {
    public static String visualize(JStatement statement){
        String data ="";
        for(JObject o : statement.data){
            if(o instanceof JStatement)
                data+="s:[ "+visualize((JStatement)o)+"]";
            else
                data+=o.value+" ";

        }
        return data;
    }
}
