/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree1;

import java.util.Arrays;

/**
 *
 * @author csc190
 */
public class Tree1Main {

    public static void main(String[] args) {
       /* TreeNode<String> A = new TreeNode<String>("A");
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
        */
       
        int [] BSTnodes = {1,4,7,2,8,3,9,0};
        BSTNode root = null;        
        for(int i = 0; i < BSTnodes.length; i++){            
            root = BSTNode.insert(BSTnodes[i], root);
        }
        
        Arrays.sort(BSTnodes);
        for(int i=0; i<BSTnodes.length-1; i++){
            BSTNode node = root.find(BSTnodes[i]);
            BSTNode nextNode = node.getNext();
            if(!nextNode.data.equals(BSTnodes[i+1])){
                System.out.println("ERROR!");
            }
        }
        
        int [] preorder = new int [] {1, 0, 4, 2, 3};
        int [] inorder = new int [] {0, 1, 2, 3, 4};
        TreeNode root2 = TreeNode.buildFromOrder(preorder, 0, inorder, 0, 5);
        
        System.out.println("Pre-order");
        TreeNode.preorder(root2);
        System.out.println("In-order");
        TreeNode.inorder(root2);
        
    }

}
