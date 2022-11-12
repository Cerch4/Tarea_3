package tarea3; //Ventana Segun lo Visto en Clases
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ventana extends JFrame{

    public Ventana(){
         super();
         this.setTitle("Maquina Expendedora");
         this.setLayout(new BorderLayout());;
         this.add(new JButton("norte"),BorderLayout.NORTH);
         this.add(new JButton("este"),BorderLayout.EAST);
         this.add(new JButton("oeste"),BorderLayout.WEST);
         this.add(new Panel_intento( ),BorderLayout.CENTER);
         this.setDefaultCloseOperation(EXIT_ON_CLOSE);
         this.setSize(980,720);
         this.setVisible(true); 
    } 
}
