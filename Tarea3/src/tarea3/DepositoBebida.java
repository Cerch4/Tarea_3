package tarea3;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
public class DepositoBebida extends JPanel{
    private ArrayList<Bebida> al;
    int x;
    int y;
    int escala;
    public DepositoBebida(int posx, int posy, int tescale){
        al = new ArrayList<Bebida>();
        x = posx;
        y = posy;
        escala = tescale;
    }
    public void addBebida(Bebida B){
        al.add(B);
    }
    public Bebida getBebida(){
        if (al.size()==0) {
            return new NoBebida(-1,0,0,0);
        }else{
            return al.remove(0);
        }
    }
    public Bebida getBebidain(int n){
        if (n>=al.size()) {
            return new NoBebida(0,0,0,0);
        }else{
            return al.get(n);
        }
    }
    public int getStorage(){
        return al.size();
    }
    
    @Override
    public void paint(Graphics g){
        for (int i = 0; i < 5; i++) {
            Bebida b;
            b = this.getBebidain(i);
            b.changeLocation(x + 3*escala/16 + (i*(3*escala/16)), y + 3*escala/16);
            b.paint(g);
        }
    }
}
