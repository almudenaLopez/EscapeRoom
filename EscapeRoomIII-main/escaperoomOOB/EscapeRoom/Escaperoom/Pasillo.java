package Escaperoom;

public class Pasillo extends PruebaAbstracta {

    public Pasillo(java.util.Scanner entrada) {
        super(entrada);
    }

    @Override
    public boolean resolver(Jugador jugador) {

        System.out.print("¿Qué soy? (Con X señalo donde excavar): ");
        String respuesta = entrada.nextLine();

        if (respuesta.equalsIgnoreCase("mapa")) {
            System.out.println("Correcto!");
            return true;
        }

        perderVida(jugador);
        return false;
    }
}
