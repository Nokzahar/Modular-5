package com.modular5.dao;

import com.modular5.model.Vuelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VueloDAO {
    private String url = "jdbc:mysql://localhost:3306/aerofly_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private String user = "root";
    private String pass = "74873692sS";

    public VueloDAO() throws SQLException {
    }


    public List<Vuelo> listarTodos() {
        List<Vuelo> lista = new ArrayList<>();
        String sql = "SELECT * FROM aerofly_db.vuelos";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(url, user, pass);
                 PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
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