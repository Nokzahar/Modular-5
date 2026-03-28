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
    private ReservaDAO reservaDAO = new ReservaDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String vueloIdStr = request.getParameter("vueloId");
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");

        if (nombre == null || nombre.trim().isEmpty() ||
                email == null || !email.contains("@") ||
                vueloIdStr == null) {

            request.setAttribute("error", "Datos de reserva inválidos. Intente de nuevo.");
            request.getRequestDispatcher("formularioReserva.jsp").forward(request, response);
            return;
        }

        int vueloId = Integer.parseInt(vueloIdStr);
        Reserva nuevaReserva = new Reserva(vueloId, nombre, email);

        boolean exito = reservaDAO.insertarReserva(nuevaReserva);

        if (exito) {
            response.sendRedirect("vuelos?mensaje=Reserva+exitosa");
        } else {
            request.setAttribute("error", "Error al procesar la reserva en la base de datos.");
            request.getRequestDispatcher("formularioReserva.jsp").forward(request, response);
        }
    }
}