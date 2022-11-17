package tarea3; //Ventana Segun lo Visto en Clases
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ventana extends JFrame{
    PanelPrincipal PP;
    JButton JBPanelN1,JBPanelN2,JBPanelN3,JBPanelN0, moneda100, moneda500, moneda1000, getvuelto, getbebida;
    int escala, numpad = 0;
    Moneda m;
    Expendedor exp;
    Comprador com;
    public Ventana(){
        super(); // 32x24 x/8*escala y/8*escala
        escala = 160; 
        PP = new PanelPrincipal(escala);
        exp = PP.getexp();
        com = PP.getcom();
        m = null;
        setSize(4*escala, 3*escala); //tamaño fijo de 4:3
        setTitle("Maquina Expendedora");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        this.setResizable(false);
        crearGUI();
        add(PP);
        setVisible(true); 
    } 
    public void crearGUI(){
        ImageIcon imagen = new ImageIcon(getClass().getResource("BotonNuevoC.png"));
        JBPanelN1 = new JButton(new ImageIcon(imagen.getImage().getScaledInstance(3*escala/16, escala/16, Image.SCALE_SMOOTH)));JBPanelN1.setBounds(11*escala/8, 5*escala/8, 3*escala/16, escala/16);
        imagen = new ImageIcon(getClass().getResource("BotonNuevoS.png"));
        JBPanelN2 = new JButton(new ImageIcon(imagen.getImage().getScaledInstance(3*escala/16, escala/16, Image.SCALE_SMOOTH)));JBPanelN2.setBounds(11*escala/8, 11*escala/16, 3*escala/16, escala/16);
        imagen = new ImageIcon(getClass().getResource("BotonNuevoF.png"));
        JBPanelN3 = new JButton(new ImageIcon(imagen.getImage().getScaledInstance(3*escala/16, escala/16, Image.SCALE_SMOOTH)));JBPanelN3.setBounds(11*escala/8, 6*escala/8, 3*escala/16, escala/16);
        imagen = new ImageIcon(getClass().getResource("BotonNuevoE.png"));
        JBPanelN0 = new JButton(new ImageIcon(imagen.getImage().getScaledInstance(3*escala/16, escala/16, Image.SCALE_SMOOTH)));JBPanelN0.setBounds(11*escala/8, 13*escala/16, 3*escala/16, escala/16);
        imagen = new ImageIcon(getClass().getResource("Moneda100.png"));
        moneda100 = new JButton(new ImageIcon(imagen.getImage().getScaledInstance(escala/4, escala/4, Image.SCALE_SMOOTH)));moneda100.setBounds(2*escala,  escala/4, escala/4, escala/4);
        moneda100.setBorderPainted(false);
        moneda100.setContentAreaFilled(false);
        imagen = new ImageIcon(getClass().getResource("Moneda500.png"));
        moneda500 = new JButton(new ImageIcon(imagen.getImage().getScaledInstance(escala/4, escala/4, Image.SCALE_SMOOTH)));moneda500.setBounds(9*escala/4,  escala/4, escala/4, escala/4);
        moneda500.setBorderPainted(false);
        moneda500.setContentAreaFilled(false);
        imagen = new ImageIcon(getClass().getResource("Moneda1000.png"));
        moneda1000 = new JButton(new ImageIcon(imagen.getImage().getScaledInstance(escala/4, escala/4, Image.SCALE_SMOOTH)));moneda1000.setBounds(5*escala/2,  escala/4, escala/4, escala/4);
        moneda1000.setBorderPainted(false);
        moneda1000.setContentAreaFilled(false);
        getvuelto = new JButton();getvuelto.setBounds(5*escala/4, 7*escala/4, 3*escala/16, 3*escala/16);
        getbebida = new JButton();getbebida.setBounds(3*escala/8, 17*escala/8, escala, escala/4);
        getbebida.setBorderPainted(false);
        getbebida.setContentAreaFilled(false);
        evento_numpad(JBPanelN1);evento_numpad(JBPanelN2);evento_numpad(JBPanelN3);evento_numpad(JBPanelN0);
        evento_moneda(moneda100);evento_moneda(moneda500);evento_moneda(moneda1000);evento_takeBebida(getbebida);
        add(JBPanelN1);add(JBPanelN2);add(JBPanelN3);add(JBPanelN0);add(moneda100);add(moneda500);add(moneda1000);
        add(getbebida);
    }
    public void evento_takeBebida(JButton act){
        act.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                com.getBebida().changeLocation(27*escala/8, escala/4);
                add(com.getBebida().getJButton());
            }
        });
    }
    public void evento_moneda(JButton act){
        act.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (act.getBounds().x == 2*escala) {
                    try {
                        exp.IngresaMoneda(new Moneda100());
                    } catch (PagoIncorrectoException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }else{
                    if(act.getBounds().x == 9*escala/4){
                        try {
                            exp.IngresaMoneda(new Moneda500());
                        } catch (PagoIncorrectoException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                    }else{
                        try {
                            exp.IngresaMoneda(new Moneda1000());
                        } catch (PagoIncorrectoException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                    }
                }
            }
        });
    }
    public void evento_numpad(JButton act){
        act.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (act.getBounds().y == 13*escala/16) {
                    try {
                        com.comprarBebida(m, numpad);
                    } catch (NoHayBebidaException ex) { // revisar
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    } catch (PagoIncorrectoException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    } catch (PagoInsuficienteException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                    repaint();
                }else{
                    if (act.getBounds().y == 5*escala/8) {
                        numpad = 1;
                    }else{
                        if (act.getBounds().y == 11*escala/16) {
                            numpad = 2;
                        }else{
                            if (act.getBounds().y == 6*escala/8) {
                                numpad =3;
                            }
                        }
                    }
                }
            }
        });
    }       
}
