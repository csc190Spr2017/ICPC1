
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author csc190
 */
public class TrafficProblem {
    public static void main(String [] args){
        Graph g = new Graph();
        String [] arrNames = {"node1", "node2", "node3", "node4"};
        int [] arrCost = {2, 3, 1, 4};
        for(int i=0; i<arrNames.length; i++){
            g.addNode(arrNames[i], arrCost[i]);
        }
        String [][] arrEdges = {
            {"node1", "node2"},
             {"node3", "node2"},
              {"node4", "node3"},
        };
        for(int i=0; i<arrEdges.length; i++){
            g.addEdge(arrEdges[i][0], arrEdges[i][1]);
        }
        
        g.collectTrafficData();
        g.printTrafficData();
                
        
    }
    
}
