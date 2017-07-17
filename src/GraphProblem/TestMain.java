/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphProblem;

/**
 *
 * @author csc190
 */
public class TestMain {
    // Test graph
    
    Entry [] arrEntires = new Entry [] {
        new Entry("A", "B", 10),
        new Entry("B", "C", 20)
    };
    Graph g1 = Graph.buildGraph(arrEntires);
}
