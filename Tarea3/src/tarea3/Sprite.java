package tarea3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Sprite extends Bebida{
    private int  x;
    private int y;
    public Sprite(int numSerie){
        super(numSerie);
        x = 225;
        y = 200;
    }
    @Override
    public String beber(){
        return "Sprite";
    }
      @Override
    public void paint (Graphics g){
        Polygon p = new Polygon();
        p.addPoint(this.x,this.y);
        p.addPoint(x+40, y);
        p.addPoint(x+40, y+80);
        p.addPoint(x, y+80);
        
        g.setColor(Color.green);
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
