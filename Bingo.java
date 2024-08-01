import java.util.Random;

public class Bingo {
    Random rand = new Random();
    private int num1;
    private int num2;
    private int num3;
    private int Costo;
    private Usuario jugador;
    private double ganacias;
    private boolean wl;

    public Bingo(Usuario jugador){
        this.jugador = jugador;
        Gen_bingo();

    }
    public boolean isValid()
    {
        return (jugador.getSaldo()>12);
    }
    private void Gen_bingo(){
        if (isValid()) {
            num1 = rand.nextInt(100, 1001);
            num2 = rand.nextInt(100, 1001);
            num3 = rand.nextInt(100, 1001);
        }


    }
    private void resultados(int num1, int num2){
        if (num1>700 && num2>700){
            ganacias = ((num1+num2)*0.1);
        } else if (num1>500 && num1<700 && num2>500 && num2<700) {
            ganacias =  ((num1+num2)*0.2);
        } else if (num1 > 500 || num2 > 500){
            ganacias =  ((num1+num2)*0.15);
        } else if (num1<500 && num2<500) {
            ganacias =  ((num1+num2)*0.25);
        }else{ganacias = 0;}

    }
    public boolean isEven(int num){
        return (num % 2==0);
    }
    public void jugar()
    {
        jugador.setSaldo(jugador.getSaldo()-12);
        if(isEven(num1)&&isEven(num2)){resultados(num1,num2);jugador.setSaldo(jugador.getSaldo()+ganacias); setWinner(true);}
        else if (isEven(num1)&&isEven(num3)){resultados(num1,num3);jugador.setSaldo(jugador.getSaldo()+ganacias); setWinner(true);}
        else if (isEven(num2)&&isEven(num3)){resultados(num2,num3); jugador.setSaldo(jugador.getSaldo()+ganacias); setWinner(true);}
        else  setWinner(false);;

    }
    public void setWinner( boolean gano){this.wl = gano;}
    public boolean isWinner(){return wl;}
    public int getNum1() {return num1;}
    public int getNum2() {return num2;}
    public int getNum3() {return num3;}
    public double getGanacias(){return ganacias;}

    public void setCosto(int costo) {Costo = costo;}
    public int getCosto() {return Costo;}
}
