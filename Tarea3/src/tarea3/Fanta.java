package tarea3;
import java.awt.Graphics;
import javax.swing.ImageIcon;
public class Fanta extends Bebida{
    public Fanta(int numSerie, int x, int y, int escala){
        super(numSerie, x, y, escala);
    }
    @Override
    public String beber(){
        return "Fanta";
    }
    @Override
    public void paint(Graphics g){
        ImageIcon imagen = new ImageIcon(getClass().getResource("Fanta.png"));
        g.drawImage(imagen.getImage(), getx(), gety(), 3*getescala()/16, getescala()/4, this);
    }
}
