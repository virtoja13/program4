/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.probe;

import java.util.ArrayList;

/**
 *
 * @author JAVIER
 */
public class HallarValores {
    
    private double vs = 0.0;
    private double s = 0.0;        
    private double m = 0.0;
    private double l = 0.0;
    private double vl = 0.0;
    private double avg = 0.0;
    private double standarDeviation = 0.0;
    
    public static ArrayList<Data> datos1(){
        ArrayList<Data> listaDatos = new ArrayList<Data>();
        listaDatos.add(new Data(18,3));
        listaDatos.add(new Data(18,3));
        listaDatos.add(new Data(25,3));
        listaDatos.add(new Data(31,3));
        listaDatos.add(new Data(37,3));
        listaDatos.add(new Data(82,5));
        listaDatos.add(new Data(82,4));
        listaDatos.add(new Data(87,4));
        listaDatos.add(new Data(89,4));
        listaDatos.add(new Data(230,10));
        listaDatos.add(new Data(85,3));
        listaDatos.add(new Data(87,3));
        listaDatos.add(new Data(558,10));
        return listaDatos; 
    }
    
    public static ArrayList<Data> datos2(){
        ArrayList<Data> listaDatos = new ArrayList<Data>();
        listaDatos.add(new Data(7,1));
        listaDatos.add(new Data(12,1));
        listaDatos.add(new Data(10,1));
        listaDatos.add(new Data(12,1));
        listaDatos.add(new Data(10,1));
        listaDatos.add(new Data(12,1));
        listaDatos.add(new Data(12,1));
        listaDatos.add(new Data(12,1));
        listaDatos.add(new Data(12,1));
        listaDatos.add(new Data(8,1));
        listaDatos.add(new Data(8,1));
        listaDatos.add(new Data(8,1));
        listaDatos.add(new Data(20,1));
        listaDatos.add(new Data(14,1));
        listaDatos.add(new Data(18,1));
        listaDatos.add(new Data(12,1));
        return listaDatos; 
    }
    
    public ArrayList<Double> logaritmoNatural(ArrayList<Data> listaDatos){
        ArrayList<Double> resultado = new ArrayList<Double>();
        for(Data datos: listaDatos){
            resultado.add(Math.log(datos.getX()/datos.getY()));
        }
        return resultado;
    }
    
    public void avg(ArrayList<Double> listaDouble){
        for(Double valor: listaDouble){
            avg += valor;
        }
        avg = avg/listaDouble.size();
    }

    public void CalcularStandardDeviation(ArrayList<Double> listaDouble){
        for(Double valor: listaDouble){
            standarDeviation += (valor - avg)*(valor - avg);
        }
        standarDeviation = Math.sqrt(standarDeviation/(listaDouble.size()-1));
    }
    
    public void calcularRangos(){
        vs = Math.exp(avg-(2*standarDeviation));
        s = Math.exp(avg-standarDeviation);
        m = Math.exp(avg);
        l = Math.exp(avg+standarDeviation);
        vl = Math.exp(avg+(2*standarDeviation));
    }
    
    public double getVs() {
        return vs;
    }

    public double getS() {
        return s;
    }

    public double getM() {
        return m;
    }

    public double getL() {
        return l;
    }

    public double getVl() {
        return vl;
    }
    
}