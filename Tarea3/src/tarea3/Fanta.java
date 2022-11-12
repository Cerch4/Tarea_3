package tarea3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Fanta extends Bebida{
    private int  x;
    private int y;
    public Fanta(int numSerie){
        super(numSerie);
        x = 325;
        y = 200;
    }
    @Override
    public String beber(){
        return "Fanta";
    }
      @Override
    public void paint (Graphics g){
        Polygon p = new Polygon();
        p.addPoint(this.x,this.y);
        p.addPoint(x+40, y);
        p.addPoint(x+40, y+80);
        p.addPoint(x, y+80);
        
        g.setColor(Color.orange);
        g.fillPolygon(p);
        if(p!=null)g.drawPolygon(p);
     }
    @Override
    public int getx(){
        return x;
    }
    @Override
    public int gety(){
        return y;
    }
}
