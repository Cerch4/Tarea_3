package tarea3;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
public class CocaCola extends Bebida{
    public CocaCola(int numSerie, int x, int y, int escala){
        super(numSerie, x, y, escala);
    }
    @Override
    public String beber(){
        return "CocaCola";
    }
    @Override
    public void paint(Graphics g){
        JButton jb;
        ImageIcon imagen = new ImageIcon(getClass().getResource("CocaCola.png"));
        g.drawImage(imagen.getImage(), getx(), gety(), 3*getescala()/16, getescala()/4, this);
        jb = new JButton(new ImageIcon(imagen.getImage().getScaledInstance(getescala()/4, getescala()/4, Image.SCALE_SMOOTH)));
        jb.setBounds(getx(),  gety(), 3*getescala()/16, getescala()/4);
        setJButton(jb);
    }
}
