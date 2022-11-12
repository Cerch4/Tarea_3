package tarea3;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class Sprite extends Bebida{
    public Sprite(int numSerie, JPanel Panel, int x, int y){
        super(numSerie, Panel, x, y);
        ImageIcon imagen = new ImageIcon("Sprite.png");
        super.getJlabel().setIcon(new ImageIcon(imagen.getImage().getScaledInstance(super.getJlabel().getWidth(),super.getJlabel().getHeight(),Image.SCALE_SMOOTH)));
        Panel.add(super.getJlabel());
    }
    @Override
    public String beber(){
        return "Sprite";
    }
}
