package Escaperoom;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

    public class Serializador {

        public static void guardarJugador(Jugador jugador) {

            try {

                ObjectOutputStream oos = new ObjectOutputStream(
                        new FileOutputStream("jugador.dat")
                );

                oos.writeObject(jugador);

                oos.close();

                System.out.println("Jugador serializado correctamente");

            } catch (IOException e) {
                System.out.println("Error al serializar");
            }
        }
    }

