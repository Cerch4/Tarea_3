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

    public Comprador(Expendedor exp, int escala){
        vuelto = new depositoMoneda();
        bebida = new NoBebida(0,0,0,0);Bcomparacion = new NoBebida(0,0,0,0);
        this.escala = escala;
        this.exp = exp;
    }
    public Moneda getMonedabyValor(Moneda m) throws NohayMonedaException{
        if (m.getValor() == 1000) {
            if (exp.getcountm1000()==0) {
                throw new NohayMonedaException("No Posee monedas de 1000");
            }else{
                exp.setcountm1000(exp.getcountm1000()-1);
            }
        }else{
            if (m.getValor() == 500) {
                if (exp.getcountm500()==0) {
                    throw new NohayMonedaException("No Posee monedas de 500");
                }else{
                    exp.setcountm500(exp.getcountm500()-1);
                }
            }else{
                if (m.getValor()==100) {
                    if (exp.getcountm100()==0) {
                        throw new NohayMonedaException("No Posee monedas de 100");
                    }else{
                        exp.setcountm100(exp.getcountm100()-1);
                    }
                }
            }
        }
        for (int i = 0; i < vuelto.check(); i++) {
            if (vuelto.getMonedain(i).getClass().getName().equals(m.getClass().getName())) {
                return vuelto.takeMonedain(i);
            }
        }
        throw new NohayMonedaException("No encontro monedas");
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
        if (!bebida.getClass().getName().equals(Bcomparacion.getClass().getName())) {
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
        if (bebida.getClass().getName() != Bcomparacion.getClass().getName()) {
            bebida.changeLocation(111*escala/32, 3*escala/8);
            bebida.paint(g);
        }
    }
}
