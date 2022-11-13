package tarea3;
import java.awt.Graphics;
import javax.swing.ImageIcon;
class Moneda1000 extends Moneda {
    public Moneda1000(){
        super();
    }
    @Override
    public int getValor() {
        return(1000);
    }
    public void paint(Graphics g){
        ImageIcon imagen = new ImageIcon(getClass().getResource("Moneda100.png"));
        g.drawImage(imagen.getImage(), getx(), gety(), 3*getescala()/16, getescala()/4, this);
    }
}
