package org.bolyuk.joghurt.interpreter.obj;

import java.util.HashMap;

public class JContext extends JObject{
    public HashMap<String, JObject> vars = new HashMap<>();
    public JContext outer_context = null;

    public JObject update(String name, JObject value, boolean only_this){
        if(vars.containsKey(name)) {
            vars.put(name, value);
            return null;
        }
        if(!only_this)
            return outer_context.update(name, value, false);
        return new JError("variable \""+name+"\" is not exist!");
    }

    public JObject get(String name, JObject value, boolean only_this){
        if(vars.containsKey(name))
            return vars.get(name);
        if(!only_this)
            return outer_context.get(name, value, false);
        return new JError("variable \""+name+"\" is not exist!");
    }

    public JObject create(String name, JObject value){
        if(!vars.containsKey(name)) {
            vars.put(name, value);
            //TODO unsafe adding outer context if object is function;
            if(value.isFunc())
                ((JFunc)value).context.outer_context=this;
        } else {
            return new JError("variable \""+name+"\" is exist!");
        }
        return null;
    }

}
