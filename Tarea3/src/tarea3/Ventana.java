package tarea3; //Ventana Segun lo Visto en Clases
import java.awt.BorderLayout;
import javax.swing.JFrame;
public class Ventana extends JFrame{
    public Ventana(){
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000,800);
        this.setVisible(true);
    }
}
