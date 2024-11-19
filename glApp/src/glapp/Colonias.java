/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package glapp;

/**
 *
 * @author edw09
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.DatabaseConnection;
import javax.swing.JOptionPane;

public class Colonias {
    private int colonia_id;
    private String nombre;
    private String direccion;
    private String codigoPostal; // Atributo para el código postal

    // Constructor actualizado
    public Colonias(int colonia_id, String nombre, String direccion, String codigoPostal) {
        this.colonia_id = colonia_id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
    }

    // Método para mostrar información de la colonia
    public void mostrarInformacion() {
        System.out.println("Colonia ID: " + colonia_id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Dirección: " + direccion);
        System.out.println("Código Postal: " + codigoPostal);
    }

    // Método para actualizar dirección y código postal en la base de datos
    public void actualizarDireccion(String nuevaDireccion, String nuevoCodigoPostal) {
        this.direccion = nuevaDireccion;
        this.codigoPostal = nuevoCodigoPostal;
        String sql = "UPDATE colonias SET direccion = ?, codigo_postal = ? WHERE colonia_id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nuevaDireccion);
            pstmt.setString(2, nuevoCodigoPostal);
            pstmt.setInt(3, this.colonia_id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Dirección y código postal actualizados exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al actualizar la dirección y el código postal: " + e.getMessage());
        }
    }

    // Métodos CRUD de Colonias en la base de datos
    public void guardar() {
        String sql = "INSERT INTO colonias (colonia_id, nombre, direccion, codigo_postal) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.colonia_id);
            pstmt.setString(2, this.nombre);
            pstmt.setString(3, this.direccion);
            pstmt.setString(4, this.codigoPostal);
            pstmt.executeUpdate();
             JOptionPane.showMessageDialog(null,"Colonia guardada exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al guardar la colonia: " + e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }

    public static Colonias obtenerPorId(int colonia_id) {
        String sql = "SELECT * FROM colonias WHERE colonia_id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, colonia_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Colonias(
                        rs.getInt("colonia_id"),
                        rs.getString("nombre"),
                        rs.getString("direccion"),
                        rs.getString("codigo_postal")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la colonia: " + e.getMessage());
        }
        return null;
    }

    public void eliminar() {
        String sql = "DELETE FROM colonias WHERE colonia_id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.colonia_id);
            pstmt.executeUpdate();
            System.out.println("Colonia eliminada exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar la colonia: " + e.getMessage());
        }
    }

    // Getters y setters
    public int getColonia_id() {
        return colonia_id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setColonia_id(int colonia_id) {
        this.colonia_id = colonia_id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}


