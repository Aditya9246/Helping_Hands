package com.example.testapp;

public class Events {
    public String eventName;
    public String eventDescription;
    public theUsers owner;
    public String date;
    public String eventType;
    public String zipcode;

    public double[] latLong;

    public Events(String name, String description, theUsers currentAdmin, String zip, String dateInput, String type){
        latLong = GeonamesGeocoder.getCoordinates(zip);
        eventName = name;
        eventDescription = description;
        owner = currentAdmin;
        date = dateInput;
        eventType = type;
        zipcode = zip;
    }

    public String getEventName(){
        return eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }
    public String getDate(){
        return date;
    }
    public double[] getLatLong(){
        return latLong;
    }
    public String getEventType(){
        return eventType;
    }
    public String getZipcode(){
        return zipcode;
    }
}
