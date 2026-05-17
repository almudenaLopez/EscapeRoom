package Escaperoom;


import javax.swing.*;
import java.awt.*;

    public class InterfazGrafica extends JFrame {

        public InterfazGrafica() {

            setTitle("Escape Room");
            setSize(400, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            JTextArea area = new JTextArea();

            area.setText(
                    "ESCAPE ROOM PERLA NEGRA\n\n" +
                            "Objetivo:\n" +
                            "Escapar antes de que llegue el Kraken\n\n" +
                            "Comandos:\n" +
                            "- nombre habitación\n" +
                            "- volver\n" +
                            "- inventario\n" +
                            "- guardar"
            );

            area.setEditable(false);

            add(new JScrollPane(area), BorderLayout.CENTER);
        }

}
