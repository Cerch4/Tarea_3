/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea3;
import java.awt.*;
import javax.swing.JPanel;
public class Panel_intento extends JPanel {
    private Expendedor t;
  
    public Panel_intento(){
        this.setBackground(Color.white);
        t = new Expendedor();
     
    }
    
    public void paint(Graphics g){
        super.paint(g);
        if(t!=null)t.paint(g);
    }
}
