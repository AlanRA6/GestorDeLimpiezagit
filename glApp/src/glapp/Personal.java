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

public class Personal {
    private int personal_id;
    private String nombre;
    private int cuadrillaId; // ID de la cuadrilla a la que pertenece

    // Constructor
    public Personal(int personal_id, String nombre, int cuadrillaId) {
        this.personal_id = personal_id;
        this.nombre = nombre;
        this.cuadrillaId = cuadrillaId;
    }

    // Métodos CRUD de Personal en la base de datos
    public void guardar() {
        String sql = "INSERT INTO personal (personal_id, nombre, cuadrilla_id) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.personal_id);
            pstmt.setString(2, this.nombre);
            pstmt.setInt(3, this.cuadrillaId);
            pstmt.executeUpdate();
            System.out.println("Miembro guardado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al guardar el miembro: " + e.getMessage());
        }
    }

    public static Personal obtenerPorId(int personal_id) {
        String sql = "SELECT * FROM personal WHERE personal_id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, personal_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Personal(
                        rs.getInt("personal_id"),
                        rs.getString("nombre"),
                        rs.getInt("cuadrilla_id")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el miembro: " + e.getMessage());
        }
        return null;
    }

    public void actualizar() {
        String sql = "UPDATE personal SET nombre = ?, cuadrilla_id = ? WHERE personal_id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.nombre);
            pstmt.setInt(2, this.cuadrillaId);
            pstmt.setInt(3, this.personal_id);
            pstmt.executeUpdate();
            System.out.println("Miembro actualizado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar el miembro: " + e.getMessage());
        }
    }

    public void eliminar() {
        String sql = "DELETE FROM personal WHERE personal_id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.personal_id);
            pstmt.executeUpdate();
            System.out.println("Miembro eliminado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el miembro: " + e.getMessage());
        }
    }

    // Métodos de manipulación de cuadrillas
    public void asignarCuadrilla(Cuadrilla cuadrilla) {
        this.cuadrillaId = cuadrilla.getCuadrilla_id();
        System.out.println("Miembro " + this.nombre + " asignado a la cuadrilla " + cuadrilla.getNombre());
    }

    public void removerDeCuadrilla() {
        this.cuadrillaId = 0; // Suponiendo que 0 indica que no pertenece a ninguna cuadrilla
        System.out.println("Miembro " + this.nombre + " removido de la cuadrilla.");
    }

    // Getters y setters
    public int getPersonal_id() {
        return personal_id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCuadrillaId() {
        return cuadrillaId;
    }

    public void setPersonal_id(int personal_id) {
        this.personal_id = personal_id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCuadrillaId(int cuadrillaId) {
        this.cuadrillaId = cuadrillaId;
    }
}

