package Escaperoom;

public class Habitacion {
private String nombre;
    private Prueba reto;

    public Habitacion(String nombre, Prueba reto) {
        this.nombre = nombre;
        this.reto = reto;
    }

    public String getNombre() { //obtener nombre hab 
        return nombre;
    }

    public boolean jugar(Jugador jugador) { 
        return reto.resolver(jugador); //llama al metodo resolver de la clase especifica
    }
}

