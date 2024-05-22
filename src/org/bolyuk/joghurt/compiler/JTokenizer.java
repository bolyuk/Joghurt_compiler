package org.bolyuk.joghurt.compiler;

import org.bolyuk.joghurt.C;
import org.bolyuk.joghurt.interpreter.obj.*;

public class JTokenizer {

    public static JStatement create(String code){
        JStatement result = new JStatement();

        String[] buf = new String[2];
        buf[1]="";

        //0 - literal, 1 - int, 2 - operator, 3 - keyword, 4 - types, 5 - up, 6 - down -1 - unknow
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

                result.put(new JOperator(Character.toString(d)));
            } else if(C.lu.contains(Character.toString(d))){
                if(!buf[1].equals(""))
                    result.put(resolve_type(buf));

                result.put(new JObject(Character.toString(d), null));
            } else if(C.ld.contains(Character.toString(d))) {
                if(!buf[1].equals(""))
                    result.put(resolve_type(buf));

                result.put(new JObject(Character.toString(d), null));
            }else{
                    buf[0]="-1";
                    buf[1]+=d;
            }
        }

        if(!buf.equals(""))
            result.put(resolve_type(buf));


        return result;
    }

    private static JObject resolve_type(String[] _buf){
        String buf = _buf[1];
        String type = _buf[0];

        _buf[0]="";
        _buf[1]="";

        if(type.equals("1"))
            return new JInt(Integer.parseInt(buf));

        if(C.t.contains(buf))
            return new JType(buf);
        if(C.k.contains(buf))
            return new JObject(buf, C.JType.KEYWORD);
        if(type.equals("0"))
            return new JLiteral(buf);

        return new JObject(buf, C.JType.UNKNOWN);
    }
}
