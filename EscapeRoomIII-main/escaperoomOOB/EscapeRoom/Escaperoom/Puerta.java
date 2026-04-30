package Escaperoom;

public class Puerta extends PruebaAbstracta{

public Puerta(java.util.Scanner entrada) {
        super(entrada);
    }
@Override
    public boolean resolver(Jugador jugador) {
        System.out.println("Necesitas recuperar tu espada.");
        System.out.println("Debes acertar estas 3 operaciones (no pasarás a la siguiente hasta que aciertes).");

        String[] preguntas = {
                "27 * 5 = ?",
                "14 + 14 * 3 = ?",
                "27 % 3 = ?"
        };
        int[] resultados = {135, 56, 0};

        // Recorremos las preguntas una a una
        for (int i = 0; i < preguntas.length; i++) {
            boolean acertada = false;

            // Este bucle se repite hasta que acierte la pregunta actual (i)
            while (!acertada) {
                System.out.print("Problema " + (i + 1) + ": " + preguntas[i] + " ");
                
                // Verificamos que sea un número 
                if (!entrada.hasNextInt()) {
                    System.out.println("¡Error! Introduce un número válido.");
                    entrada.next(); // Limpiar el error
                    continue;
                }

                int respuesta = entrada.nextInt();
                entrada.nextLine(); // Limpiar el buffer

                if (respuesta == resultados[i]) {
                    System.out.println("¡Correcto!");
                    acertada = true; // Permite salir del while y pasar a la siguiente i del for
                } else {
                    System.out.println("Incorrecto pirata Inténtalo de nuevo.");
                    perderVida(jugador);
                    
                    // Si se queda sin vidas, el juego termina
                    if (jugador.getVidas() <= 0) {
                        return false; 
                    }
                }
            }
        }

        System.out.println("¡Has acertado todas y recuperado la espada!");
        return true;
    }
}