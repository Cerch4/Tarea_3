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
    private PanelPrincipal PP;
    private JButton JBPanelN1,JBPanelN2,JBPanelN3,JBPanelN0, moneda100, moneda500, moneda1000, getvuelto, getbebida, moneda100_2, moneda500_2, moneda1000_2, drinkBebida;
    private int escala, numpad = 0;
    private Expendedor exp;
    private Comprador com;
    public Ventana(){
        super(); // 32x24 x/8*escala y/8*escala
        escala = 160; 
        PP = new PanelPrincipal(escala);
        exp = PP.getexp();
        com = PP.getcom();
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
        moneda100_2 = new JButton(new ImageIcon(imagen.getImage().getScaledInstance(escala/4, escala/4, Image.SCALE_SMOOTH)));moneda100_2.setBounds(49*escala/16, 17*escala/16, escala/4, escala/4);
        moneda100_2.setBorderPainted(false);
        moneda100_2.setContentAreaFilled(false);
        imagen = new ImageIcon(getClass().getResource("Moneda500.png"));
        moneda500 = new JButton(new ImageIcon(imagen.getImage().getScaledInstance(escala/4, escala/4, Image.SCALE_SMOOTH)));moneda500.setBounds(9*escala/4,  escala/4, escala/4, escala/4);
        moneda500.setBorderPainted(false);
        moneda500.setContentAreaFilled(false);
        moneda500_2 = new JButton(new ImageIcon(imagen.getImage().getScaledInstance(escala/4, escala/4, Image.SCALE_SMOOTH)));moneda500_2.setBounds(49*escala/16, 23*escala/16, escala/4, escala/4);
        moneda500_2.setBorderPainted(false);
        moneda500_2.setContentAreaFilled(false);
        imagen = new ImageIcon(getClass().getResource("Moneda1000.png"));
        moneda1000 = new JButton(new ImageIcon(imagen.getImage().getScaledInstance(escala/4, escala/4, Image.SCALE_SMOOTH)));moneda1000.setBounds(5*escala/2,  escala/4, escala/4, escala/4);
        moneda1000.setBorderPainted(false);
        moneda1000.setContentAreaFilled(false);
        moneda1000_2 = new JButton(new ImageIcon(imagen.getImage().getScaledInstance(escala/4, escala/4, Image.SCALE_SMOOTH)));moneda1000_2.setBounds(49*escala/16, 29*escala/16, escala/4, escala/4);
        moneda1000_2.setBorderPainted(false);
        moneda1000_2.setContentAreaFilled(false);
        getvuelto = new JButton();getvuelto.setBounds(5*escala/4, 7*escala/4, 3*escala/16, 3*escala/16);
        getbebida = new JButton();getbebida.setBounds(3*escala/8, 17*escala/8, escala, escala/4);
        getbebida.setBorderPainted(false);
        getbebida.setContentAreaFilled(false);
        getbebida.setToolTipText("Click para extraer Bebida en Maquina");
        getvuelto= new JButton();getvuelto.setBounds(5*escala/4, 7*escala/4, 3*escala/16, 3*escala/16); 
        getvuelto.setBorderPainted(false);
        getvuelto.setContentAreaFilled(false);
        getvuelto.setToolTipText("Click para extraer Vuelto en Maquina");
        drinkBebida= new JButton();drinkBebida.setBounds(111*escala/32, 3*escala/8, 3*escala/16, escala/4);
        drinkBebida.setBorderPainted(false);
        drinkBebida.setContentAreaFilled(false);
        drinkBebida.setToolTipText("Beber Bebida");
        evento_numpad(JBPanelN1);evento_numpad(JBPanelN2);evento_numpad(JBPanelN3);evento_numpad(JBPanelN0);
        evento_moneda(moneda100);evento_moneda(moneda500);evento_moneda(moneda1000);evento_takeBebida(getbebida);
        evento_takeVuelto(getvuelto);evento_drinkBebida(drinkBebida);evento_moneda_2(moneda100_2);evento_moneda_2(moneda500_2);evento_moneda_2(moneda1000_2);
        add(JBPanelN1);add(JBPanelN2);add(JBPanelN3);add(JBPanelN0);add(moneda100);add(moneda500);add(moneda1000);
        add(getbebida);add(getvuelto);add(moneda100_2);add(moneda500_2);add(moneda1000_2);add(drinkBebida);
    }
    public void evento_moneda_2(JButton act){
        act.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (act.getBounds().y == 17*escala/16) {
                    try {
                        exp.IngresaMoneda(com.getMonedabyValor(new Moneda100()));
                    } catch (PagoIncorrectoException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    } catch (NohayMonedaException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }else{
                    if(act.getBounds().y == 23*escala/16){
                        try {
                            exp.IngresaMoneda(com.getMonedabyValor(new Moneda500()));
                        } catch (PagoIncorrectoException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        } catch (NohayMonedaException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                    }else{
                        try {
                            exp.IngresaMoneda(com.getMonedabyValor(new Moneda1000()));
                        } catch (PagoIncorrectoException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        } catch (NohayMonedaException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                    }
                }
                repaint();
            }
        });
    }
    public void evento_drinkBebida(JButton act){
        act.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (com.BebidaInCom()) {
                    JOptionPane.showMessageDialog(null, "Bebiste una " + com.queBebiste());
                }else{
                    JOptionPane.showMessageDialog(null, "Aun no se a recogido una Bebida");
                }
            }
        });
    }
    public void evento_takeVuelto(JButton act){ 
        act.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                com.getVuelto();
                repaint();
            }
        });
    }
    public void evento_takeBebida(JButton act){
        act.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (act.getBounds().x == 3*escala/8&&!com.BebidaInCom()){
                    try {
                        com.recojeBebida();
                    } catch (NoHayBebidaException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                    repaint();
                }
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
                repaint();
            }
        });
    }
    public void evento_numpad(JButton act){
        act.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (act.getBounds().y == 13*escala/16) {
                    try {
                        com.comprarBebida(numpad);
                        numpad = 0;
                    } catch (NoHayBebidaException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    } catch (PagoIncorrectoException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    } catch (PagoInsuficienteException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    } catch (YaComproException ex) {
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
