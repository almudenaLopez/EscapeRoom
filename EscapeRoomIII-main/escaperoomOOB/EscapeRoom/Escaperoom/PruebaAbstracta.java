package Escaperoom;

import java.util.Scanner;

public abstract class PruebaAbstracta implements Prueba {
protected Scanner entrada; 
    public PruebaAbstracta(Scanner entrada) { 
        this.entrada = entrada; 
    }
    protected void perderVida(Jugador jugador) {
         jugador.perderVida(); 
        }
        @Override
    public abstract boolean resolver(Jugador jugador);
}
    