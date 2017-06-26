/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree1;

import java.util.LinkedList;

/**
 *
 * @author csc190
 */
public class TreeNode<T> {

    T data;
    TreeNode<T> left;
    TreeNode<T> right;
    TreeNode<T> neighbor;
    TreeNode<T> parent;

    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.neighbor = null;
        this.parent = null;
    }

    public void setRight(TreeNode<T> right){
        this.right = right;
        this.right.parent = this;
    }
    public void setLeft(TreeNode<T> left){
        this.left = left;
        this.left.parent = this;
    }
    
    public void setNeighbor(TreeNode<T> neighbor){
        this.neighbor = neighbor;
    }
    
    private String nodeToStr(TreeNode<T> n){
        return n==null? "NULL" : n.data.toString();
    }
    @Override
    public String toString(){
        return "Value: " + this.data.toString() + ", neightbor: " + 
                nodeToStr(this.neighbor) + ", left: " + nodeToStr(this.left)+
                ", right: " + nodeToStr(this.right);
    }
    
    public T getData(){
        return this.data;
    }
    
    public TreeNode<T> getParent(){
        return this.parent;
    }
    
    public TreeNode<T> getNeighbor(){
        return this.neighbor;
    }
    
    public TreeNode<T> getLeft(){
        return this.left;
    }
    
    public TreeNode<T> getRight(){
        return this.right;
    }

    public static void inOrder(TreeNode root){
        if(root == null){
            return;
        } else {
            inOrder(root.left);
            System.out.println(root);
            inOrder(root.right);
        }
    }
    
    public static void setNeighbors(TreeNode root){
        if(root == null)
        {
            return;
        } else {
            LinkedList<TreeNode> nodes = new LinkedList<>();
            LinkedList<Integer> layers = new LinkedList<>();
            nodes.add(root);
            layers.add(1);
           
            while(!nodes.isEmpty()){
                TreeNode node = nodes.removeFirst();
                Integer layer = layers.removeFirst();
                if(node.left!=null){
                    nodes.add(node.left);
                    layers.add(layer+1);
                }
                if(node.right!=null){
                    nodes.add(node.right);
                    layers.add(layer+1);
                }
                if(!nodes.isEmpty() && layers.peekFirst().equals(layer)){
                    node.setNeighbor(nodes.peekFirst());
                }
            }
        }
    }
    
    public static boolean compareInOrder(TreeNode treeNode1, TreeNode treeNode2){
        DFSExplorer explorer1 = new DFSExplorer(treeNode1);
        DFSExplorer explorer2 = new DFSExplorer(treeNode2);
        TreeNode nextNode1 = null;
        TreeNode nextNode2 = null;
        do {            
             nextNode1 = explorer1.getNext();
             nextNode2 = explorer2.getNext();
             
             if(nextNode1 == null && nextNode2 == null){
                 return true;
             }
             
             else if(nextNode1 == null && nextNode2 != null){
                 return false;
             }
             
             else if(nextNode1 != null && nextNode2 == null){
                 return false;
             }
             
             else{
                 if(!nextNode1.getData().equals(nextNode2.getData())){
                     return false;
                 }
                
             }
             
            
        } while (nextNode1 != null && nextNode2 != null);
        return false;
    }
       
}
