package Escaperoom;

public class Escaleras extends PruebaAbstracta {

    public Escaleras(java.util.Scanner entrada) {
        super(entrada);
    }

    @Override
    public boolean resolver(Jugador jugador) {

        char[][] tablero = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        boolean turnoJugador = true;

        while (true) {

            mostrarTablero(tablero);

            if (turnoJugador) {
                jugadorMueve(tablero);
            } else {
                loroMueve(tablero);
            }

            if (hayGanador(tablero, turnoJugador ? 'X' : 'O')) {

                mostrarTablero(tablero);

                if (turnoJugador) {
                    System.out.println("Has ganado! Tienes la brújula");
                    return true;
                } else {
                    System.out.println("Has perdido!");
                    perderVida(jugador);
                    return false;
                }
            }

            if (tableroLleno(tablero)) {
                System.out.println("Empate! Pierdes vida.");
                perderVida(jugador);
                return false;
            }

            turnoJugador = !turnoJugador;
        }
    }

    private void mostrarTablero(char[][] t) {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(t[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
        }
    }

    private void jugadorMueve(char[][] t) {
        int fila, col;

        while (true) {
            System.out.print("Fila (0-2): ");
            fila = entrada.nextInt();
            System.out.print("Columna (0-2): ");
            col = entrada.nextInt();
            entrada.nextLine();

            if (fila >= 0 && fila < 3 &&
                col >= 0 && col < 3 &&
                t[fila][col] == ' ') {

                t[fila][col] = 'X';
                break;
            }

            System.out.println("No se puede hacer ese movimiento");
        }
    }

    private void loroMueve(char[][] t) {
        int fila, col;
        do {
            fila = (int)(Math.random() * 3);
            col = (int)(Math.random() * 3);
        } while (t[fila][col] != ' ');

        t[fila][col] = 'O';
    }

    private boolean hayGanador(char[][] t, char f) {
        for (int i = 0; i < 3; i++) {
            if ((t[i][0]==f && t[i][1]==f && t[i][2]==f) ||
                (t[0][i]==f && t[1][i]==f && t[2][i]==f))
                return true;
        }

        return (t[0][0]==f && t[1][1]==f && t[2][2]==f) ||
               (t[0][2]==f && t[1][1]==f && t[2][0]==f);
    }

    private boolean tableroLleno(char[][] t) {
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++)
                if (t[i][j]==' ') return false;
        return true;
    }
}

