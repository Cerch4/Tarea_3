package tarea3;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class Expendedor extends JPanel{
    private depositoMoneda DVuelto;
    private depositoMoneda DIngreso;
    private int money;
    private int precio;
    private DepositoBebida cocacola;
    private DepositoBebida sprite;
    private DepositoBebida fanta;
    int x;
    int y;
    int escala;
    public Expendedor(int nbebidas, int precio, int x, int y, int escala){
        super();
        money = 0;
        DVuelto = new depositoMoneda();
        DIngreso = new depositoMoneda();
        cocacola = new DepositoBebida();
        sprite = new DepositoBebida();
        fanta = new DepositoBebida();
        this.x = x;
        this.y = y;
        this.escala = escala;
        setBounds(0, 0, 4*escala, 3*escala);
        this.precio = precio;
        for (int i = 0; i < nbebidas; i++) {
            CocaCola auxC = new CocaCola (i, 0, 0, escala);
            cocacola.addBebida(auxC);
            Sprite auxS = new Sprite (nbebidas+i, 0, 0, escala);
            sprite.addBebida(auxS);
            Fanta auxF = new Fanta ((nbebidas*2)+i, 0, 0, escala);
            fanta.addBebida(auxF);
        }
    }    
    @Override
    public void paint(Graphics g){
        paintexpendedor(g);
        for (int i = 0; i < 5; i++) {
            Bebida b;
            b = cocacola.getBebidain(i);
            b.changeLocation(x + 3*escala/16 + (i*(3*escala/16)), y + 3*escala/16);
            b.paint(g);
            b = sprite.getBebidain(i);
            b.changeLocation(x + 3*escala/16 + (i*(3*escala/16)), y + (3*escala/16) + escala/4);
            b.paint(g);
            b = fanta.getBebidain(i);
            b.changeLocation(x + 3*escala/16 + (i*(3*escala/16)), y + (3*escala/16) + escala/2);
            b.paint(g);
        }
    }
    public Bebida comprarBebida(int n) throws NoHayBebidaException, PagoIncorrectoException, PagoInsuficienteException{
        if (money<precio) {
            throw new PagoInsuficienteException("El Monto de Pago no es suficiente para realizar la transaccion");
        }
        money = money-precio;
        while(money > precio){
            if (money-1000>=precio) {
                DVuelto.addMoneda(new Moneda1000());
            }else{
                if (money-500>=precio) {
                    DVuelto.addMoneda(new Moneda500());
                }else{
                    if (money-100>=precio) {
                        DVuelto.addMoneda(new Moneda100());
                    }
                }
            }
        }
        Bebida out = null;
        switch(n){
            case 1: 
                out = cocacola.getBebida();
                if (out == null) {
                    throw new NoHayBebidaException("Actualmente no hay mas Cocacola, lo sentimos");
                }
                money = money - precio;
                while(money>0){
                    DVuelto.addMoneda(new Moneda100());
                    money = money - 100;
                }
                break;
            case 2: 
                out = sprite.getBebida();
                if (out == null) {
                    throw new NoHayBebidaException("Actualmente no hay mas Sprite, lo sentimos");
                }
                money = money - precio;
                while(money>0){
                    DVuelto.addMoneda(new Moneda100());
                    money = money - 100;
                }
                break;
            case 3: 
                out = fanta.getBebida();
                if (out == null) {
                    throw new NoHayBebidaException("Actualmente no hay mas Fanta, lo sentimos");
                }
                money = money - precio;
                while(money>0){
                    DVuelto.addMoneda(new Moneda100());
                    money = money - 100;
                }
                break;
            default:
                if (n!=1&&n!=2&&n!=3) {
                    throw new NoHayBebidaException("El numero ingresado no posee una bebida asociada");
                }
        }
        return out;
    }
    public Moneda getVuelto(){
        if (DVuelto.check()>0) {
            return DVuelto.getMoneda();
        }else{
            return null;
        }
    }
    public int getPrice(){
        return precio;
    }
    public void IngresaMoneda(Moneda m) throws PagoIncorrectoException{        
        if (m == null) {
            throw new PagoIncorrectoException("Pago no valido");
        }
        DIngreso.addMoneda(m);
        money = 0;
        for (int i = 0; i < DIngreso.check(); i++) {
            money = money + DIngreso.getMonedain(i).getValor(); 
        }
    }
    public void paintexpendedor(Graphics g){
        g.setColor(Color.DARK_GRAY);
        g.fillRoundRect(escala/8,escala/8,12*escala/8, 20*escala/8,40,40);        
        
        g.setColor(Color.red);
        g.fillRoundRect(escala/8, 27*escala/16, 12*escala/8, 15*escala/16,40,40);
        
        g.setColor(Color.black);
        g.fillRoundRect(7*escala/32, 2*escala/8, 35*escala/32, 5*escala/4,60,60);
        
        g.setColor(Color.LIGHT_GRAY);
        g.fillRoundRect(3*escala/8, 17*escala/8, escala, escala/4,35,35);
        g.fillRoundRect(5*escala/4, 7*escala/4, 3*escala/16, 3*escala/16,20,20);
        
        g.setColor(Color.black);
        g.drawRoundRect(3*escala/8, 17*escala/8, escala, escala/4,35,35);
        g.fillRect(7*escala/16, 37*escala/16, 7*escala/8, escala/80);
        
        g.drawRoundRect(5*escala/4, 7*escala/4, 3*escala/16, 3*escala/16,20,20);
        g.fillRect(21*escala/16, (15*escala/8)+((15*escala/8-7*escala/4)/4), escala/16, escala/80);
        
    }
}
