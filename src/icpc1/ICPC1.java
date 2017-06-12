/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icpc1;

import Permutation.PermutationProblem;
import Permutation.PermutationStore;
import icpc1.MazeProblem.MazeProblem;
import icpc1.MazeProblem.MazeProblemStore;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author csc190
 */
public class ICPC1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        /*
        MazeProblemStore ms = new MazeProblemStore(3);
        MazeProblem mp = new MazeProblem(
                new int [][] {
                    {0, 0, 1},
                    {0, 1, 1},
                    {0, 0, 0},
                    
                }, 0, 0, 2, 2
        );
        BTAlg alg = new BTAlg();
        ArrayList<Stack<Action>> arrSol = alg.solveAll(mp, ms);
        for(int i=0; i<arrSol.size(); i++){
            alg.printSolution(arrSol.get(i), i);
        }
        */
        
        //Permutation Problem
        PermutationStore ps = new PermutationStore();
        PermutationProblem pp = new PermutationProblem();
        BTAlg algPerm = new BTAlg();
        ArrayList<Stack<Action>> arrSolPerm = algPerm.solveAll(pp, ps);
         for(int i=0; i<arrSolPerm.size(); i++){
            algPerm.printSolution(arrSolPerm.get(i), i);
        }
    }
    
}
