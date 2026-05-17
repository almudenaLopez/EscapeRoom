package Escaperoom;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

    public class GuardarPartida {

        public static void guardar(Jugador jugador) {

            try {

                File archivo = new File("partida.txt");

                if (!archivo.exists()) {
                    archivo.createNewFile();
                }

                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));

                bw.write("Vidas: " + jugador.getVidas());
                bw.newLine();
                bw.write("Nivel: " + jugador.getNivel());
                bw.newLine();
                bw.write("Turnos: " + jugador.getTurnos());

                bw.close();

                System.out.println("Partida guardada");

            } catch (IOException e) {
                System.out.println("Error al guardar");
            }
        }
    }

