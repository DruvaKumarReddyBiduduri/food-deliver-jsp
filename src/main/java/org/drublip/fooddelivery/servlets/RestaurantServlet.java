package org.drublip.fooddelivery.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.drublip.fooddelivery.dto.RestaurantDTO;
import org.drublip.fooddelivery.services.FoodItemService;
import org.drublip.fooddelivery.services.RestaurantService;

import java.io.IOException;

@WebServlet(name = "restaurantServlet", value = "/restaurant/*")
public class RestaurantServlet extends HttpServlet {
    RestaurantService restaurantService;
    FoodItemService foodItemService;

    @Override
    public void init() throws ServletException {
        restaurantService = new RestaurantService();
        foodItemService = new FoodItemService();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        try {
            int resId = Integer.parseInt(pathInfo.substring(1));
            RestaurantDTO data = restaurantService.getRestaurantDetails(resId);
            if (data.getRestaurant() == null) {
                resp.sendRedirect("/food-delivery/error.jsp");
            } else {
                req.setAttribute("data", data);
                getServletContext().getRequestDispatcher("/restaurant.jsp").forward(req, resp);
            }
        } catch (NumberFormatException e) {
            resp.sendRedirect("/food-delivery/error.jsp");
        }
    }

    @Override
    public void destroy() {
        restaurantService = null;
        foodItemService = null;
    }
}
