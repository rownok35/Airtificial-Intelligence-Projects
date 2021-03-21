/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;




public class Travel {
    
    public int num_city=0;
    private ArrayList<Double> arraylist=new ArrayList();
  

    private ArrayList<City> travel = new ArrayList<>();
    private ArrayList<City> previousTravel = new ArrayList<>();

    public Travel()  {
       try {
           this.input();
       }
        catch(Exception e) {
             //  Block of code to handle errors
       }
           
    }

      public static int lineNumber = 0;
    
    
    
    public  void input() throws FileNotFoundException
    {
        File file = new File("D:\\AI\\TSP\\ALL_tsp\\test2.txt");
       
          Scanner scnr = new Scanner(file);
     
        
        
        
        try{
            while(scnr.hasNextLine()){
            //String line = scnr.nextLine();
            Double x=scnr.nextDouble();
            arraylist.add(x);
            
             //System.out.println("line " + lineNumber + " :" + x);
            lineNumber++;
        }  
        }
        catch(Exception e) {
             //  Block of code to handle errors
       }
        
        //System.out.println("line number "+lineNumber);
        
        
         for (int i = 0; i < arraylist.size();i=i+2) 
	      { 		      
	          //System.out.println(arraylist.get(i)+" "+arraylist.get(i+1)); 
                  City c=new City(arraylist.get(i),arraylist.get(i+1));
                  travel.add(c);
                  
                  
                  
	      } 
         num_city=travel.size();
        
    }
    
    public void generateInitialTravel() {
        
        Collections.shuffle(travel);
    }

    public void swapCities() {
        int a = generateRandomIndex();
        int b = generateRandomIndex();
        previousTravel = travel;
        City x = travel.get(a);
        City y = travel.get(b);
        travel.set(a, y);
        travel.set(b, x);
    }

    public void revertSwap() {
        travel = previousTravel;
    }

    private int generateRandomIndex() {
        return (int) (Math.random() * travel.size());
    }

    public City getCity(int index) {
        return travel.get(index);
    }

    public double getDistance() {
        double distance = 0;
        for (int index = 0; index < travel.size(); index++) {
            City starting = getCity(index);
            City destination;
            if (index + 1 < travel.size()) {
                destination = getCity(index + 1);
            } else {
                destination = getCity(0);
            }
            distance += starting.distanceToCity(destination);
        }
        return distance;
    }

}

  

