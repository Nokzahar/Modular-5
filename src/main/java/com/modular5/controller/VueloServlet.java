package com.modular5.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.modular5.dao.VueloDAO;
import com.modular5.model.Vuelo;

import java.io.IOException;
import java.util.List;

@WebServlet("/vuelos")
public class VueloServlet extends HttpServlet {

    private VueloDAO vueloDAO = new VueloDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Vuelo> listaVuelos = vueloDAO.listarTodos();

        request.setAttribute("vuelosDisponibles", listaVuelos);

        request.getRequestDispatcher("/listaVuelos.jsp").forward(request, response);
    }
}
