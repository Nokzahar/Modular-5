package com.modular5.dao;

import com.modular5.model.Reserva;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservaDAO {
    private String url = "jdbc:mysql://localhost:3306/aerofly_db";
    private String user = "root";
    private String pass = "tu_password"; // Usa la contraseña de tu conexión local

    public boolean insertarReserva(Reserva reserva) {
        String sql = "INSERT INTO reservas (vuelo_id, nombre_pasajero, email_pasajero) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, reserva.getVueloId());
            ps.setString(2, reserva.getNombrePasajero());
            ps.setString(3, reserva.getEmailPasajero());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al insertar reserva: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
