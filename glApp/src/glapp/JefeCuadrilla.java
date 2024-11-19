package glapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conexion.DatabaseConnection;
import javax.swing.JOptionPane;

public class JefeCuadrilla {
    private int jefeCuadrilla_id;
    private String nombre;
    private String email;
    private String telefono;
    private String usuario;
    private String contrasena;  // Nuevo campo de contraseña
    private List<Cuadrilla> cuadrillasAsignadas = new ArrayList<>();

        // Constructor privado
    private JefeCuadrilla(Builder builder) {
        this.jefeCuadrilla_id = builder.jefeCuadrilla_id;
        this.nombre = builder.nombre;
        this.email = builder.email;
        this.telefono = builder.telefono;
        this.usuario = builder.usuario;
        this.contrasena = builder.contrasena;
    }

    // Métodos CRUD de JefeCuadrilla en la base de datos
    public void guardar() {
        String sql = "INSERT INTO jefecuadrilla (jefeCuadrilla_id, nombre, email, telefono, usuario, contrasena) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.jefeCuadrilla_id);
            pstmt.setString(2, this.nombre);
            pstmt.setString(3, this.email);
            pstmt.setString(4, this.telefono);
            pstmt.setString(5, this.usuario);
            pstmt.setString(6, this.contrasena);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Jefe de cuadrilla guardado exitosamente", "Aceptado", 1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el jefe de cuadrilla: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

   public static JefeCuadrilla obtenerPorId(int jefeCuadrilla_id) {
        String sql = "SELECT * FROM jefecuadrilla WHERE jefeCuadrilla_id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, jefeCuadrilla_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Usamos el Builder para crear el objeto JefeCuadrilla
                return new Builder()
                        .setJefeCuadrilla_id(rs.getInt("jefeCuadrilla_id"))
                        .setNombre(rs.getString("nombre"))
                        .setEmail(rs.getString("email"))
                        .setTelefono(rs.getString("telefono"))
                        .setUsuario(rs.getString("usuario"))
                        .setContrasena(rs.getString("contrasena"))
                        .build();
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el jefe de cuadrilla: " + e.getMessage());
        }
        return null;
    }


    public void actualizar() {
        String sql = "UPDATE jefecuadrilla SET nombre = ?, email = ?, telefono = ?, usuario = ?, contrasena = ? WHERE jefeCuadrilla_id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.nombre);
            pstmt.setString(2, this.email);
            pstmt.setString(3, this.telefono);
            pstmt.setString(4, this.usuario);
            pstmt.setString(5, this.contrasena);
            pstmt.setInt(6, this.jefeCuadrilla_id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Jefe de cuadrilla actualizado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el jefe de cuadrilla: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void eliminar(int jefeCuadrillaId) {
        String sqlDesasociar = "UPDATE Cuadrilla SET jefeCuadrilla_id = NULL WHERE jefeCuadrilla_id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmtDesasociar = conn.prepareStatement(sqlDesasociar)) {
            pstmtDesasociar.setInt(1, jefeCuadrillaId);
            pstmtDesasociar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Jefe de cuadrilla desasociado de todas las cuadrillas");
            
            String sqlEliminar = "DELETE FROM JefeCuadrilla WHERE jefeCuadrilla_id = ?";
            try (PreparedStatement pstmtEliminar = conn.prepareStatement(sqlEliminar)) {
                pstmtEliminar.setInt(1, jefeCuadrillaId);
                pstmtEliminar.executeUpdate();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el jefe de cuadrilla: " + e.getMessage());
        }
    }

    // Métodos de manipulación de cuadrillas asignadas
    public void asignarCuadrilla(Cuadrilla cuadrilla) {
        cuadrillasAsignadas.add(cuadrilla);
        System.out.println("Cuadrilla " + cuadrilla.getNombre() + " asignada a " + this.nombre);
    }

    public void removerCuadrilla(Cuadrilla cuadrilla) {
        cuadrillasAsignadas.remove(cuadrilla);
        System.out.println("Cuadrilla " + cuadrilla.getNombre() + " removida de " + this.nombre);
    }

    public List<Cuadrilla> listarCuadrillas() {
        return cuadrillasAsignadas;
    }
    
    
    public static class Builder {
        private int jefeCuadrilla_id;
        private String nombre;
        private String email;
        private String telefono;
        private String usuario;
        private String contrasena;

        public Builder setJefeCuadrilla_id(int jefeCuadrilla_id) {
            this.jefeCuadrilla_id = jefeCuadrilla_id;
            return this;
        }

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setTelefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public Builder setUsuario(String usuario) {
            this.usuario = usuario;
            return this;
        }

        public Builder setContrasena(String contrasena) {
            this.contrasena = contrasena;
            return this;
        }

        public JefeCuadrilla build() {
            return new JefeCuadrilla(this);
        }
    }


     // Getters y setters

    public int getJefeCuadrilla_id() {
        return jefeCuadrilla_id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public List<Cuadrilla> getCuadrillasAsignadas() {
        return cuadrillasAsignadas;
    }
}
