package tarea3;
public abstract class Bebida {
    private int numSerie;
    public Bebida(int numSerie){
        this.numSerie = numSerie;
    }
    public int getSerie(){
        return numSerie;
    }
    public abstract String beber(); 
}
