package Escaperoom;

import java.sql.Connection;
import java.sql.DriverManager;

    public class BaseDatos {

        public static Connection conectar() {

            try {

                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/escaperoom",
                        "root",
                        ""
                );

                System.out.println("Conexión correcta");
                return con;

            } catch (Exception e) {

                System.out.println("Error de conexión");
                return null;
            }
        }
    }