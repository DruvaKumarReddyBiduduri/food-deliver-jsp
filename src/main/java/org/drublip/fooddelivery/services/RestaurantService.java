package org.drublip.fooddelivery.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.drublip.fooddelivery.dto.RestaurantDTO;
import org.drublip.fooddelivery.models.FoodItem;
import org.drublip.fooddelivery.models.Menu;
import org.drublip.fooddelivery.models.Restaurant;
import org.drublip.fooddelivery.utils.DB;


public class RestaurantService {
    FoodItemService foodItemService;
    Connection dbConnection;

    public RestaurantService() {
        foodItemService = new FoodItemService();
        dbConnection = DB.connect();
    }

    public ArrayList<Restaurant> getRestaurents() {
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        if (dbConnection == null) {
            return restaurants;
        }
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement("Select * from restaurant_detail");
            ResultSet results = preparedStatement.executeQuery();
            while (results.next()) {
                restaurants.add(new Restaurant(results.getInt(1), results.getString(2), results.getString(3), results.getString(4), results.getString(5), results.getString(6), results.getString(7), results.getString(8), results.getLong(9), results.getLong(10), results.getString(11), results.getString(12), results.getDouble(13), results.getBoolean(14)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return restaurants;
    }

    public void getRestaurant(int id, RestaurantDTO data) throws SQLException {
        PreparedStatement preparedStatement = dbConnection.prepareStatement("SELECT rd.*,m.id from restaurant_detail rd LEFT JOIN menu m ON m.res_id=rd.id WHERE rd.id=?");
        preparedStatement.setInt(1, id);
        ResultSet results = preparedStatement.executeQuery();
        if (results.next()) {
            data.setRestaurant(new Restaurant(results.getInt(1), results.getString(2), results.getString(3), results.getString(4), results.getString(5), results.getString(6), results.getString(7), results.getString(8), results.getLong(9), results.getLong(10), results.getString(11), results.getString(12), results.getDouble(13), results.getBoolean(14)));
            data.setMenu(new Menu(results.getInt(15), id));
        }
    }


    public RestaurantDTO getRestaurantDetails(int id) {
        RestaurantDTO data = new RestaurantDTO();
        if (dbConnection == null) {
            return data;
        }
        try {
            getRestaurant(id, data);
            if (data.getRestaurant() != null) {
                ArrayList<FoodItem> foodItems = foodItemService.getFoodItems(data.getMenu().getId());
                data.getMenu().setMenuItemList(foodItems);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
}
