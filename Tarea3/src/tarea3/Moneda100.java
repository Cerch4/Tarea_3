package tarea3;
import java.awt.Graphics;
import javax.swing.ImageIcon;
class Moneda100 extends Moneda {
    public Moneda100(){
        super();
    }
    @Override
    public int getValor() {
        return(100);
    }
    public void paint(Graphics g){
        ImageIcon imagen = new ImageIcon(getClass().getResource("Moneda100.png"));
        g.drawImage(imagen.getImage(), getx(), gety(), getescala()/4, getescala()/4, this);
    }
}
