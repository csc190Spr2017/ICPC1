/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icpc1;

import java.util.ArrayList;
import java.util.Stack;

/**
 * General backtrack algorithm
 * @author csc190
 */
public class BTAlg {
 
    /**
     * Each solution is one array list of actions. 
     * Backtrack algorithm
     * @param prob
     * @return 
     */
    public ArrayList<Stack<Action>> solveAll(Problem prob, ProblemStore pstore)
        throws Exception{
        Stack<Action> stackSolution = new Stack<Action>();
        ArrayList<Stack<Action>> arrRet = new ArrayList<Stack<Action>>();
        
        //backtrack until there is no one in the stack
        pstore.registerVisited(prob);
        do{
            //0. if the problem is solved, backtrack directly
            String probStr = prob.toString();
            Action nextAct = prob.getNextAction();
            boolean bSolved = prob.isSolved();
            if(bSolved || nextAct==null){
                Action lastAct = stackSolution.peek();
                if(bSolved){                    
                    arrRet.add((Stack<Action>)stackSolution.clone());
                }
                stackSolution.pop();
                prob.revokeAction(lastAct);
                
            }else{            
                prob.applyAction(nextAct);
                if(pstore.isVisited(prob)){
                    prob.revokeAction(nextAct);
                }else{//good, go ahead
                    if(!prob.isSolved()){
                        pstore.registerVisited(prob);
                    }
                    stackSolution.add(nextAct);
                }
                
            }
            
        }while(!stackSolution.isEmpty());
        
        return arrRet;
    }
    
    /* Print out one solution */
    public void printSolution(Stack<Action> solution, int id){
        System.out.println("Solution: " + id + "-----");
        for(int i=0; i<solution.size(); i++){
           System.out.println(solution.get(i).toString());
        }
    }
}
