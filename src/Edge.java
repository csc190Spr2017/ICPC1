/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author csc190
 */
public class Edge {
    protected Vertex [] arrayVertex = {null, null};
    protected int[] arrayCost = {0,0};
            
    public Edge(Vertex V1, Vertex V2){
        arrayVertex[0] = V1;
        arrayVertex[1] = V2;
    }        
    
    public void setCost(int idx){
        arrayCost[idx] = arrayVertex[idx].getGraphCostExcept(this);
    }
    
    public int getCost(Vertex v){
        return v==arrayVertex[0]? arrayCost[0]: arrayCost[1];
    }
}
