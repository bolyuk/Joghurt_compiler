package org.bolyuk.joghurt.asm;

import org.bolyuk.joghurt.obj.JObject;
import org.bolyuk.joghurt.obj.JStatement;

public class JASM {
    public static void generate(JStatement code_tree){
        for (JObject a : code_tree.data){
            JStatement s = (JStatement) a;
        }
    }
}
