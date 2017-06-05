/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icpc1;

/**
 * Represents an instance of problem to solve.
 * @author csc190
 */
public interface Problem {
    /* Need for convenient debugging. */
    public String ToString();
    
    /* get the next action, note: avoid generate the same one! 
    return null when there is no more;
      the next action should be APPLICABLE! you should not return WRONG moves!
    but you do can visit the same NEXT state, this will be protected by our code.
    */
    public Action getNextAction();
    
    /* apply one action, throw exception if cannot apply */
    public void applyAction(Action act) throws Exception;
    
    /* cancel one action and back off to the previous state */
    public void revokeAction(Action act) throws Exception;
    
    /* returns true if currently the problem is solved */
    public boolean isSolved();
    
}
