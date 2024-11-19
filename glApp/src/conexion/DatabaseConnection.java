/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // La única instancia de la clase
    private static DatabaseConnection instance;

    // Parámetros de conexión
    private final String url = "jdbc:mysql://localhost:3306/gl"; 
    private final String user = "root"; 
    private final String password = ""; 

    // Constructor privado para impedir instanciación directa
    public DatabaseConnection() {
        // Constructor está vacío ya que no estamos creando una conexión en esta etapa
    }

    // Método estático para obtener la única instancia de la clase
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // Método para obtener una nueva conexión
    public Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            //System.out.println("Conexion a la base de datos establecida.");
            return connection; // Retornamos una nueva conexión cada vez
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            return null; // Retornamos null en caso de error
        }
    }

    // Método para cerrar la conexión 
    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}

