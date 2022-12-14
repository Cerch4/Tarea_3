package tarea3;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel{
    private Comprador com;
    private Expendedor exp;
    public PanelPrincipal(int escala){
        super();
        setBounds(0, 0, 4*escala, 3*escala);
        exp = new Expendedor(3, 400, escala/8 , escala/8, escala);
        com = new Comprador(exp, escala);
        setBackground(Color.white);
    }
    public void paint (Graphics g){
        super.paint(g);
        com.paint(g);
        exp.paint(g);
    }
    public Expendedor getexp(){
        return exp;
    }
    public Comprador getcom(){
        return com;
    }
}
