package tarea3;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Expendedor extends JPanel{
    private depositoMoneda DVuelto;
    private depositoMoneda DIngreso;
    private int money;
    private boolean calcVuelto;
    private int precio;
    private DepositoBebida cocacola;
    private DepositoBebida sprite;
    private DepositoBebida fanta;
    private Bebida bebidaComprada, Bcomparacion;
    private int escala;
    private int countserie;
    private int countm100, countm500, countm1000;
    public Expendedor(int nbebidas, int precio, int x, int y, int escala){
        super();
        countserie=nbebidas*3;
        calcVuelto = false;
        countm100 = 0;countm500 = 0;countm1000 = 0;money = 0;
        bebidaComprada = new NoBebida(0,0,0,0);Bcomparacion = new NoBebida(0,0,0,0);
        DVuelto = new depositoMoneda();
        DIngreso = new depositoMoneda();
        cocacola = new DepositoBebida(x,y,escala);
        sprite = new DepositoBebida(x,y + 4*escala/12,escala);
        fanta = new DepositoBebida(x,y + 4*escala/6,escala);
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
        if(bebidaComprada.getClass().getName() != Bcomparacion.getClass().getName()){//
            bebidaComprada.changeLocation(25*escala/32, 17*escala/8);
            bebidaComprada.paint(g);
        }
        cocacola.paint(g);
        sprite.paint(g);
        fanta.paint(g);
        
    }
    public void refill(int n){
        if (n == 1) {
            for (int i = countserie; i < countserie+10; i++) {
                CocaCola auxC = new CocaCola (i, 0, 0, escala);
                cocacola.addBebida(auxC);
            }
            countserie = countserie + 10;
        }
        if (n == 2){
            for (int i = countserie; i < countserie+10; i++) {
                Sprite auxS = new Sprite (countserie, 0, 0, escala);
                sprite.addBebida(auxS);
            }
            countserie = countserie + 10;
        }
        if (n == 3){
            for (int i = countserie; i < countserie+10; i++) {
                Fanta auxF = new Fanta (countserie, 0, 0, escala);
                fanta.addBebida(auxF);
            }
            countserie = countserie + 10;
        }
    }
    public int getcountm100(){return countm100;}
    public int getcountm500(){return countm500;}
    public int getcountm1000(){return countm1000;}
    public void setcountm100(int c){countm100 = c;}
    public void setcountm500(int c){countm500 = c;}
    public void setcountm1000(int c){countm1000 = c;}
    public void comprarBebida(int n) throws NoHayBebidaException, PagoIncorrectoException, PagoInsuficienteException, YaComproException{
        if (money<precio) {
            throw new PagoInsuficienteException("El Monto de Pago no es suficiente para realizar la transaccion");
        }
        if(bebidaComprada.getClass().getName() != Bcomparacion.getClass().getName()){
             throw new YaComproException("Ya hay una bebida almacenada, Extraigala para proceder con otra compra");
        }
        switch(n){
            case 1: 
                bebidaComprada = cocacola.getBebida();
                if (bebidaComprada.getClass().getName() == Bcomparacion.getClass().getName()) {
                    throw new NoHayBebidaException("Actualmente no hay mas Cocacola, lo sentimos");
                }
                money = money - precio;
                break;
            case 2: 
                bebidaComprada = sprite.getBebida();
                if (bebidaComprada.getClass().getName() == Bcomparacion.getClass().getName()) {
                    throw new NoHayBebidaException("Actualmente no hay mas Sprite, lo sentimos");
                }
                money = money - precio;
                break;
            case 3: 
                bebidaComprada = fanta.getBebida();
                if (bebidaComprada.getClass().getName() == Bcomparacion.getClass().getName()) {
                    throw new NoHayBebidaException("Actualmente no hay mas Fanta, lo sentimos");
                }
                money = money - precio;
                break;
            default:
                if (n!=1&&n!=2&&n!=3) {
                    throw new NoHayBebidaException("No se a ingresado una seleccion de Bebida");
                }
        }
    }
    public Moneda getVuelto(){
        if (!calcVuelto) {
            while(money > 0){
                if (money-1000>=0) {
                    DVuelto.addMoneda(new Moneda1000());
                    money = money - 1000;
                }else{
                    if (money-500>=0) {
                        DVuelto.addMoneda(new Moneda500());
                        money = money - 500;
                    }else{
                        if (money-100>=0) {
                            DVuelto.addMoneda(new Moneda100());
                             money = money - 100;
                        }
                    }
                }
            }
            calcVuelto = true;
        }
        if (DVuelto.check()>0) {
            if (DVuelto.getMonedain(0).getValor()==100){countm100 = countm100+1;}
            else if (DVuelto.getMonedain(0).getValor()==500){countm500 = countm500+1;}
            else if (DVuelto.getMonedain(0).getValor()==1000){countm1000 = countm1000+1;}
            return DVuelto.getMoneda();
        }else{
            calcVuelto = false;
            return null;
        }
    }
    public Bebida getBebida() throws NoHayBebidaException{
        if(bebidaComprada.getClass().getName() == Bcomparacion.getClass().getName()){
            throw new NoHayBebidaException("No hay Bebida Para Extraer de la maquina");
        }else{
            Bebida aux = bebidaComprada;
            bebidaComprada = new NoBebida(0,0,0,0);
            return aux;   
        }
    }
    public int getPrice(){
        return precio;
    }
    public void IngresaMoneda(Moneda m) throws PagoIncorrectoException{        
        if (m == null) {
            throw new PagoIncorrectoException("Pago no valido");
        }
        if (m.getValor() == 100){
                money = money + 100; 
                DIngreso.addMoneda(m);
            }
        else if (m.getValor() == 500){
                money = money + 500; 
                DIngreso.addMoneda(m);
            }
        else if (m.getValor() == 1000){
                money = money + 1000;
                DIngreso.addMoneda(m);
        }
    }
   
    public void paintexpendedor(Graphics g){
        
        g.setColor(Color.DARK_GRAY);
        g.fillRoundRect(escala/8,escala/8,12*escala/8, 20*escala/8,40,40);        
        
        g.setColor(Color.red);
        g.fillRoundRect(escala/8, 27*escala/16, 12*escala/8, 15*escala/16,40,40);
        
        g.setColor(Color.black);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 2*escala/16)); 
        
        g.fillRoundRect(7*escala/32, 2*escala/8, 35*escala/32, 5*escala/4,60,60);
   
        g.setColor(Color.LIGHT_GRAY);
        g.fillRoundRect(3*escala/8, 17*escala/8, escala, escala/4,35,35);
        g.fillRoundRect(5*escala/4, 7*escala/4, 3*escala/16, 3*escala/16,20,20);
        
        g.setColor(Color.GREEN);
        g.setFont(new Font("TimesRoman", Font.PLAIN, escala/16));
        g.drawString(Integer.toString(money), 11*escala/8, 9*escala/16);
        
        g.setColor(Color.black);
        g.drawRoundRect(3*escala/8, 17*escala/8, escala, escala/4,35,35);
        g.fillRect(7*escala/16, 37*escala/16, 7*escala/8, escala/80);
        
        g.drawRoundRect(5*escala/4, 7*escala/4, 3*escala/16, 3*escala/16,20,20);
        g.fillRect(21*escala/16, (15*escala/8)+((15*escala/8-7*escala/4)/4), escala/16, escala/80);
        
    }
}
