/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea3;
import java.awt.*;
/**
 *
 * @author Cesar
 */
public class DrawExpendedor{
    private Polygon p;
    private Polygon q;
    private Polygon q;
    private int x,y;
    public DrawExpendedor(){
        this.x=50;
        this.y=50;
        p = new Polygon();
        p.addPoint(x,y);
        p.addPoint(x+400, y);
        p.addPoint(x+400, y+500);
        p.addPoint(x, y+500);
        
        q = new Polygon();
        q.addPoint(x+50, y+400);
        q.addPoint(x+350, y+400);
        q.addPoint(x+350, y+475);
        q.addPoint(x+50, y+475);
       
    }
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillPolygon(p);
        if(p!=null)g.drawPolygon(p);
      
         g.setColor(Color.blue);
         g.fillPolygon(q);
         if(q!=null)g.drawPolygon(q);
     } 
}

