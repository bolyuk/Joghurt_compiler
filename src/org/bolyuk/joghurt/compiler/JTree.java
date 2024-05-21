package org.bolyuk.joghurt.compiler;

import org.bolyuk.joghurt.C;
import org.bolyuk.joghurt.obj.JObject;
import org.bolyuk.joghurt.obj.JStatement;

import java.util.ArrayList;

public class JTree {
    private ArrayList<JStatement> stack = new ArrayList<>(); //contains layers of tree
    private int deep = 1; // deep value in tree

    private JStatement root = new JStatement(); //well, result statement or "root"
    private JStatement current_layer = new JStatement(); //current layer of adding code statements

    public JTree(){
        stack.add(root); //initialize root as a first layer in a stack
        root.put(current_layer);
        stack.add(current_layer);
    }

    public JStatement create(JStatement tokens){
        for (JObject o : tokens.data) {
            if (o.value.equals(";")) {
                // if statement is complete,
                //just recreate "current_layer" as a new element of root from the last "current_layer"
                current_layer = new JStatement();
                stack.get(deep-1).put(current_layer);
                //and dont forget to update a position
                stack.set(deep, current_layer);
            } else if (o.value.equals(",")) {
                JStatement current_root = stack.get(deep-1);
                if(current_root.value != null && current_root.value.equals("buffer_layer")){
                    //using method from up
                    current_layer = new JStatement();
                    stack.get(deep-1).put(current_layer);
                    //and dont forget to update a position
                    stack.set(deep, current_layer);
                } else {
                    //shitty coded method to add buffer layer and put old statement with new one to one layer above the root

                    //deleting our statement from a tree
                    stack.get(deep - 1).data.remove(current_layer);
                    //and from a stack
                    stack.remove(deep);
                    //resolve deep
                    deep--;
                    //buffer!
                    JStatement buffer_layer = new JStatement();
                    buffer_layer.value = "buffer_layer";
                    //adding our statement
                    buffer_layer.put(current_layer);
                    //add buffer layer to the tree and resolving stack
                    stack.get(deep).put(buffer_layer);
                    stack.add(buffer_layer);
                    //recreate a current layer and resolve the stack
                    current_layer = new JStatement();
                    buffer_layer.put(current_layer);
                    stack.add(current_layer);
                    //resolve deep
                    deep+=2;
                }
            }else if (C.lu.contains(o.value)) {
                //if spec symbol then create a new layer in "current_layer"
                up();
            } else if (C.ld.contains(o.value)) {
                //if spec symbol then down to the root of "current_layer"
                down();
            } else {
                //if nothing just add to "current_layer" a new element
                current_layer.put(o);
            }
        }
        return root;
    }

    private void down() {

        //going to get a new layer from a stack
        deep--;
        current_layer = stack.get(deep);

        //and not forgetting to delete from the stack
        stack.remove(deep+1);
        if(current_layer.value != null && current_layer.value.equals("buffer_layer")){
            down();
        }
    }

    private void up(){
        //recreate a "current_layer" and adding it as a child to itself to create a new deep level
        current_layer = new JStatement();
        stack.get(deep).put(current_layer);
        deep++;

        //and not forgetting to add to the stack
        stack.add(current_layer);
    }
}

