package tarea3;
import javax.swing.JLabel;
import javax.swing.JPanel;
public abstract class Bebida {
    private int numSerie;
    private JLabel bebida;
    public Bebida(int numSerie, JPanel Panel, int x, int y){   
        this.numSerie = numSerie;
        bebida = new JLabel();
        bebida.setBounds(x, y, 40, 100);
    }
    public int getSerie(){
        return numSerie;
    }
    public JLabel getJlabel(){
        return bebida;
    }
    public void setJlabel(JLabel bebida){
        this.bebida = bebida;
    }
    public abstract String beber();
}
