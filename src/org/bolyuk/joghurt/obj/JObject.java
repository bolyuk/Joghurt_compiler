package org.bolyuk.joghurt.obj;

public class JObject {
    public String value;
    public String type;
    boolean isFinal=false;

    public JObject(){}

    public JObject(String value, String type){
        this.value=value;
        this.type=type;
    }

    public final String getJType(){
        return type;
    }
}
