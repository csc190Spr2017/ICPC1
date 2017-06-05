/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icpc1;

/**
 * A store of visited problem instance
 * @author csc190
 */
public interface ProblemStore {
    /* report that the problem is visited */
    public void registerVisited(Problem problem);
    
    /* is the problem instance visited before */
    public boolean isVisited(Problem problem);
}
