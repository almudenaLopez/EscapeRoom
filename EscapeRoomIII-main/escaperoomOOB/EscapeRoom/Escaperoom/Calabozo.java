package Escaperoom;

   import java.util.Scanner;

public class Calabozo extends PruebaAbstracta {

    public Calabozo(Scanner entrada) {
        super(entrada);
    }

    @Override
    public boolean resolver(Jugador jugador) {
        int codigo = 3;
        int intentos = 3;

        while (intentos > 0) {
            System.out.print("Número secreto (5 4 _): ");
          
            int intento = entrada.nextInt();
            entrada.nextLine();

            if (intento == codigo) {
                jugador.añadirObjeto("llave_calabozo");
                System.out.println("Correcto! Has conseguido las llaves");
                return true;
            }
            intentos--;
        }

        perderVida(jugador);
        return false;
    }
}

