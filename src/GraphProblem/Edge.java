/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphProblem;

/**
 *
 * @author csc190
 */
public class Edge {
    protected Node node1;
    protected Node node2;
    protected int cost;
    
    public Edge(Node newNode1, Node newNode2, int newCost){
        this.node1 = newNode1;
        this.node2 = newNode2;
        this.cost = newCost;
    }
    
}
