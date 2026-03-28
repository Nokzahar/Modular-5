package com.modular5.dao;

import com.modular5.model.Vuelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para la gestión de datos de Vuelos.
 * Centraliza las operaciones CRUD para cumplir con el patrón MVC.
 */
public class VueloDAO {
    // Configura estos datos según tu MySQL local
    private String url = "jdbc:mysql://localhost:3306/aerofly_db";
    private String user = "root";
    private String pass = "74873692sS"; // Asegúrate de usar tu clave real aquí

    /**
     * Lista todos los vuelos disponibles desde la base de datos.
     * @return List de objetos Vuelo
     */
    public List<Vuelo> listarTodos() {
        List<Vuelo> lista = new ArrayList<>();
        // Consulta SQL con los nombres de columnas de tu DB
        String sql = "SELECT id, numero_vuelo, origen, destino, hora FROM vuelos";

        try {
            // Carga del driver para evitar "No suitable driver"
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(url, user, pass);
                 PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    // IMPORTANTE: rs.get usa los nombres de la BASE DE DATOS (con guion bajo)
                    // El constructor de Vuelo usa los datos obtenidos
                    lista.add(new Vuelo(
                            rs.getInt("id"),
                            rs.getString("numero_vuelo"),
                            rs.getString("origen"),
                            rs.getString("destino"),
                            rs.getString("hora")
                    ));
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Driver no encontrado");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error SQL al listar: " + e.getMessage());
            e.printStackTrace();
        }
        return lista;
    }
}