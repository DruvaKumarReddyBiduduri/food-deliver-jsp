package org.drublip.fooddelivery.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.drublip.fooddelivery.models.Restaurant;
import org.drublip.fooddelivery.services.RestaurantService;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Servlet implementation class Index
 */
@WebServlet(name = "home", value = "")
public class HomeServlet extends HttpServlet {

    RestaurantService restaurantService;

    public HomeServlet() {
    }

    @Override
    public void init() throws ServletException {
        restaurantService = new RestaurantService();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Restaurant> res = restaurantService.getRestaurents();
        request.setAttribute("restaurants", res);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void destroy() {
        restaurantService = null;
    }

}
