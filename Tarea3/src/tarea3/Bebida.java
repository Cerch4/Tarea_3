package tarea3;

import java.awt.Graphics;

public abstract class Bebida {
    private int numSerie;
    public Bebida(int numSerie){   
        this.numSerie = numSerie;
    }
    public int getSerie(){
        return numSerie;
    }
    public abstract String beber(); 
    public abstract void paint(Graphics g);
    public abstract int getx();
    public abstract int gety(); 
}
