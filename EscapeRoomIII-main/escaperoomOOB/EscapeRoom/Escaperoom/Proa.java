package Escaperoom;

public class Proa extends PruebaAbstracta {
 public Proa(java.util.Scanner entrada) {
        super(entrada);
    }

   @Override
    public boolean resolver(Jugador jugador) {
        System.out.println("Encuentra las 4 palabras ocultas.");
        System.out.println("No avanzarás a la siguiente hasta que aciertes la actual.");

        String[] enunciados = {
            "Animal que acompaña al pirata: ",
            "Monstruo marino del que huyes: ",
            "Dónde está el barco: ",
            "Apellido del pirata protagonista: "
        };
        String[] respuestasCorrectas = {"loro", "kraken", "mar", "sparrow"};

        for (int i = 0; i < enunciados.length; i++) {
            boolean palabraAcertada = false;

            // Este bucle se repite hasta que la palabra i sea correcta
            while (!palabraAcertada) {
                System.out.print(enunciados[i]);
                String intento = entrada.nextLine();

                if (intento.equalsIgnoreCase(respuestasCorrectas[i])) {
                    System.out.println("¡Correcto!");
                    palabraAcertada = true; // Sale del while y va a la siguiente palabra del for
                } else {
                    System.out.println("Incorrecto pirata Inténtalo de nuevo.");
                    perderVida(jugador);

                    // Si se queda sin vidas termina 
                    if (jugador.getVidas() <= 0) {
                        return false;
                    }
                }
            }
        }

        System.out.println("Has conseguido el timón.");
        System.out.println("¡Zarpa antes de que llegue el Kraken!");
        return true;
    }
}