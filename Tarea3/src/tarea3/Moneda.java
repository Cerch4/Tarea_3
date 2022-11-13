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
        int pos = 0;
        for (int i = this.toString().length()-1; i >= 0; i--) {
            if (this.toString().charAt(i)=='@') {
                pos = i;
                break;
            }
        }
        return(this.toString().substring(pos));
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