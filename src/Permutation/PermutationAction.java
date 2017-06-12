/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Permutation;

import icpc1.Action;

/**
 * represets the next number to include
 * @author csc190
 */
public class PermutationAction implements Action, Comparable{
    //data members
    int num;
    //-------------------
    
    //functions
    public PermutationAction(int n){
        this.num = n;
    }
    @Override
    public boolean isEquivalentTo(Action other) {
        if(!(other instanceof PermutationAction)) return false;
        PermutationAction paOther = (PermutationAction) other;
        return paOther.num == this.num;
    }
    
    @Override
    public String toString(){
        return String.valueOf(this.num);
    }

    @Override
    public String ToString() {
        return String.valueOf(this.num);
    }

    @Override
    public int compareTo(Object o) {
        PermutationAction pa = (PermutationAction) o;
        return this.num - pa.num;
    }
    
}
