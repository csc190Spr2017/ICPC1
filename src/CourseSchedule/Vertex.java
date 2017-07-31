/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseSchedule;

import java.util.ArrayList;

/**
 *
 * @author csc190
 */
public class Vertex implements Comparable{
    
    protected ArrayList<Vertex> arrNext = new ArrayList<Vertex>();
    protected int countPred = 0;
    String name = null;
    
    public Vertex(String newName){
        name = newName;
    }
    
    @Override
    public int compareTo(Object o) {
        Vertex v = (Vertex)o;
        return this.countPred-v.countPred;
    }
    
}
