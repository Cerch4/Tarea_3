package tarea3;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
public class Comprador extends JPanel{
    private Expendedor exp;
    private depositoMoneda vuelto;
    private int valorvuelto = 0;
    private Bebida bebida, Bcomparacion;
    private String flavor;
    private int escala;
    private int queSabor;

    public Comprador(Expendedor exp, int escala){
        vuelto = new depositoMoneda();
        bebida = new NoBebida(0,0,0,0);Bcomparacion = new NoBebida(0,0,0,0);
        this.escala = escala;
        this.exp = exp;
        queSabor = 0;
    }
    
    public void comprarBebida(int Sabor) throws NoHayBebidaException, PagoIncorrectoException, PagoInsuficienteException, YaComproException{
        exp.comprarBebida(Sabor);
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
    public Bebida getBebida(){
        return bebida;
    }
    public void recojeBebida() throws NoHayBebidaException{
        bebida = exp.getBebida();
        flavor = bebida.beber();
    }
    public String queBebiste(){
        bebida = new NoBebida(0,0,0,0);
        return(flavor);
    }
    public boolean BebidaInCom(){
        if (bebida.getClass().getName() != Bcomparacion.getClass().getName()) {
            return true;
        }else{
            return false;
        }
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
        if (bebida.getClass().getName() != Bcomparacion.getClass().getName()) {
            bebida.changeLocation(111*escala/32, 3*escala/8);
            bebida.paint(g);
        }
    }
}
