/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea3;

/**
 *
 * @author Cesar
 */
public class Comprador {
    private int vuelto = 0;
    private String flavor;
    public Comprador(Moneda money, int sabor, Expendedor exp) throws NoHayBebidaException, PagoIncorrectoException, PagoInsuficienteException{
        Bebida Bebida = exp.comprarBebida(money, sabor);
        while(true){
            Moneda m = exp.getVuelto();
            if (m == null) {
                break;
            }
            vuelto = vuelto + m.getValor();
        }
        flavor = Bebida.beber();
    }
    public int cuantoVuelto(){
        return(vuelto);
    }
    
    public String queBebiste(){
        return(flavor);
    }
}
