package tarea3;
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
        ImageIcon imagen = new ImageIcon(getClass().getResource("MaquinaExpendedoraPrototipo2.png"));
        g.drawImage(imagen.getImage(), x, y, 12*escala/8, 20*escala/8, this);
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
}
