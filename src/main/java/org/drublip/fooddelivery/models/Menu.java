package org.drublip.fooddelivery.models;

import java.util.ArrayList;

public class Menu {
    private int id;
    private int resId;
    private ArrayList<FoodItem> menuItemList;

    public Menu(int id,int resId) {
        this.id=id;
        this.resId=resId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public ArrayList<FoodItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(ArrayList<FoodItem> menuItemList) {
        this.menuItemList = menuItemList;
    }
}
