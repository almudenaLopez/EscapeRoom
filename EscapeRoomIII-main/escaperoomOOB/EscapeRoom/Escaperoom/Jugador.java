package Escaperoom;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Jugador {
private int vidas;
    private int nivel;
    private Deque<String> historial; //pila
    private Set<String> inventario;//set

    // TRANSIENT → no se serializa
    private transient String sesionTemporal;

    // TURNOS
    private int turnos;

    public Jugador() {
        this.vidas = 7;
        this.nivel = 1;
        this.turnos = 20;

        historial = new ArrayDeque<>();
        inventario = new HashSet<>();
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

    public int getTurnos() {
        return turnos;
    }
    public void gastarTurnos(){
        turnos--;
    }

    public void registrarMovimiento(String habitacion) { //pila

        historial.push(habitacion);
    }

    public String volverAtras() {
        if (!historial.isEmpty()) {
            return historial.pop();
        }
        return null;
    }
    // INVENTARIO

    public void añadirObjeto(String objeto) {
        inventario.add(objeto);
    }

    public boolean tieneObjeto(String objeto) {
        return inventario.contains(objeto);
    }

    public void mostrarInventario() {
        System.out.println("Inventario: " + inventario);
    }

    // STREAM

    public void mostrarLlaves() {
        inventario.stream()
                .filter(obj -> obj.contains("llave"))
                .forEach(System.out::println);
    }
}

