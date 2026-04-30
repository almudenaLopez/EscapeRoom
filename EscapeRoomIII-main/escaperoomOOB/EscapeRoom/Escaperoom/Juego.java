package Escaperoom;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Juego {

    private Map<String, PruebaAbstracta> habitaciones;
    private Scanner entrada;
    private Jugador jugador;

    public Juego() {
        entrada = new Scanner(System.in);
        jugador = new Jugador();
        crearHabitaciones();
    }

    private void crearHabitaciones() {
        habitaciones = new HashMap<>();
        // Creo las habitaciones en el mapa
        habitaciones.put("calabozo", new Calabozo(entrada));
        habitaciones.put("pasillo", new Pasillo(entrada));
        habitaciones.put("escaleras", new Escaleras(entrada));
        habitaciones.put("puerta", new Puerta(entrada));
        habitaciones.put("proa", new Proa(entrada));
    }

    public void iniciar() {
        String opcion = "";
        System.out.println("--- ESCAPE ROOM ---");
        System.out.print("Hola pirata, ¿cómo te llamas?: ");
        String nombrePirata = entrada.nextLine();

        System.out.println("Bienvenido a la Perla Negra "+nombrePirata+" tienes que salir de aquí antes de que llegue el Kraken.");
        System.out.println("¡Date prisa!");

        while (!opcion.equals("salir")) {
            System.out.println("--- --- --- ---");
            System.out.println("Tienes todavia: " + jugador.getVidas());
            for (String nombre : habitaciones.keySet()) {
                System.out.println("- " + nombre);
            }

            System.out.println("Escribe 'salir' para terminar");
            System.out.print("¿A dónde quieres ir?: ");

            // nextLine() para limpiar el buffer
            opcion = entrada.nextLine().toLowerCase();

            if (!opcion.equals("salir")) {
                try {
                    PruebaAbstracta pa = habitaciones.get(opcion);

                    if (pa == null) {
                        //  excepción
                        throw new OpcionInvalidaException("La opcion" + opcion + " no es válida");
                    }


                    boolean acierta = pa .resolver(jugador);

                    if (acierta) {
                        System.out.println("¡Perfecto pirata has pasado la habitacion " + opcion + "!");
                    } else {
                        System.out.println("Oh no pirata como es posible?");
                    }

                    // Comprobación de estado de juego
                    if (jugador.getVidas() <= 0) {
                        System.out.println("Te has quedado sin vidas Pirata, ya no podras salir de la Perla Negra");
                        break;
                    }

                } catch (OpcionInvalidaException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Error inesperado: " + e.getMessage());
                }
            }
        }
        System.out.println("Juego terminado");
    }
}