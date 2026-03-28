package com.modular5.controller;

import com.modular5.dao.ReservaDAO;
import com.modular5.model.Reserva;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reservar")
public class ReservaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Recuperar los datos del formulario JSP
        String idVueloStr = request.getParameter("idVuelo");
        String numeroVuelo = request.getParameter("numeroVuelo");

        System.out.println("--- Iniciando Proceso de Reserva ---");

        if (idVueloStr != null && !idVueloStr.isEmpty()) {
            try {
                int idVuelo = Integer.parseInt(idVueloStr);
                System.out.println(">>> Intentando reservar Vuelo ID: " + idVuelo + " (" + numeroVuelo + ")");

                // 2. Crear el objeto Reserva con datos para tu DAO
                // Como por ahora no pedimos nombre/email en el JSP, usamos valores por defecto
                Reserva nuevaReserva = new Reserva();
                nuevaReserva.setVueloId(idVuelo);
                nuevaReserva.setNombrePasajero("Pasajero Web"); // Valor temporal
                nuevaReserva.setEmailPasajero("contacto@aerofly.cl"); // Valor temporal

                // 3. Llamar al DAO para insertar en MySQL
                ReservaDAO reservaDAO = new ReservaDAO();
                boolean exito = reservaDAO.insertarReserva(nuevaReserva);

                if (exito) {
                    System.out.println("✅ ¡ÉXITO! Reserva guardada en la tabla 'reservas'.");
                    // Redirigimos con un mensaje de éxito
                    response.sendRedirect("vuelos?mensaje=ReservaExitosa");
                } else {
                    System.out.println("❌ ERROR: El DAO no pudo insertar la fila.");
                    response.sendRedirect("vuelos?error=FalloInsercion");
                }

            } catch (NumberFormatException e) {
                System.err.println("❌ ERROR: El ID del vuelo no es un número válido.");
                response.sendRedirect("vuelos?error=IdInvalido");
            }
        } else {
            System.err.println("❌ ERROR: No se recibió el ID del vuelo.");
            response.sendRedirect("vuelos?error=FaltaId");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Si intentan entrar por URL directa, los mandamos a la lista de vuelos
        response.sendRedirect("vuelos");
    }
}