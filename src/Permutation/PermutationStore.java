/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Permutation;

import icpc1.Problem;
import icpc1.ProblemStore;
import java.util.HashSet;

/**
 *
 * @author csc190
 */
public class PermutationStore implements ProblemStore{
    
    //Data Members
    
    protected HashSet<PermutationProblem> problemSet = new HashSet<PermutationProblem>();
    
    
    @Override
    public void registerVisited(Problem problem) {     
        
        this.problemSet.add(((PermutationProblem) problem).makeCopy());
    }

    @Override
    public boolean isVisited(Problem problem) {
        return this.problemSet.contains((PermutationProblem) problem);
    }
    
}
