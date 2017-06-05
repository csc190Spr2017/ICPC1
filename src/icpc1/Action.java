/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icpc1;

/**
 * Interface represents one action
 * @author csc190
 */
public interface Action {
    /* check it is equivalent to the other */
    public boolean isEquivalentTo(Action other);
    
    /* public convert to a string */
    public String ToString();
}
