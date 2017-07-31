/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseSchedule;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *
 * @author csc190
 */
public class Graph {
    protected PriorityQueue<Vertex> vertices = new PriorityQueue<>();
    protected HashMap<String, Vertex> hm = new HashMap<>();
    
    
    protected Vertex getNode(String name){
        if(!hm.containsKey(name)){
            Vertex v = new Vertex(name);
            hm.put(name, v);
            vertices.add(v);
        }
        return hm.get(name);
    }
    
    public static Graph constructGraph(String[][] schedule){
        Graph g = new Graph();
        for(int i = 0; i < schedule.length; i++){
            String src = schedule[i][0];
            String dest = schedule[i][1];
            Vertex v1 = g.getNode(src);
            Vertex v2 = g.getNode(dest);
            v2.countPred++;
            v1.arrNext.add(v2);
        }
        return g;
    }
    
    public void remove(Vertex v){
        hm.remove(v.name);
        for(int i = 0; i < v.arrNext.size(); i++){
            Vertex v1 = v.arrNext.get(i);
            v1.countPred--;
            vertices.remove(v1);
            vertices.add(v1);
        }
        
    }
    
    public Vertex getRootVertex(){
        if(vertices.size() == 0){
            return null;
        }
        Vertex v = vertices.peek();
        
        return v.countPred==0? vertices.remove(): null;
    }
    
    public int getNumVertex(){
        return hm.size();   
    }
    
}
