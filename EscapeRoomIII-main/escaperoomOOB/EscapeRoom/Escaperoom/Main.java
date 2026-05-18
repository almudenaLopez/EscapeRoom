package Escaperoom;

public class Main {

    public static void main(String[] args) {
        InterfazGrafica interfazGrafica = new InterfazGrafica();
        interfazGrafica.setVisible(true);
        Juego juego = new Juego(); // creo la clase juego
        juego.iniciar(); //incia el juego 
        

    }
}
