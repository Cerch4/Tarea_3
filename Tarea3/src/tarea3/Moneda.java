package tarea3;
import javax.swing.JPanel;
public abstract class Moneda extends JPanel{
    private int x;
    private int y;
    private int escala;
    public Moneda(){   
        x = 0;
        y = 0;
        escala = 0;
    }
    public String getSerie(){
        return(Integer.toHexString(this.hashCode()));
    }
    public void ChangeLocationScale(int x,int y, int escala){
        this.x = x;
        this.y = y;
        this.escala = escala;
    }
    public int getx(){return x;}
    public int gety(){return y;}
    public int getescala(){return escala;}
    public abstract int getValor();
}