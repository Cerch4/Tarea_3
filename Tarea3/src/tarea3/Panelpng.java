/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea3;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
 *
 * @author Cesar
 */
public class Panelpng extends JPanel{

    private BufferedImage image;

    public Panelpng() {
       try {                
          image = ImageIO.read(new File("\\Users\\Cesar\\Desktop\\Universidad\\4to_Semestre\\Progra II\\vending.png"));
       } catch (IOException ex) {
            // handle exception...
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 100, 50, this); // see javadoc for more info on the parameters            
    }

}
