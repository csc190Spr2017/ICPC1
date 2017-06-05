/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icpc1.MazeProblem;

import icpc1.Action;
import icpc1.Problem;

/**
 * 1 means block, and 0 means can go
 * @author csc190
 */
public class MazeProblem implements Problem{
    
    //--------- DATA MEMBERS 
    protected int [][] arrMaze;
    protected int entryRow, entryCol, exitRow, exitCol;
    protected int currRow, currCol;
    protected int [][] actions;
    protected MazeAction [] ACTIONS;
    //---------------------------------
    
    //METHODS 
    //--------------------------------------
    
    /**
     * entryRow, col should be in range [0, n-1], assume n is the size
     * @param arrMaze
     * @param entryRow
     * @param entryCol
     * @param exitRow
     * @param exitCol 
     */
    public MazeProblem(int [][] arrMazeInput, int entryRowInput, 
            int entryColInput,  int exitRowInput, int exitColInput){
        this.arrMaze = arrMazeInput;
        this.entryRow = entryRowInput;
        this.exitCol = exitColInput;
        this.entryCol = entryColInput;
        this.exitRow = exitRowInput;    
        int n = this.arrMaze.length;
        this.actions = new int [n][n];
        for(int i=0; i<n; i++){
            this.actions[i] = new int [n];
            for(int j=0; j<n; j++){
                this.actions[i][j] = -1;
            }
        }
        this.ACTIONS = new MazeAction [] {
          new MazeAction(-1, 0),
          new MazeAction(1, 0),
          new MazeAction(0, -1),
          new MazeAction(0, 1)
   
        };
    }

    @Override
    public Action getNextAction() {
        //1. check the available id ONE by one
        for(int idxAct = this.actions[this.currRow][this.currCol]+1;
                 idxAct<4; idxAct++){
            MazeAction ma = this.ACTIONS[idxAct];
            int nextRow = this.currRow + ma.rowOffset;
            int nextCol = this.currCol + ma.colOffset;
            if(!isOK(nextRow, nextCol)) continue;
            
            //this is a good one
            return ma;
        }
        return null;
    }

    private boolean isOK(int r, int c){
        int n = this.arrMaze.length;
        return !(r<0 || r>=n || c<0 || c>=n || this.arrMaze[r][c]!=0);
    }
    private void checkOK() throws Exception{
        
        if(this.isOK(this.currRow, this.currCol)){
            throw new Exception("IT'S not good!");
        }
    }
    @Override
    public void applyAction(Action act) throws Exception {
        MazeAction ma = (MazeAction) act;
        this.currRow += ma.rowOffset;
        this.currCol += ma.colOffset;
        //make some check
        checkOK();
    }

    @Override
    public void revokeAction(Action act) throws Exception {
        MazeAction ma = (MazeAction) act;
        this.currRow -= ma.rowOffset;
        this.currCol -= ma.colOffset;
        //make some check
        checkOK();}

    @Override
    public boolean isSolved() {
        return this.currRow == this.exitRow && this.currCol==this.exitCol;
    }

    @Override
    public String ToString() {
        return "cur: (" + this.currRow + ", " + this.currCol + ")";
    }
    
    
    
}
