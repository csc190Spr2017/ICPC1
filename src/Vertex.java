
import java.util.ArrayList;
import java.util.HashSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author csc190
 */
public class Vertex {
    
    protected String name;
    protected int cost;
    protected int maxTraffic;
    protected ArrayList<Edge> arrayEdges = new ArrayList<Edge>();

    public Vertex(String newName, int newCost){
        this.name = newName;
        this.cost = newCost;
    }
        
    public void addEdge(Edge newEdge){
        arrayEdges.add(newEdge);
    }
    
    public void setMaxTraffic(){
        
        for(int i = 0; i < arrayEdges.size(); i++){
            int traffic = arrayEdges.get(i).getCost(this);
            maxTraffic = traffic > maxTraffic? traffic: maxTraffic; 
        }
    }
    
    public int getGraphCostExcept(Edge edge){
        int i = 0;
        HashSet<Vertex> visited = new HashSet<Vertex>();
        return getGraphCostExcept_HelpFunction(edge, visited);
     }
    
    public int getGraphCostExcept_HelpFunction(Edge edge, HashSet<Vertex> visit){
        visit.add(this);
        int totalCost = this.cost;
        for(int i = 0; i < arrayEdges.size(); i++){
            Edge currEdge = this.arrayEdges.get(i);
            if(currEdge == edge){
                continue;
            }
            Vertex otherVertex = currEdge.arrayVertex[0] == this?  currEdge.arrayVertex[1]: currEdge.arrayVertex[0];
            if(visit.contains(otherVertex)) continue;
            int otherCost = otherVertex.getGraphCostExcept_HelpFunction(edge, visit);
            totalCost += otherCost;
        }
        return totalCost;
    }
 }
