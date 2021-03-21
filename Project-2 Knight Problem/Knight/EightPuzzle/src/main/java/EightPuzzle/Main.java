/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EightPuzzle;

/**
 *
 * @author SHIKHON
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int start[][] = {{2, 1, 2, 1, 1}, {1, 1, 2, 0, 1}, {2, 1, 1, 1, 2}, {2, 1, 2, 1, 2},{2, 2, 1, 2, 2}};
        int goal[][] = {{1, 1, 1, 1, 1}, {2, 1, 1, 1, 1}, {2, 2, 0, 1, 1}, {2, 2, 2, 2, 1},{2, 2, 2, 2, 2}};
       
        State.goal = goal;
        State s1 = new State(start);

        Solver s = new Solver();
        s.A_star(s1);
        //s.printPath(s1);
    }
    
}
