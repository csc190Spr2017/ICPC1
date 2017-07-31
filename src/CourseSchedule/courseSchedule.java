/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseSchedule;

/**
 *
 * @author csc190
 */
public class courseSchedule {
    public static void main(String [] args){
        String [][] schedule = {
            {"csc15", "csc16"},
            {"csc16", "csc17"},
            {"csc17","csc15"}
        };
        boolean result = solve(schedule);
        System.out.println("result is " + result);
    }
    public static boolean solve(String [][] schedule){
        Graph g = Graph.constructGraph(schedule);
        Vertex v = g.getRootVertex();
        while(v != null){
            g.remove(v);
            v = g.getRootVertex();
        }
        return g.getNumVertex()==0;
    }
}
