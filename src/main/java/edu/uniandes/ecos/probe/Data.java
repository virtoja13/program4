/*
*Clase que contiene los datos para realizar las operaciones
*@author: José Javier Virviescas Toledo
*@version: 1.0
*/
package edu.uniandes.ecos.probe;
 
public class Data {
     
    private double x;
    private double y;

    public Data(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    
    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }
 
}