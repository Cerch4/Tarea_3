package tarea3;
public class Expendedor {
    private depositoMoneda DVuelto = new depositoMoneda();
    private int precio;
    private DepositoBebida cocacola = new DepositoBebida();
    private DepositoBebida sprite = new DepositoBebida();
    private DepositoBebida fanta = new DepositoBebida();
    private Bebida depositoEsp = null;
    private depositoMoneda Despecial = new depositoMoneda();
    private int  x;
    private int y;
    public Expendedor(){
        x = 300;
        y = 200;
        this.precio = 800;
        int nbebidas = 30;
        for (int i = 0; i < nbebidas; i++) {
            CocaCola auxC = new CocaCola (i);
            cocacola.addBebida(auxC);
            Sprite auxS = new Sprite (nbebidas+i);
            sprite.addBebida(auxS);
            Fanta auxF = new Fanta ((nbebidas*2)+i);
            fanta.addBebida(auxF);
        }
    }    
    public void comprarBebida(Moneda m, int n) throws NoHayBebidaException, PagoIncorrectoException, PagoInsuficienteException{
        int money = m.getValor();
        if (m == null) {
            throw new PagoIncorrectoException("Pago no valido");
        }
        if (m.getValor()<precio) {
            throw new PagoInsuficienteException("El Monto de Pago no es suficiente para realizar la transaccion");
        }
        
        switch(n){
            case 1: 
                depositoEsp = cocacola.getBebida();
                if (depositoEsp == null) {
                    throw new NoHayBebidaException("Actualmente no hay mas Cocacola, lo sentimos");
                }
                Despecial.addMoneda(m);
                money = money - precio;
                while(money>0){
                    DVuelto.addMoneda(new Moneda100());
                    money = money - 100;
                }
                break;
            case 2: 
                depositoEsp = sprite.getBebida();
                if (depositoEsp == null) {
                    throw new NoHayBebidaException("Actualmente no hay mas Sprite, lo sentimos");
                }
                Despecial.addMoneda(m);
                money = money - precio;
                while(money>0){
                    DVuelto.addMoneda(new Moneda100());
                    money = money - 100;
                }
                break;
            case 3: 
                depositoEsp = fanta.getBebida();
                if (out == null) {
                    throw new NoHayBebidaException("Actualmente no hay mas Fanta, lo sentimos");
                }
                Despecial.addMoneda(m);
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
    
    public Bebida getBebida(){
        Bebida aux = depositoEsp;
        depositoEsp = null;
        return aux;
    }
    
    
}
