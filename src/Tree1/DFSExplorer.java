/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree1;

import java.util.Stack;

/**
 *
 * @author csc190
 */
public class DFSExplorer<T extends Comparable<T>> {

    Stack<stackElement> stack = new Stack<stackElement>();

    public enum STATE {
        NOT_PROCESSED, LEFT_PROCESSED, RIGHT_PROCESSED
    };

    class stackElement {

        public STATE state;
        public TreeNode<T> node;

        public stackElement(STATE s, TreeNode<T> node) {
            this.node = node;
            this.state = s;
        }
    }

    public DFSExplorer(TreeNode<T> tNode) {
        stackElement ele = new stackElement(STATE.NOT_PROCESSED, tNode);
        stack.push(ele);
    }

    public TreeNode<T> getNext() {

        if (stack.isEmpty()) {
            return null;
            
        } else {
            while(!stack.isEmpty()){
                stackElement result = stack.peek();
                TreeNode<T> node = result.node;
                if(result.state==STATE.NOT_PROCESSED){
                    //handle the left children
                    if(node.left!=null){
                        stack.push(new stackElement(STATE.NOT_PROCESSED, node.left));
                    }
                    result.state = STATE.LEFT_PROCESSED;
                    
                        
                }else if(result.state==STATE.LEFT_PROCESSED){
                    if(node.right != null){
                        stack.push(new stackElement(STATE.NOT_PROCESSED, node.right));
                    }
                    result.state = STATE.RIGHT_PROCESSED;
                    return node;
                    
                }else{//BOTH processed
                    stack.pop();
                }
            }
            return null;
        }
    }

}
