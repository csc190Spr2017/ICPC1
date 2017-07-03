/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree1;

/**
 *
 * @author csc190
 */
public class BSTNode<T> extends TreeNode{
    
    public BSTNode(Comparable data) {
        super(data);
    }
    
    public static BSTNode insert(Comparable data, BSTNode root){
        if(root == null){
            return new BSTNode(data);
        } else if(root.data.compareTo(data) > 0) {
            root.setLeft(insert(data, (BSTNode)root.left));
            return root;
        } else if(root.data.compareTo(data) < 0){
            root.setRight(insert(data, (BSTNode) root.right));
            return root;
        } else {
            return root;
        }
    }
    
    public boolean isLeftChild(){
        return this.parent==null? false: this.parent.left==this;
    }
    
    public boolean isRightChild(){
        return this.parent == null ? false: this.parent.right == this;
    }
    
    public BSTNode getNext(){
        BSTNode ret = null;
        if(this.right != null){
            ret = (BSTNode) this.right; //move one step down
            //move 0 or more steps to the right until it's null
            while(ret.left!=null){
                ret = (BSTNode) ret.left;
            }
        }else{
            ret = this;
            while(ret != null && ret.isRightChild()){
                ret = (BSTNode) ret.parent;
            }
            ret = ret == null? null: (BSTNode)ret.parent; 
        }     
        return ret;
    }
    
    public BSTNode find(Comparable data){
        if(this.data.equals(data)) return this;
        else if(this.data.compareTo(data)>0){//search left
            return this.left==null? null: ((BSTNode)this.left).find(data);
        }else{
            return this.right==null? null: ((BSTNode)this.right).find(data);
        }
    }
    
}
