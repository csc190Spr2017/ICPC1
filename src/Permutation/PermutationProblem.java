/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Permutation;

import icpc1.Action;
import icpc1.Problem;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author csc190
 */
public class PermutationProblem implements Problem {
    
    protected ArrayList<Integer> arrPrefix = new ArrayList<Integer>();
    protected TreeSet<PermutationAction> setOfAvailActions = new TreeSet<PermutationAction>();
    
    public PermutationProblem makeCopy(){
        PermutationProblem other = new PermutationProblem();
        other.arrPrefix = (ArrayList<Integer>) this.arrPrefix.clone();
        other.setOfAvailActions = (TreeSet<PermutationAction>)this.setOfAvailActions.clone();
        return other;
    }
    public PermutationProblem(){
        for(int i = 1; i <= 9; i++){
            this.setOfAvailActions.add(new PermutationAction((i)));
        }
    }
    
    @Override
    public String ToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Prefix: ");
        for(Integer num: arrPrefix){
            sb.append(num + " ");            
        }
        sb.append(", Available Actions: ");
        for(Action act: this.setOfAvailActions){
            sb.append(act.toString() + " " );
        }
        return sb.toString();
    }

    @Override
    public Action getNextAction() {
        if(this.setOfAvailActions.isEmpty())return null;
        else{
            PermutationAction pAction = this.setOfAvailActions.iterator().next();
            this.setOfAvailActions.remove(pAction);
            return pAction;
        }
    }

    @Override
    public void applyAction(Action act) throws Exception {
        arrPrefix.add(((PermutationAction) act).num);
    }

    @Override
    public void revokeAction(Action act) throws Exception {
        Integer iObjToRemove = new Integer(((PermutationAction) act).num);
        arrPrefix.remove(iObjToRemove);
        this.setOfAvailActions.add(((PermutationAction) act));
    }

    @Override
    public boolean isSolved() {
        return (arrPrefix.size() == 9);
    }
    
    @Override
    public boolean equals(Object other){
        if(!(other instanceof PermutationProblem)){
            return false;
        }
        PermutationProblem pother = (PermutationProblem) other;
        return (pother.arrPrefix.equals(this.arrPrefix) && pother.setOfAvailActions.equals(this.setOfAvailActions));
    }

    @Override
    public String toString(){
        return ToString();
    }
}
