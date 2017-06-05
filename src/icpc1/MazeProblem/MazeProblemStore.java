/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icpc1.MazeProblem;

import icpc1.Problem;
import icpc1.ProblemStore;

/**
 *
 * @author csc190
 */
public class MazeProblemStore implements ProblemStore{

    //data members
    protected int n;
    protected boolean [][] bVisited;
    //methods
    public MazeProblemStore(int mazesize){
        this.n = mazesize;
        bVisited = new boolean [n][n];
        for(int i=0; i<n; i++){
            bVisited[i] = new boolean [n];
            for(int j=0; j<n; j++){
                bVisited[i][j] = false;
            }
        }
    }
    @Override
    public void registerVisited(Problem problem) {
        MazeProblem mp = (MazeProblem) problem;
        int r = mp.currRow;
        int c = mp.currCol;
        bVisited[r][c] = true;
    }

    @Override
    public boolean isVisited(Problem problem) {
        MazeProblem mp = (MazeProblem) problem;
        int r = mp.currRow;
        int c = mp.currCol;
        return bVisited[r][c];
    }
    
}
