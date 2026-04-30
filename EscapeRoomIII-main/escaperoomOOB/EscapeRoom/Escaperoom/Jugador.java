package Escaperoom;

public class Jugador {
private int vidas;
    private int nivel;

    public Jugador() {
        this.vidas = 7;
        this.nivel = 1;
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

}
