package tarea3;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class Expendedor extends JPanel{
    private depositoMoneda DVuelto = new depositoMoneda();
    private int precio;
    private DepositoBebida cocacola = new DepositoBebida();
    private DepositoBebida sprite = new DepositoBebida();
    private DepositoBebida fanta = new DepositoBebida();
    int x;
    int y;
    int escala;
    public Expendedor(int nbebidas, int precio, int x, int y, int escala){
        super();
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
        //ImageIcon imagen = new ImageIcon(getClass().getResource("MaquinaExpendedoraPrototipo2.png"));
        //g.drawImage(imagen.getImage(), x, y, 12*escala/8, 20*escala/8, this);
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
    public Bebida comprarBebida(Moneda m, int n) throws NoHayBebidaException, PagoIncorrectoException, PagoInsuficienteException{
        int money = m.getValor();
        if (m == null) {
            throw new PagoIncorrectoException("Pago no valido");
        }
        if (m.getValor()<precio) {
            throw new PagoInsuficienteException("El Monto de Pago no es suficiente para realizar la transaccion");
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
    
    public void paintexpendedor(Graphics g){
        g.setColor(Color.DARK_GRAY);
        g.fillRoundRect(x,y,12*escala/8, 20*escala/8,40,40);
        
        g.setColor(Color.black);
        g.fillRoundRect(x+15, y+20, 12*escala/8-65, 20*escala/8-250,60,60);
        
        g.setColor(Color.red);
        g.fillRoundRect(x, y+250,12*escala/8, 20*escala/8-250,40,40);
        
        g.setColor(Color.LIGHT_GRAY);
        g.fillRoundRect(x+40, y+325,12*escala/8-80, 20*escala/8-360,35,35);
        g.fillRoundRect(x+180, y+265,12*escala/8-205, 20*escala/8-365,65,65);
        
        g.setColor(Color.black);
        g.drawRoundRect(x+39, y+324,12*escala/8-79, 20*escala/8-359,35,35);
        g.fillRect(x+50, y+356,x+120, 3);
        
        g.drawRoundRect(x+179, y+264,12*escala/8-204, 20*escala/8-364,65,65);
        g.fillRect(x+187, y+290,x, 2);
        
        
    }
}
