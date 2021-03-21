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

/**
 *
 * @author SHIKHON
 */
class BFS {
    Queue<State> queue;
    HashSet<String> visited;
    HashSet<String> explored;
    
    LinkedList<ArrayList<String>> paths;
    ArrayList<String> shortest_path;
    
    public BFS(){
        queue = new LinkedList<>();
        visited = new HashSet<>();
  	explored = new HashSet<>();
        paths = new LinkedList<>();
        shortest_path=new ArrayList<>();
    }
    
    public void printPath(){
        for (String s: shortest_path){
            System.out.println(s);
        }
    }
    
    
    
    public void start(State s){
        queue.add(s);
        State v_list[];
        
        ArrayList<String> r = new ArrayList<>();
        r.add(s.toString());
        paths.add(r);
        
        while(queue.size()!=0){
            State s1 = queue.poll();
            visited.add(s1.toString());
            
            shortest_path = paths.poll();
            
            if(Math.abs(s1.get_scale1()-s1.get_scale2())==1){
                System.out.println("Reached");
                System.out.println("Scale1 Scale2");
                return;
            }
            v_list = s1.generateNextState();
            for(State v: v_list){
                if(visited.contains(v.toString())){
                    continue;
                }
		if(explored.contains(v.toString())){
                    continue;
                }
                
                queue.add(v);
		explored.add(v.toString());
                ArrayList<String> r1 = new ArrayList<>(shortest_path);
                r1.add(v.toString());
                paths.add(r1);
                
            }
        }
    }
    
}