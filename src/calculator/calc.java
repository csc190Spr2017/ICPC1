/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.Stack;

/**
 *
 * @author csc190
 */
public class calc {
    protected static boolean isNumber(String str){
        try{
            int number = Integer.parseInt(str);
        } catch(Exception ex){
            return false;
        }
        return true;
    }
    
    /* apply the "op" on the stacik. If it's regular mode, pop two elements, otherwise
    pop all elements out until you see a "null" which stands for the RIGHT PARENTHESIS
    */
    protected static int arithOp(Stack<Integer> stack, String op, boolean bRegular){
        int counter = 0;
        int acc = op.equals("*")? 1:0;  
        //bRegular true if only 2 elements
        boolean doBreak = false;
        while(!stack.isEmpty() && !doBreak){
            Integer currNum = stack.pop();
            counter++;
            doBreak = bRegular? counter==2: currNum==null;
            
            if(op.equals("+")){
                acc += currNum;
            }
            else{
                acc *= currNum;
            }
        }
        stack.push(acc);
        return acc;
    }
    public static int calcPolish(String sexpr) throws Exception{
        //1. split and get array
        String [] arr = sexpr.split(" ");
        int idx = arr.length-1;
        
        //2.  big while loop that scans from the right to left
        Stack<Integer> stack = new Stack<Integer>(); 
        //null stands for RIGHT PARENTHSIS
        while(idx>=0){
            String item = arr[idx];
            //case 2.1 if it's ")"
            if(item.equals(")")){
                stack.push(null);
            }
            //case 2.2 if it's number
            else if(isNumber(item)){
                stack.push((new Integer(item)));               
            }
            //case 2.3 if it's operator "+"
            //case 2.4 if it's operator "-"
            else if(item.equals("+") || item.equals("-")){
                boolean breg = idx == 0?true : ! arr[idx-1].equals("(");
                arithOp(stack, item, breg);
                
            }
            else{
                throw new Exception ("Unsupported syntax");
            }
            //NOTE: no case for "("
            idx--;
        }
        return stack.pop();
    }
    public static void main(String [] args) throws Exception{
      String [] arrInputs = { "( + 1 2 )"};
      int [] arrExpected = {3};
      for(int i=0; i<arrInputs.length; i++){
          String sInput = arrInputs[i];
          int expected = arrExpected[i];
          int actual = calcPolish(sInput);
          if(actual!=expected){
              System.out.println("Error for i: " + i + ", actual: " + actual + ", expected: " + expected);
          }
      }
    }
}
