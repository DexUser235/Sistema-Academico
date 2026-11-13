
package universidad.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSingleton {

    private static final ConexionSingleton instancia = new ConexionSingleton();

    private static final String URL =
            "jdbc:sqlserver://DESKTOP-JQI9UCH:1433;"
                    + "databaseName=SistemaAcademico;"
                    + "encrypt=true;"
                    + "trustServerCertificate=true;";

    private ConexionSingleton() {
    }

    public static ConexionSingleton getInstancia() {
        return instancia;
    }

    public Connection getConnection() throws SQLException {

        String usuario = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        if (usuario == null || password == null) {
            throw new IllegalStateException(
                    "Configura las variables DB_USER y DB_PASSWORD."
            );
        }

        return DriverManager.getConnection(URL, usuario, password);
    }
}
