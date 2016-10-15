package com.rana.mapchallenge.database;

import com.orm.SugarRecord;

/**
 * Created by sandeeprana on 15/10/16.
 * License is only applicable to individuals and non-profits
 * and that any for-profit company must
 * purchase a different license, and create
 * a second commercial license of your
 * choosing for companies
 */

public class Favorite extends SugarRecord {
    private double latitude;
    private double longitude;
    private String address;

    public Favorite(double latitude, double longitude, String address) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }

    public Favorite() {

    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
