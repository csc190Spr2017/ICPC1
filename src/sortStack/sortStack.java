/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortStack;

import java.util.Stack;

/**
 *
 * @author csc190
 */
public class sortStack {

    protected static Stack<Integer> pop(Stack<Integer> stack, int number) {
        Stack<Integer> s2 = new Stack<Integer>();
        for (int i = 0; i < number; i++) {
            s2.push(stack.pop());
        }
        return s2;
    }

    public static void sort(Stack<Integer> stack) {
        if(stack==null || stack.size()<=1) return;
        
        int n = stack.size();
        int n2 = n / 2;
        //1. let s2 take the 2nd half of the stack
        Stack<Integer> s2 = pop(stack, n2);

        //2. let s1 take the 1st half of the stack
        Stack<Integer> s1 = pop(stack, n - n2);

        //3. recursively sort
        sort(s1);
        sort(s2);
        //4. merge
        Stack<Integer> stackTemp = new Stack<Integer>();
        while (!s1.isEmpty() || !s2.isEmpty()){
            if(s1.isEmpty()){
                stackTemp.push(s2.pop());
            }
            else if(s2.isEmpty()){
                stackTemp.push(s1.pop());
            }
            else if(s1.peek() > s2.peek()) {
                stackTemp.push(s1.pop());
            } else {
                stackTemp.push(s2.pop());
            }
            
            
            
            /*
            Stack<Integer> toPop = s1.isEmpty()? s2:
               (s2.isEmpty()? s1: (s1.peek()>s2.peek()? s1: s2));
            stack.push(toPop.pop());
            */
        }//end of while loop
        
        int size = stackTemp.size();
            for(int i=0; i<size; i++){
                stack.push(stackTemp.pop());
            }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] arr = new int[]{1, 2, 4, 3, 6, 5, 100};
        for (int i = 0; i < arr.length; i++) {
            stack.add(arr[i]);
        }
        sort(stack);
        for (int i = 0; i < stack.size(); i++) {
            System.out.println(stack.get(i));
        }
    }
}
