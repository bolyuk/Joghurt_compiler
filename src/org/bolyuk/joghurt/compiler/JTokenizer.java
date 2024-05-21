package org.bolyuk.joghurt.compiler;

import org.bolyuk.joghurt.C;
import org.bolyuk.joghurt.obj.JObject;
import org.bolyuk.joghurt.obj.JStatement;

import java.util.ArrayList;

public class JTokenizer {

    public static JStatement tokenize(String code){
        JStatement result = new JStatement();

        String[] buf = new String[2];
        buf[1]="";
        //first step
        int int_b;
        int counter;

        //0 - string, 1 - int, 2 - operator, 3 - keyword, 4 - types, 5 - up, 6 - down -1 - unknow
        for(char d : code.toCharArray()){
            if(Character.isLetter(d)){
                buf[1]+=d;
                buf[0]="0";
            } else if(d == ' '){
                if(!buf[1].equals(""))
                result.put(resolve_type(buf));
            } else if(Character.isDigit(d)){
                buf[1]+=d;
                if(buf[0].equals(""))
                    buf[0]="1";
            } else if(C.o.contains(Character.toString(d))){
                if(!buf[1].equals(""))
                    result.put(resolve_type(buf));

                result.put(new JObject(Character.toString(d), "2"));
            } else if(C.lu.contains(Character.toString(d))){
                if(!buf[1].equals(""))
                    result.put(resolve_type(buf));

                result.put(new JObject(Character.toString(d), "5"));
            } else if(C.ld.contains(Character.toString(d))) {
                if(!buf[1].equals(""))
                    result.put(resolve_type(buf));

                result.put(new JObject(Character.toString(d), "6"));
            }else{
                    buf[0]="-1";
                    buf[1]+=d;
            }
        }

        if(!buf.equals(""))
            result.put(resolve_type(buf));


        return result;
    }

    public static JStatement tree(JStatement tokens){
        JStatement result = new JStatement();

        ArrayList<JStatement> stack = new ArrayList<>();
        stack.add(result);
        int count=0;

        JStatement buf = new JStatement();
        stack.add(buf);
        result.put(buf);

        for (JObject o : tokens.data)
            if(o.value.equals(";")) {
                result.put(buf);
                buf = new JStatement();
            } else {
                buf.put(o);
            }
        return result;
    }

    public String toASM(JStatement tree){
        for (JObject a : tree.data){
            JStatement s = (JStatement) a;
        }
        return null;
    }

    private static JObject resolve_type(String[] _buf){
        String buf = _buf[1];
        String type = _buf[0];

        _buf[0]="";
        _buf[1]="";

        if(type.equals("1"))
            return new JObject(buf, "1");

        if(C.t.contains(buf))
            return new JObject(buf, "4");
        if(C.k.contains(buf))
            return new JObject(buf, "3");

        return new JObject(buf, type);
    }
}
