package com.modular5.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reservar")
public class ReservaServlet extends HttpServlet {

    /**
     * El error 405 ocurre porque el formulario envía un POST,
     * pero el Servlet no tiene este método implementado correctamente.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Recuperar los datos enviados desde el formulario JSP
        // Asegúrate de que en tu JSP el input tenga name="idVuelo"
        String idVuelo = request.getParameter("idVuelo");
        String numeroVuelo = request.getParameter("numeroVuelo");

        // 2. Lógica de control (Por ahora mostramos en consola de IntelliJ)
        System.out.println("--- Procesando Reserva ---");
        System.out.println("ID del Vuelo a reservar: " + idVuelo);
        System.out.println("Número de Vuelo: " + numeroVuelo);

        // 3. Aquí podrías llamar a un ReservaDAO para guardar en la tabla 'reservas'
        // Por ahora, simularemos que la reserva fue exitosa.

        // 4. Redirigir al usuario a una página de éxito o de vuelta a la lista
        // Usamos sendRedirect para evitar que si el usuario refresca la página, se duplique la reserva.
        response.sendRedirect("vuelos?mensaje=ReservaExitosa");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // En caso de que alguien intente entrar por URL, lo mandamos de vuelta a la lista
        response.sendRedirect("vuelos");
    }
}