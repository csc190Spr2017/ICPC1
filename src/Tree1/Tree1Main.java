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
public class Tree1Main {

    public static void main(String[] args) {
        TreeNode<String> A = new TreeNode<String>("A");
        TreeNode<String> B = new TreeNode<String>("B");
        TreeNode<String> C = new TreeNode<String>("C");       
        
        B.setLeft(A);
        B.setRight(C);
        
        TreeNode<String> A2 = new TreeNode<String>("A");
        TreeNode<String> B2 = new TreeNode<String>("B");
        TreeNode<String> C2 = new TreeNode<String>("C");       
        
        A2.setRight(B2);
        B2.setRight(C2);
        
        boolean bRes = TreeNode.compareInOrder(B, A2);
        
        
        
    }

}
