package org.drublip.fooddelivery.models;

import java.util.Arrays;

public class Restaurant  {
    private int id;
    private String name;
    private String address;
    private String location;
    private String openTime;
    private String closeTime;
    private String[] cuisineList;
    private String gstNumber;
    private long contactNumber;
    private long bankAccountNumber;
    private String email;
    private String password;
    private double avgRating;
    private boolean orderAcceptingStatus;

    public Restaurant(int id, String name, String address, String location,
                      String openTime, String closeTime,
                      String gstNumber, String cuisineList,long contactNumber, long bankAccountNumber,
                      String email,String password,double avgRating, boolean orderAcceptingStatus ) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.location = location;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.cuisineList = cuisineList.split(",");
        this.gstNumber = gstNumber;
        this.contactNumber = contactNumber;
        this.bankAccountNumber = bankAccountNumber;
        this.email = email;
        this.password=password;
        this.avgRating = avgRating;
        this.orderAcceptingStatus = orderAcceptingStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String[] getCuisineList() {
        return cuisineList;
    }

    public void setCuisineList(String[] cuisineList) {
        this.cuisineList = cuisineList;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public long getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(long bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public boolean isOrderAcceptingStatus() {
        return orderAcceptingStatus;
    }

    public void setOrderAcceptingStatus(boolean orderAcceptingStatus) {
        this.orderAcceptingStatus = orderAcceptingStatus;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", location='" + location + '\'' +
                ", openTime='" + openTime + '\'' +
                ", closeTime='" + closeTime + '\'' +
                ", cuisineList=" + Arrays.toString(cuisineList) +
                ", gstNumber='" + gstNumber + '\'' +
                ", contactNumber=" + contactNumber +
                ", bankAccountNumber=" + bankAccountNumber +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", avgRating=" + avgRating +
                ", orderAcceptingStatus=" + orderAcceptingStatus +
                '}';
    }
}
