/*
*Clase principal para ralizar el PROBE 
*@author: José Javier Virviescas Toledo
*@version: 1.0
*/
package edu.uniandes.ecos.probe;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Hello world!
 *
 */
public class PrincipalPROBE extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        resultado(req, resp);
    }
     
    private void resultado(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        DecimalFormat df = new DecimalFormat("#.####");
        PrintWriter out = resp.getWriter();
        ArrayList<HallarValores> listaValores = new ArrayList<HallarValores>();
        //LOC/METHOD
        HallarValores valores1 = new HallarValores();
        ArrayList<Double> listaLN = valores1.logaritmoNatural(HallarValores.datos1());
        valores1.avg(listaLN);
        valores1.CalcularStandardDeviation(listaLN);
        valores1.calcularRangos();
        listaValores.add(valores1);
        //PGS/CHAPTER
        HallarValores valores2 = new HallarValores();
        ArrayList<Double> listaLN2 = valores2.logaritmoNatural(HallarValores.datos2());
        valores2.avg(listaLN2);
        valores2.CalcularStandardDeviation(listaLN2);
        valores2.calcularRangos();
        listaValores.add(valores2);
        
        out.println("<html>");
        out.println("<body>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<th></th>");
        out.println("<th>VS</th>");
        out.println("<th>S</th>");
        out.println("<th>M</th>");
        out.println("<th>L</th>");
        out.println("<th>VL</th>");
        out.println("</tr>");
        out.println("<tr align='center'>");
        int i = 1;
        for(HallarValores valor : listaValores){
            out.println("<td>TEST"+i+"</td>");
            out.println("<td>"+df.format(valor.getVs())+"</td>");
            out.println("<td>"+df.format(valor.getS())+"</td>");
            out.println("<td>"+df.format(valor.getM())+"</td>");
            out.println("<td>"+df.format(valor.getL())+"</td>");
            out.println("<td>"+df.format(valor.getVl())+"</td>");
            out.println("</tr>");
            i++;
        }
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        resp.getWriter().print(out);
    }
     
    public static void main(String[] args) throws Exception{
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new PrincipalPROBE()),"/*");
        server.start();
        server.join();
    }
    
}

//error se puso primero s en lugar de vs y por eso se mostro mal.
//error en test para el formato que se quiere mostrar el numero se paso 0 al final y no se puede