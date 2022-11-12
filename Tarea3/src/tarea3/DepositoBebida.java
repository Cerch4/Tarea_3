package tarea3;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.HashSet;
public class DepositoBebida {
    private int  x;
    private int y;
    private ArrayList<Bebida> al;
    public DepositoBebida(){
        al = new ArrayList<Bebida>();
    }
    public void addBebida(Bebida B){
        al.add(B);
    }
    public Bebida getBebida(){
        if (al.size()==0) {
            return null;
        }else{
            return al.remove(0);
        }
    }
    public int getStorage(){
        return al.size();
    }
    public void setXY(){
        x = al.get(0).getx()-10;
        y = al.get(0).gety()-10;
    }
    public void paint(Graphics g){
        Polygon p = new Polygon();
        this.setXY();
        
        p.addPoint(x,y);
        p.addPoint(x+60, y);
        p.addPoint(x+60, y+100);
        p.addPoint(x, y+100);
        
        g.setColor(Color.white);
        g.fillPolygon(p);
        if(p!=null)g.drawPolygon(p);
        
        if(!al.isEmpty()){
            al.get(0).paint(g);
        }
    }
}
