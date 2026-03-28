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
        String sql = "SELECT * FROM vuelos";

        System.out.println("--- Iniciando listarTodos() ---"); // SOUT 1

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(url, user, pass)) {
                System.out.println("✅ Conexión establecida con éxito a: " + url); // SOUT 2

                try (PreparedStatement ps = conn.prepareStatement(sql);
                     ResultSet rs = ps.executeQuery()) {

                    int contador = 0;
                    while (rs.next()) {
                        contador++;
                        lista.add(new Vuelo(
                                rs.getInt("id"),
                                rs.getString("numero_vuelo"),
                                rs.getString("origen"),
                                rs.getString("destino"),
                                rs.getString("hora")
                        ));
                    }
                    System.out.println("📊 Filas recuperadas de la DB: " + contador); // SOUT 3
                }
            }
        } catch (Exception e) {
            System.err.println("❌ ERROR detectado en VueloDAO:"); // SOUT 4
            e.printStackTrace();
        }

        System.out.println("📦 Tamaño final de la lista enviada al Servlet: " + lista.size()); // SOUT 5
        return lista;
    }
}