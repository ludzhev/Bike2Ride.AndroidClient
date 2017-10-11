package com.bike2ride.ludzhev.bike2ride.models;

import java.util.Locale;

public class Location {
    private double mLatitude;
    private double mLongitude;

    /**
     * Empty constructor is necessary for GreenDao
     */
    public Location(){
    }

    public Location(double latitude, double longitude) {
        setLatitude(latitude);
        setLongitude(longitude);
    }

    private void setLatitude(double latitude) {

        this.mLatitude = latitude;
    }

    public double getLatitude() {
        return mLatitude;
    }

    private void setLongitude(double longitude) {

        this.mLongitude = longitude;
    }

    public double getLongitude() {

        return mLongitude;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "%f, %f", getLatitude(), getLongitude());
    }
}