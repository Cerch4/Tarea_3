package tarea3;
import java.awt.Graphics;
import javax.swing.ImageIcon;
public class Sprite extends Bebida{
    public Sprite(int numSerie, int x, int y, int escala){
        super(numSerie, x, y, escala);
    }
    @Override
    public String beber(){
        return "Sprite";
    }
    @Override
    public void paint(Graphics g){
        ImageIcon imagen = new ImageIcon(getClass().getResource("Sprite.png"));
        g.drawImage(imagen.getImage(), getx(), gety(), 3*getescala()/16, getescala()/4, this);
    }
}
