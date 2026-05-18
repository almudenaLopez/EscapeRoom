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

        System.out.println("Bienvenido a la Perla Negra " + nombrePirata + " tienes que salir de aquí antes de que llegue el Kraken.");
        System.out.println("¡Date prisa!");

        while (!opcion.equals("salir")) {
            System.out.println("--- --- --- ---");
            System.out.println("Tienes todavia: " + jugador.getVidas());
            // STREAM
            habitaciones.keySet().stream()
                    .sorted()
                    .forEach(System.out::println);

            System.out.println("Comandos: habitación / volver / inventario / guardar / salir");
            opcion = entrada.nextLine().toLowerCase();

            try {

                if (opcion.equals("volver")) {

                    String anterior = jugador.volverAtras();

                    if (anterior != null) {
                        System.out.println("Vuelves a: " + anterior);
                    } else {
                        System.out.println("No hay historial");
                    }

                } else if (opcion.equals("inventario")) {

                    jugador.mostrarInventario();

                } else if (opcion.equals("guardar")) {

                    GuardarPartida.guardar(jugador);

                } else if (!opcion.equals("salir")) {

                    PruebaAbstracta pa = habitaciones.get(opcion);


                    if (pa == null) {
                        throw new OpcionInvalidaException("La opcion no es válida");
                    }

                    jugador.registrarMovimiento(opcion);

                    boolean acierta = pa.resolver(jugador);

                    if (!acierta) {
                        jugador.perderVida();
                    }

                    jugador.gastarTurnos();
                }

                if (jugador.getTurnos() <= 0) {
                    System.out.println("Te has quedado sin tiempo");
                    break;
                }

                if (jugador.getVidas() <= 0) {
                    System.out.println("Has perdido la partida");
                    break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Juego terminado");
    }
}