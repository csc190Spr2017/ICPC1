/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphProblem;

import java.util.ArrayList;

/**
 *
 * @author csc190
 */
public class Node {
    String name;
    int layer;
    ArrayList<Edge> edges = new ArrayList<>();
    
    public Node(String name){
        this.name = name;
    }
    
    public Node(String name, int layer){
        this.name = name;
        this.layer = layer;
    }
    
    public void setLayer(int layer){
        this.layer = layer;
    }
    
    public int sumToDistChildren(){
        return 0;
    }
    
    public int sumPairWiseDist(){
        return 0;
    }
    }
    
}
