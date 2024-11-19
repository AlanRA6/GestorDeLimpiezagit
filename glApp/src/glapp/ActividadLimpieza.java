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
import java.util.Date;
import conexion.DatabaseConnection;

public class ActividadLimpieza {
    private int ActividadLimpieza_id;
    private String descripcion;
    private Date fecha;
    private int colonia_id; // ID del lugar
    private int cuadrillaId; // ID de la cuadrilla

    // Constructor
    public ActividadLimpieza(int ActividadLimpieza_id, String descripcion, Date fecha, int colonia_id, int cuadrillaId) {
        this.ActividadLimpieza_id = ActividadLimpieza_id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.colonia_id = colonia_id;
        this.cuadrillaId = cuadrillaId;
    }

    // Métodos CRUD de ActividadLimpieza en la base de datos
    public void guardar() {
        String sql = "INSERT INTO actividadlimpieza (ActividadLimpieza_id, descripcion, fecha, colonia_id, cuadrilla_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.ActividadLimpieza_id);
            pstmt.setString(2, this.descripcion);
            pstmt.setDate(3, new java.sql.Date(this.fecha.getTime()));
            pstmt.setInt(4, this.colonia_id);
            pstmt.setInt(5, this.cuadrillaId);
            pstmt.executeUpdate();
            System.out.println("Actividad de limpieza guardada exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al guardar la actividad de limpieza: " + e.getMessage());
        }
    }

    public static ActividadLimpieza obtenerPorId(int ActividadLimpieza_id) {
        String sql = "SELECT * FROM actividadlimpieza WHERE ActividadLimpieza_id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ActividadLimpieza_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new ActividadLimpieza(
                        rs.getInt("ActividadLimpieza_id"),
                        rs.getString("descripcion"),
                        rs.getDate("fecha"),
                        rs.getInt("colonia_id"),
                        rs.getInt("cuadrilla_id")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la actividad de limpieza: " + e.getMessage());
        }
        return null;
    }

    public void actualizar() {
        String sql = "UPDATE actividadlimpieza SET descripcion = ?, fecha = ?, colonia_id = ?, cuadrilla_id = ? WHERE ActividadLimpieza_id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.descripcion);
            pstmt.setDate(2, new java.sql.Date(this.fecha.getTime()));
            pstmt.setInt(3, this.colonia_id);
            pstmt.setInt(4, this.cuadrillaId);
            pstmt.setInt(5, this.ActividadLimpieza_id);
            pstmt.executeUpdate();
            System.out.println("Actividad de limpieza actualizada exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar la actividad de limpieza: " + e.getMessage());
        }
    }

    public void eliminar() {
        String sql = "DELETE FROM actividadlimpieza WHERE ActividadLimpieza_id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.ActividadLimpieza_id);
            pstmt.executeUpdate();
            System.out.println("Actividad de limpieza eliminada exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar la actividad de limpieza: " + e.getMessage());
        }
    }

    // Métodos de manipulación
    public void asignarLugar(Colonias lugar) {
        this.colonia_id = lugar.getColonia_id();
        System.out.println("Lugar " + lugar.getNombre() + " asignado a la actividad " + this.descripcion);
    }

    public void asignarCuadrilla(Cuadrilla cuadrilla) {
        this.cuadrillaId = cuadrilla.getCuadrilla_id();
        System.out.println("Cuadrilla " + cuadrilla.getNombre() + " asignada a la actividad " + this.descripcion);
    }

    public void actualizarFecha(Date nuevaFecha) {
        this.fecha = nuevaFecha;
        System.out.println("Fecha actualizada para la actividad " + this.descripcion);
    }

    public void detallesActividad() {
        System.out.println("Actividad ID: " + ActividadLimpieza_id);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Fecha: " + fecha);
        System.out.println("Lugar ID: " + colonia_id);
        System.out.println("Cuadrilla ID: " + cuadrillaId);
    }

    // Getters y setters
    public int getActividadLimpieza_id() {
        return ActividadLimpieza_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getColonia_id() {
        return colonia_id;
    }

    public int getCuadrillaId() {
        return cuadrillaId;
    }

    public void setActividadLimpieza_id(int ActividadLimpieza_id) {
        this.ActividadLimpieza_id = ActividadLimpieza_id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setColonia_id(int lugarId) {
        this.colonia_id = lugarId;
    }

    public void setCuadrillaId(int cuadrillaId) {
        this.cuadrillaId = cuadrillaId;
    }
}



