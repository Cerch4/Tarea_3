/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 *
 * @author Cesar
 */

public class Comprador {
    private int vuelto = 0;
    private String flavor;
    private int  x;
    private int y;
    public Comprador(Moneda money, int sabor, Expendedor exp) throws NoHayBebidaException, PagoIncorrectoException, PagoInsuficienteException{
        x = 300;
        y = 300;
        exp.comprarBebida(money, sabor);
        while(true){
            Moneda m = exp.getVuelto();
            if (m == null) {
                break;
            }
            vuelto = vuelto + m.getValor();
        }
        flavor = exp.getBebida().beber();
    }
    public int cuantoVuelto(){
        return(vuelto);
    }
    
    public String queBebiste(){
        return(flavor);
    }
    
    public void paint(Graphics g){
        Polygon p = new Polygon();
        
        p.addPoint(x,y);
        p.addPoint(x+40, y);
        p.addPoint(x+40, y+50);
        p.addPoint(x, y+50);
        
        g.setColor(Color.red);
        g.fillPolygon(p);
        if(p!=null)g.drawPolygon(p);
     } 
}
