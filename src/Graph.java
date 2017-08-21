
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author csc190
 */
public class Graph {
    
    HashMap<String, Vertex> hm = new HashMap<>();
    ArrayList<Edge> arrEdges = new ArrayList<Edge>();
    
    public Graph(){
        
    }
    
    public void addNode(String nodeName, int weight){
        Vertex nNode = new Vertex(nodeName, weight);
        hm.put(nodeName, nNode);
    }
    
    public void addEdge(String v1name, String v2name){
        Vertex v1 = hm.get(v1name);
        Vertex v2 = hm.get(v2name);
        Edge e = new Edge(v1, v2);
        v1.addEdge(e);
        v2.addEdge(e);    
        arrEdges.add(e);
    }
    
    public void collectTrafficData(){
        for(int i=0; i<this.arrEdges.size(); i++){
            Edge edge = this.arrEdges.get(i);
            edge.setCost(0);
            edge.setCost(1);
        }
        Iterator it = hm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Vertex v = (Vertex) pair.getValue();
            v.setMaxTraffic();        
        }
        
    }
    
    public void printTrafficData(){
        Iterator it = hm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Vertex v = (Vertex) pair.getValue();
            System.out.println("Vertex: " + v.name + ", event max traffic: " + v.maxTraffic);
        }
    }
    
    
    
    
}
