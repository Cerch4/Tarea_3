package tarea3; //Ventana Segun lo Visto en Clases
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame{
    PanelPrincipal PP;
    public Ventana(){
        super();
        int escala = 160; // debe ser divisible por 8 
        PP = new PanelPrincipal(escala);
        setSize(4*escala, 3*escala); //tamaño fijo de 4:3
        setTitle("Maquina Expendedora");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        this.setResizable(false);
        add(PP);
        setVisible(true); 
    } 
}
