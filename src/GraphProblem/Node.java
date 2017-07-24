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
    
    /**
      get all children: that is all neighbors have LOWER layer number than me
      */
    public ArrayList<Node> getChildren(){
        ArrayList<Node> arr = new ArrayList();
        for(int i=0; i<this.edges.size(); i++){
            Edge edge = this.edges.get(i);
            Node otherNode = edge.node1==this? edge.node2: edge.node1;
            if(otherNode.layer< this.layer){
                arr.add(otherNode);
            }
        }
        return arr;
    }
    
    protected int treeSize = -1; //initial
    /**
     * Get the size of the tree with ME as the root, me included
     * @return 
     */
    public int getTreeSize(){
        if(this.treeSize!=-1) return this.treeSize;
        ArrayList<Node> arrChildren = this.getChildren();
        int totalSize = 0;
        for(int i=0; i<arrChildren.size(); i++){
            Node child = arrChildren.get(i);
            int size = child.getTreeSize();
            totalSize+=size;
        }
        return totalSize;
    }
    
    /* return the sum of distances from the node (as the root of a subtree) to
    all of its descendents (lower layer numbers). If there are 5 nodes, then
    it's the sum of 4 distances.
    */
    protected int sd = -1;
    public int sumToDistChildren(){
        if(sd != -1){
            return sd;
        }
        sd = 0;
        for(int i = 0; i < this.edges.size(); i++){
            Edge edge = this.edges.get(i);
            Node nb = edge.node1==this? edge.node2: edge.node1;
            sd = edge.cost * nb.getTreeSize() + nb.sumToDistChildren();
        }
        return sd;
    }
    
    /* return the sum of pairwise distances of ALL THE NODES of the 
    tree starting from me (me included). If there are 5 nodes, then it's the sum 
    of 10 distances (pairwise)
    */
    public int sumPairWiseDist(){
        int sum = 0;
        for(int i = 0; i < this.edges.size(); i++){
            Edge edge_i = this.edges.get(i);
            Node n_i = edge_i.node1==this? edge_i.node2: edge_i.node1;
            sum += n_i.sumPairWiseDist();
            for(int j = i +1; j < this.edges.size(); j++){
                Edge edge_j = this.edges.get(j);
                Node n_j = edge_j.node1==this? edge_j.node2: edge_j.node1;       
                sum += n_i.sumToDistChildren() * n_j.getTreeSize() + 
                        n_j.sumToDistChildren() * n_i.getTreeSize() +
                        (edge_i.cost + edge_j.cost) * (n_j.getTreeSize() + n_i.getTreeSize());
            }
        }
        return sum;
    }
    
    
}
