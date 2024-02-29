package com.example.contactlist;

public class Location {
    double Longitude;
    double Latitude;

    public Location(double longitude,double latitude){
        this.Latitude=latitude;
        this.Longitude=longitude;
    }
    public void setLongitude(double longitude){
        this.Longitude =longitude;
    }
    public void setLatitude(double latitude){
        this.Latitude = latitude;
    }
    public String toString(){
        String str = "Longitude" + Longitude + ",Latitude:" + Latitude;
        return str;
    }
}
