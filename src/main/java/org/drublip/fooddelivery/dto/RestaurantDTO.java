package org.drublip.fooddelivery.dto;

import org.drublip.fooddelivery.models.Menu;
import org.drublip.fooddelivery.models.Restaurant;

public class RestaurantDTO {

    private Restaurant restaurant;
    private Menu menu;


    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

}
