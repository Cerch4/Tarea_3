/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea3;

/**
 *
 * @author Cesar
 */
public abstract class Moneda {
    public Moneda(){   
    }
    public String getSerie(){
        int pos = 0;
        for (int i = this.toString().length()-1; i >= 0; i--) {
            if (this.toString().charAt(i)=='@') {
                pos = i;
                break;
            }
        }
        return(this.toString().substring(pos));
    }
    public abstract int getValor();
}