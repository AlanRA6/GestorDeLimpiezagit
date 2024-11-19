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
import java.util.ArrayList;
import java.util.List;
import conexion.DatabaseConnection;

public class Cuadrilla {
    private int cuadrilla_id;
    private String nombre;
    private String ubicacion;
    private int jefeCuadrilla_id; // ID del jefe de cuadrilla
    private List<Personal> miembros = new ArrayList<>();

    // Constructor
    public Cuadrilla(int cuadrilla_id, String nombre, String ubicacion, int jefeCuadrilla_id) {
        this.cuadrilla_id = cuadrilla_id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.jefeCuadrilla_id = jefeCuadrilla_id;
    }

    // Métodos CRUD de Cuadrilla en la base de datos
    public void guardar() {
        String sql = "INSERT INTO cuadrilla (cuadrilla_id, nombre, ubicacion, jefeCuadrilla_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.cuadrilla_id);
            pstmt.setString(2, this.nombre);
            pstmt.setString(3, this.ubicacion);
            pstmt.setInt(4, this.jefeCuadrilla_id);
            pstmt.executeUpdate();
            System.out.println("Cuadrilla guardada exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al guardar la cuadrilla: " + e.getMessage());
        }
    }

    public static Cuadrilla obtenerPorId(int cuadrilla_id) {
        String sql = "SELECT * FROM cuadrilla WHERE cuadrilla_id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cuadrilla_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Cuadrilla(
                        rs.getInt("cuadrilla_id"),
                        rs.getString("nombre"),
                        rs.getString("ubicacion"),
                        rs.getInt("jefeCuadrilla_id")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la cuadrilla: " + e.getMessage());
        }
        return null;
    }

    public void actualizar() {
    String sql = "UPDATE cuadrilla SET nombre = ?, ubicacion = ?, jefeCuadrilla_id = ? WHERE cuadrilla_id = ?";
    try (Connection conn = DatabaseConnection.getInstance().getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, this.nombre);
        pstmt.setString(2, this.ubicacion);
        
        // Asigna NULL si el ID es 0
        if (this.jefeCuadrilla_id == 0) {
            pstmt.setNull(3, java.sql.Types.INTEGER);
        } else {
            pstmt.setInt(3, this.jefeCuadrilla_id);
        }
        
        pstmt.setInt(4, this.cuadrilla_id);
        pstmt.executeUpdate();
        System.out.println("Cuadrilla actualizada exitosamente.");
    } catch (SQLException e) {
        System.out.println("Error al actualizar la cuadrilla: " + e.getMessage());
    }
}


    public void eliminar() {
    // Desasociar miembros de la cuadrilla
    String desasociarMiembrosSQL = "UPDATE personal SET cuadrilla_id = NULL WHERE cuadrilla_id = ?";
    // Desasociar actividades de limpieza de la cuadrilla
    String desasociarActividadesSQL = "UPDATE actividadlimpieza SET cuadrilla_id = NULL WHERE cuadrilla_id = ?";
    // Eliminar la cuadrilla
    String eliminarCuadrillaSQL = "DELETE FROM cuadrilla WHERE cuadrilla_id = ?";

    try (Connection conn = DatabaseConnection.getInstance().getConnection()) {
        conn.setAutoCommit(false);  // Iniciar transacción

        try (PreparedStatement pstmtDesasociarMiembros = conn.prepareStatement(desasociarMiembrosSQL);
             PreparedStatement pstmtDesasociarActividades = conn.prepareStatement(desasociarActividadesSQL);
             PreparedStatement pstmtEliminar = conn.prepareStatement(eliminarCuadrillaSQL)) {

            // Actualizar miembros para que su cuadrilla_id sea NULL
            pstmtDesasociarMiembros.setInt(1, this.cuadrilla_id);
            pstmtDesasociarMiembros.executeUpdate();

            // Actualizar actividades de limpieza para que su cuadrilla_id sea NULL
            pstmtDesasociarActividades.setInt(1, this.cuadrilla_id);
            pstmtDesasociarActividades.executeUpdate();

            // Eliminar la cuadrilla
            pstmtEliminar.setInt(1, this.cuadrilla_id);
            pstmtEliminar.executeUpdate();

            conn.commit();  // Confirmar transacción si ambas operaciones fueron exitosas
            System.out.println("Cuadrilla eliminada exitosamente.");

        } catch (SQLException e) {
            conn.rollback();  // Revertir cambios en caso de error
            System.out.println("Error al eliminar la cuadrilla: " + e.getMessage());
        }
    } catch (SQLException e) {
        System.out.println("Error al conectar a la base de datos: " + e.getMessage());
    }
}



    // Métodos de manipulación de miembros
    public void addMiembro(Personal miembro) {
        miembros.add(miembro);
        System.out.println("Miembro " + miembro.getNombre() + " agregado a la cuadrilla " + this.nombre);
    }

    public void removeMiembro(Personal miembro) {
        miembros.remove(miembro);
        System.out.println("Miembro " + miembro.getNombre() + " removido de la cuadrilla " + this.nombre);
    }

    public List<Personal> listarMiembros() {
        return miembros;
    }

    // Getters y setters
    public int getCuadrilla_id() {
        return cuadrilla_id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getJefeCuadrilla_id() {
        return jefeCuadrilla_id;
    }

    public void setCuadrilla_id(int cuadrilla_id) {
        this.cuadrilla_id = cuadrilla_id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setJefeCuadrilla_id(int jefeCuadrilla_id) {
        this.jefeCuadrilla_id = jefeCuadrilla_id;
    }
}

