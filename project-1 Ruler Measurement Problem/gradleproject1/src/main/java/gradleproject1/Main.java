/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradleproject1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.lang.Math;
/**
 *
 * @author SHIKHON
 */
/*public class Main {

    /**
     * @param args the command line arguments
     */
   // public static void main(String[] args) {
     //   State s=new State();
        
       /*
        State v_list[];
        v_list=s.generateNextState();
        //System.out.println(s.toString());
        for(State v: v_list){
            System.out.println(v.scale1()+"   "+v.scale2());
        }
        
        
    }
    
}
*/

public class Main {

    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
       State s = new State();
       System.out.println(s.toString());
       BFS startSearch = new BFS();
       startSearch.start(s);
       startSearch.printPath();
       //startSearch.printAllPath();
    }
    
}


