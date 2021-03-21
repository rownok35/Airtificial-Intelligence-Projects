/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

public class City {

    private double x;
    private double y;

    public City() {
        
    }
    public City(double x,double y)
    {
        this.x=x;
        this.y=y;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void print()
    {
        System.out.println("x "+this.x+"  y "+this.y);
    }

    public double distanceToCity(City city) {
        double x = Math.abs(getX() - city.getX());
        double y = Math.abs(getY() - city.getY());
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

}
