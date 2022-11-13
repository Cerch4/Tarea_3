package tarea3;
import javax.swing.JPanel;
public abstract class Bebida extends JPanel{
    private int numSerie;
    private int x;
    private int y;
    private int escala;
    public Bebida(int numSerie, int x, int y, int escala){   
        this.numSerie = numSerie;
        this.x = x;
        this.y = y;
        this.escala = escala;
    }
    public int getSerie(){
        return numSerie;
    }
    public void changeLocation(int x,int y){
        this.x = x;
        this.y = y;
    }
    public int getx(){return x;}
    public int gety(){return y;}
    public int getescala(){return escala;}
    public abstract String beber();
}
