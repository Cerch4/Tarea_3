/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea3;

import java.util.ArrayList;

/**
 *
 * @author Cesar
 */
public class depositoMoneda {
    private ArrayList<Moneda> varl;

    public depositoMoneda(){
         varl = new ArrayList<Moneda>();
     }
    public void addMoneda(Moneda mon){
        varl.add(mon);
    }
    public Moneda getMoneda(){
        if(varl.isEmpty()){
            return null;
        }
        else{
            Moneda aux = null;
            aux = varl.remove(0);  
            return(aux);
        }
    }
    public Moneda takeMonedain(int n){        
        if(varl.isEmpty()){
            return null;
        }
        else{
            Moneda aux = null;
            aux = varl.remove(n);  
            return(aux);
        }
    }
    public Moneda getMonedain(int n){
        if (n>=varl.size()) {
            return null;
        }else{
            return varl.get(n);
        }
    }
    public int check(){
        return(varl.size());
    }
}

