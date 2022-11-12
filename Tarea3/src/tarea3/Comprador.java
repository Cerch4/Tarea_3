package tarea3;
public class Comprador {
    private depositoMoneda vuelto;
    private int valorvuelto = 0;
    private Bebida bebida;
    private String flavor;
    public Comprador(Moneda money, int sabor, Expendedor exp) throws NoHayBebidaException, PagoIncorrectoException, PagoInsuficienteException{
        this.bebida = exp.comprarBebida(money, sabor);
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
}
