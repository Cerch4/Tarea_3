package tarea3;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
public class Comprador extends JPanel{
    private Expendedor exp;
    private depositoMoneda vuelto;
    private int valorvuelto = 0;
    private Bebida bebida;
    private String flavor;
    private int escala;
    public Comprador(Expendedor exp, int escala){
        vuelto = new depositoMoneda();
        bebida = null;
        this.escala = escala;
        this.exp = exp;
    }
    public void comprarBebida(Moneda money, int sabor) throws NoHayBebidaException, PagoIncorrectoException, PagoInsuficienteException{
        this.bebida = exp.comprarBebida(money, sabor);
        repaint();
    }
    public void getVuelto(){
        while(true){
            Moneda m = exp.getVuelto();
            if (m == null) {
                break;
            }
            vuelto.addMoneda(m);
        }
        for (int i = 0; i < vuelto.check(); i++) {
            Moneda m = vuelto.getMoneda();
            valorvuelto = valorvuelto + m.getValor();
            vuelto.addMoneda(m);
        }
    }
    public int cuantoVuelto(){
        return(valorvuelto);
    }
    public String queBebiste(){
        return(flavor);
    }
    @Override
    public void paint(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        g.fillRoundRect(27*escala/8, escala/4, 3*escala/8, escala/2, 3*escala/16, 3*escala/16);
        g.fillRoundRect(3*escala, 7*escala/8, 3*escala/4, 3*escala/2, 3*escala/16, 3*escala/16);
        if(vuelto.check()!=0){
            Moneda m = new Moneda100();
            m.ChangeLocationScale(25*escala/8, escala, escala);
            m.paint(g);
        }
        if (bebida!=null) {
            bebida.paint(g);
        }
    }
}
