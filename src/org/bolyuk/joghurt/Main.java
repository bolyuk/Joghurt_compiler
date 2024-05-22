package org.bolyuk.joghurt;

import org.bolyuk.joghurt.compiler.JTokenizer;
import org.bolyuk.joghurt.compiler.JTokenTree;
import org.bolyuk.joghurt.interpreter.obj.JStatement;
import org.bolyuk.joghurt.utils.JVisualizer;

public class Main {

    public static void main(String[] args) {
        JStatement tokens = JTokenizer.create("func int calc(int i=0, String b, int v){return (34*i)/2;}");
        System.out.println(JVisualizer.visualize(tokens));
        JStatement tree = new JTokenTree().create(tokens);
        System.out.println(JVisualizer.visualize(tree));
    }
}
