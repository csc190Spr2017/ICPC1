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
    
    /* properly set the "layer" of all nodes so that we actually get a tree out
    of the acyclic undirecitonal graph.
    Layer1 nodes are those leaf nodes with NO neighbors or only one neibor.
    The requirement is that FOR ANY EDGE: the two nodes CANNOT have the
    same layer number.
    For any neighbors, the one with HIGHER layer number is the PARENT.
    */
    
    protected ArrayList<Node> highestLayer;
    public void markLayers(){
        //1. collect all layer1 nodes (the ones with up TO 1 neighbor)
        ArrayList<Node> Layer1 = getLayer1();
        setLayerNumber(Layer1, 1);
        
        ArrayList<Node> curLayer = Layer1;
        ArrayList<Node> nextLayer = new ArrayList<Node>();
        int curLayerNumber = 1;
        //2. for each layer
        while(curLayer.size()!=0){
            //2.1 break ties randomly, until for each node in the layer there is no tie
            
            for(int i = 0; i < curLayer.size(); i++){
                Node currentNode = curLayer.get(i);
                ArrayList<Edge> CNedges = currentNode.edges;
                 for(int j = 0; j < CNedges.size(); j++){
                     Edge CNcurrentEdge = CNedges.get(j);
                     if(CNcurrentEdge.node1.layer == CNcurrentEdge.node2.layer){
                         currentNode.setLayer(curLayerNumber+1);
                         nextLayer.add(currentNode);
                         break;
                     }
                 }
            }
            curLayerNumber++;
            highestLayer = curLayer;
            curLayer = nextLayer;
            nextLayer = new ArrayList<Node>();
        }
    }
    
    protected ArrayList<Node> getLayer1(){
        ArrayList<Node> layer1 = new ArrayList<>();
        for(int i = 0; i < nodes.size(); i++){
            if(nodes.get(i).edges.size() <= 1){
                layer1.add(nodes.get(i));
            }
        }
        return layer1;
    }
    
    protected void setLayerNumber(ArrayList<Node> layer, int num){
        for(int i = 0; i < layer.size(); i++){
            layer.get(i).setLayer(num);
        }
    }
    
    public int getPairWiseDist(){
        this.markLayers();
        int sum = 0;
        for(int i = 0; i < this.highestLayer.size(); i++){
            sum += this.highestLayer.get(i).sumPairWiseDist();
        }
        return sum;
    }
    
}
