/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icpc1.MazeProblem;

import icpc1.Action;

/**
 *
 * @author csc190
 */
public class MazeAction implements Action{
    //data member
    protected int rowOffset, colOffset;
    
    //methods
    public MazeAction(int rowO, int colO){
        this.rowOffset = rowO;
        this.colOffset = colO;
    }
    
    @Override
    public boolean isEquivalentTo(Action other) {
        if(!(other instanceof MazeAction)) return false;
        
        MazeAction mOther = (MazeAction) other;
        return this.rowOffset==mOther.rowOffset &&
                this.colOffset==mOther.colOffset;
    }
    
    @Override
    public String ToString(){
        return "(" + this.rowOffset + ", " + this.colOffset + ")";
    }
    
     @Override
    public String toString(){
        return this.ToString();
    }
    
}
