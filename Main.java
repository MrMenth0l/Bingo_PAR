import java.text.DecimalFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);while (true)
        {System.out.println("BIENVENIDO AL BINGO PAR-DE-CUATES"
                    + "\nIngresar: "+ "\n1. Si"+ "\n2. NO");
            int opc = sc.nextInt();
            switch (opc){
                case 1:

                    System.out.println("Ingrese su nombre");
                    DecimalFormat df = new DecimalFormat("#.00");
                    Usuario jugador = new Usuario(sc.next(), 48);
                    boolean x = true;
                    while (x) {
                        System.out.println("Bienvenido " + jugador.getNombre() + " Tiene un saldo de " + df.format(jugador.getSaldo()) + "Q (Quetzales) " + df.format(jugador.getSaldodlr()) + "$ (Dolares, cambio de 8Q:1$)");
                        System.out.println("Que desea hacer" + "\n1. Jugar" + "\n2. Agregar a su saldo" + "\n3. Salir");
                        int a = sc.nextInt();
                        switch (a) {
                            case 1:
                                Bingo juego = new Bingo(jugador);
                                juego.jugar();
                                if (juego.isValid() & juego.isWinner()) {
                                    System.out.println("Sus numeros son" + "\n" + juego.getNum1() + "\n" + juego.getNum2() + "\n" + juego.getNum3());
                                    if (jugador.isDebe()){jugador.setSaldo(jugador.getSaldo()-48); jugador.setDebe(false);}
                                    System.out.println("Ha ganado: " + df.format(juego.getGanacias()) + "Q\n Su saldo se encuentra en: " + df.format(jugador.getSaldo()) + "Q (Quetzales) " + df.format(jugador.getSaldodlr()) + "$ (Dolares, cambio de 8Q:1$)");
                                } else if (juego.isValid()) {
                                    System.out.println("Gracias por su participacion");
                                } else System.out.println("No tiene fondos suficientes");
                                break;
                            case 2:
                                System.out.println("Cuanto desea ingresar?");
                                jugador.setSaldo(jugador.getSaldo()+ sc.nextInt());
                                break;
                            case 3:
                                x = false;
                                break;
                            default:
                                System.out.println("Ingrese una opcion valida");
                                break;
                        }
                    }
                case 2:
                    return;
                default:
                    System.out.println("Ingrese 1 o 2 como opcion para seguir.");
            }
        }
    }
}
