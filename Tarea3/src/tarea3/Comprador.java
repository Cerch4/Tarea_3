package tarea3;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
public class Comprador extends JPanel{
    private Expendedor exp;
    private depositoMoneda vuelto;
    private int valorvuelto = 0;
    private Bebida bebida, Bcomparacion;
    private String flavor;
    private int escala;
    private int countm100, countm500, countm1000;

    public Comprador(Expendedor exp, int escala){
        countm100 = 0;countm500 = 0;countm1000 = 0;
        vuelto = new depositoMoneda();
        bebida = new NoBebida(0,0,0,0);Bcomparacion = new NoBebida(0,0,0,0);
        this.escala = escala;
        this.exp = exp;
    }
    public Moneda getMonedabyValor(Moneda m) throws NohayMonedaException{
        if (m.getValor() == 1000) {
            if (countm1000==0) {
                throw new NohayMonedaException("No Posee monedas de 1000");
            }else{
                countm1000 = countm1000-1;
            }
        }else{
            if (m.getValor() == 500) {
                if (countm500==0) {
                    throw new NohayMonedaException("No Posee monedas de 500");
                }else{
                    countm500 = countm500-1;
                }
            }else{
                if (m.getValor()==100) {
                    if (countm100==0) {
                        throw new NohayMonedaException("No Posee monedas de 100");
                    }else{
                        countm100 = countm100-1;
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
    public int getcountm100(){return countm100;}
    public int getcountm500(){return countm500;}
    public int getcountm1000(){return countm1000;}
    public Moneda getMonedaby(Moneda m){
        for (int i = 0; i < vuelto.check(); i++) {
            if (vuelto.getMonedain(i).getClass().getName().equals(m.getClass().getName())) {
                return vuelto.getMonedain(i);
            }
        }
        return m;
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
        countm100 = countm100 + exp.getcountm100();
        exp.setcountm100(0);
        countm500 = countm500 + exp.getcountm500();
        exp.setcountm500(0);
        countm1000 = countm1000 + exp.getcountm1000();
        exp.setcountm1000(0);
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
        g.setColor(Color.black);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 2*escala/16));
        g.drawString( "X" + Integer.toString(countm100), 27*escala/8, 10*escala/8);
        g.drawString( "X" + Integer.toString(countm500), 27*escala/8, 13*escala/8);
        g.drawString( "X" + Integer.toString(countm1000), 27*escala/8, 16*escala/8);
    }
}
