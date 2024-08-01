import java.text.DecimalFormat;

public class Usuario
{
    private String Nombre;
    private double saldo;
    private double saldodlr;
    private boolean debe;

    public Usuario(String Nombre, float saldo){
        this.Nombre = Nombre;
        this.saldo = saldo;
        this.debe = true;
    }

    public void setNombre(String nombre) {Nombre = nombre;}
    public String getNombre() {return Nombre;}

    public void setSaldo(double saldo) {this.saldo = saldo;}
    public double getSaldo() {return saldo;}

    public void setDebe(boolean debe) {this.debe = debe;}
    public boolean isDebe() {return debe;}

    public double getSaldodlr() {return saldo/8;}

}