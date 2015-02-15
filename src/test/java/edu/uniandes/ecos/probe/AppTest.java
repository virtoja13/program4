/*
*Clase para realizar las pruebas unitarias del programa
*@author: José Javier Virviescas Toledo
*@version: 1.0
*/
package edu.uniandes.ecos.probe;

import java.text.DecimalFormat;
import java.util.ArrayList;
import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;

public class AppTest extends TestCase{
    DecimalFormat df = new DecimalFormat("#.####");
 
    public void testDatos1(){
        HallarValores valores = new HallarValores();
        ArrayList<Double> listaLN = valores.logaritmoNatural(HallarValores.datos1());
        valores.avg(listaLN);
        valores.CalcularStandardDeviation(listaLN);
        valores.calcularRangos();
        assertTrue( df.format(valores.getVs()).equals("4,3953") );
        assertTrue( df.format(valores.getS()).equals("8,5081") );
        assertTrue( df.format(valores.getM()).equals("16,4696") );
        assertTrue( df.format(valores.getL()).equals("31,8811")  );
        assertTrue( df.format(valores.getVl()).equals("61,7137") );
    }
    
    public void testDatos2(){
        HallarValores valores = new HallarValores();
        ArrayList<Double> listaLN2 = valores.logaritmoNatural(HallarValores.datos2());
        valores.avg(listaLN2);
        valores.CalcularStandardDeviation(listaLN2);
        valores.calcularRangos();
        assertTrue( df.format(valores.getVs()).equals("6,3375") );
        assertTrue( df.format(valores.getS()).equals("8,4393") );
        assertTrue( df.format(valores.getM()).equals("11,2381") );
        assertTrue( df.format(valores.getL()).equals("14,965")  );
        assertTrue( df.format(valores.getVl()).equals("19,928") );
    }

}