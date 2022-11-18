package tarea3;
import java.util.ArrayList;
public class DepositoBebida {
    private ArrayList<Bebida> al;
    public DepositoBebida(){
        al = new ArrayList<Bebida>();
    }
    public void addBebida(Bebida B){
        al.add(B);
    }
    public Bebida getBebida(){
        if (al.size()==0) {
            return new NoBebida(-1,0,0,0);
        }else{
            return al.remove(0);
        }
    }
    public Bebida getBebidain(int n){
        if (n>=al.size()) {
            return new NoBebida(0,0,0,0);
        }else{
            return al.get(n);
        }
    }
    public int getStorage(){
        return al.size();
    }
}
