package Escaperoom;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jugador {
private int vidas;
    private int nivel;
    private Deque<String> historial;

    public Jugador() {
        this.vidas = 7;
        this.nivel = 1;
        historial = new ArrayDeque<>();

    }

    public int getVidas() {
        return vidas;
    }

    public void perderVida() {
        vidas--;
        System.out.println("Has perdido una vida. Te quedan: " + vidas);
    }

    public int getNivel() {
        return nivel;
    }

    public void subirNivel() {
        nivel++;
    }
    public void registrarMovimiento(String habitacion) {
        historial.push(habitacion);
    }

    public String volverAtras() {
        if (!historial.isEmpty()) {
            return historial.pop();
        }
        return null;
    }
}
