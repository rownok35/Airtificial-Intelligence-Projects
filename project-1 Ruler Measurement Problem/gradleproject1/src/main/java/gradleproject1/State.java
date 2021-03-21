/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradleproject1;

/**
 *
 * @author SHIKHON
 */
public class State {
    private int[] scale;
    
    public State(){
        scale = new int[2];
        scale[0]=5;
        scale[1]=7;
    }
    public State(int j0, int j1){
        scale = new int[2];
        scale[0]=j0;
        scale[1]=j1;
    }
    public String toString(){
        return ""+scale[0]+","+scale[1];
    }
    
    public State[] generateNextState(){
        State states[] = new State[2];
        for (int i=0; i<2; i++){
            states[i] =  new State(scale[0], scale[1]);
        }
        //
        states[0].scale[0] = scale[0]+5;
        //
        states[1].scale[1] = scale[1]+7;
        
        return states;
        
    }
    
    public int get_scale1(){
        return scale[1];
    }
    public int get_scale2(){
        return scale[0];
    }
}