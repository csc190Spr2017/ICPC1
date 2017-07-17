/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphProblem;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author csc190
 */
public class Graph {
    public ArrayList<Node> nodes = new ArrayList<Node>();
    public ArrayList<Edge> edges = new ArrayList<Edge>();
    
   private static Node getOrInsert(String e, HashMap<String, Node> elements, Graph G){
       if(!elements.containsKey(e)){
           Node newNode = new Node(e);
           G.nodes.add(newNode);
           elements.put(e, newNode);
        }
       return elements.get(e);
   }
    
    public static Graph buildGraph(Entry [] arrEntires){
        HashMap<String, Node> elements = new HashMap<>();
        Graph G = new Graph();
        for(int i = 0; i < arrEntires.length; i++){
            Node newNode1 =getOrInsert(arrEntires[i].node1, elements, G);
            Node newNode2 =getOrInsert(arrEntires[i].node2, elements, G);
            Edge e = new Edge(newNode1, newNode2, arrEntires[i].weight);
            G.edges.add(e);
        }
        return G;
    }
    
    public void markLayers(){
        
        return;
    }
    
}
