package org.drublip.fooddelivery.services;

import org.drublip.fooddelivery.models.FoodItem;
import org.drublip.fooddelivery.utils.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FoodItemService {
    Connection dbConnection;

    public FoodItemService() {
        dbConnection = DB.connect();
    }

    public ArrayList<FoodItem> getFoodItems(int menuId) {
        ArrayList<FoodItem> foodItems = new ArrayList<>();
        if (dbConnection == null) {
            return foodItems;
        }
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement("SELECT * from food_item WHERE menu_id=?");
            preparedStatement.setInt(1, menuId);
            ResultSet results = preparedStatement.executeQuery();
            while (results.next()) {
                foodItems.add(new FoodItem(results.getInt(1), results.getString(2), results.getString(3),
                        results.getString(4).charAt(0), results.getDouble(5), results.getString(6), results.getDouble(7),
                        results.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return foodItems;
    }

}
