package com.example.testapp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;

public class theUsers {
    private String email;
    private String password;
    private String usertype;
    private String zipcode;
    public static ArrayList<Events> theEvents = new ArrayList<Events>();
    public ArrayList<Events> myEvents;
    public ArrayList<Events> eventsToBeDisplayed;

    public theUsers(String u, String p, String t, String z){
        email = u;
        password = p;
        usertype = t;
        zipcode = z;
        myEvents = new ArrayList<Events>();
        eventsToBeDisplayed = new ArrayList<Events>();
    }

    public theUsers(){
        email = "Aditya@gmail.com";
        password = "Aditya";
        usertype = "Student";
        zipcode = "98074";
    }

    public String getUserEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
    public String getUserType(){
        return this.usertype;
    }

    public String getZipcode(){
        return this.zipcode;
    }
    public void updateZipcode(String zip){
        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("Users");
        usersRef.child(zipcode).setValue(zip);
        this.zipcode = zip;
    }
    public void updateEmail(String newEmail){
        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("Users");
        usersRef.child(email).setValue(newEmail);
        this.email = newEmail;
    }
    public void updatePassword(String newPass){
        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("Users");
        usersRef.child(password).setValue(newPass);
        this.password = newPass;
    }

    public void filterEvents(String type){
        eventsToBeDisplayed = new ArrayList<Events>();
        if(type.equals("Clean Up")){
            for(Events i : theUsers.theEvents){
                if(i.getEventType().equals("Clean Up")){
                    eventsToBeDisplayed.add(i);
                }
            }
        }
        else if(type.equals("Planting")){
            for(Events i : theUsers.theEvents){
                if(i.getEventType().equals("Planting")){
                    eventsToBeDisplayed.add(i);
                }
            }
        }
        else if(type.equals("Donation Drive")){
            for(Events i : theUsers.theEvents){
                if(i.getEventType().equals("Donation Drive")){
                    eventsToBeDisplayed.add(i);
                }
            }
        }
        else{
            eventsToBeDisplayed = (ArrayList<Events>) theUsers.theEvents.clone();
        }
    }

    public double distanceCalc(Events abc){
        double radius = 6371; // Earth's radius in kilometers

        double[] latLongSet1 = {47.62597, -122.04306};
        double[] latLongSet2 = {47.61575, -122.14367};
        double[] latLongSet3 = {34.08139, -118.39927};
        double[] latLongSet4 = {47.65827, -117.4289};
        double[] latLongSet5 = {45.41238, -122.72779};



        double[] latLongUser = GeonamesGeocoder.getCoordinates(this.getZipcode());
        latLongUser = latLongSet1;
        double[] latLongEvent = GeonamesGeocoder.getCoordinates(abc.getZipcode());
        int random = (int) (Math.random()*5) + 1;
        if(random == 1){
            latLongEvent = latLongSet1;
        }
        if(random == 2){
            latLongEvent = latLongSet2;
        }
        if(random == 3){
            latLongEvent = latLongSet3;
        }
        if(random == 4){
            latLongEvent = latLongSet4;
        }
        if(random == 5){
            latLongEvent = latLongSet5;
        }


        double radLat1 = Math.toRadians(latLongUser[0]);
        double radLon1 = Math.toRadians(latLongUser[1]);
        double radLat2 = Math.toRadians(latLongEvent[0]);
        double radLon2 = Math.toRadians(latLongEvent[1]);

        // Haversine formula
        double deltaLat = radLat2 - radLat1;
        double deltaLon = radLon2 - radLon1;
        double a = Math.pow(Math.sin(deltaLat / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(deltaLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Calculate the distance
        double distance = radius * c; // Result in kilometers

        return distance;
    }

    public void distanceSorter(){
        ArrayList<Events> sortedEvents = new ArrayList<>();
        double[] theDistances = new double[this.eventsToBeDisplayed.size()];
        for(int i = 0; i < this.eventsToBeDisplayed.size(); i++){
            theDistances[i] = this.distanceCalc(this.eventsToBeDisplayed.get(i));
        }
        double[] sortedDistances = Arrays.stream(theDistances).sorted().toArray();

        for(int i = 0; i < sortedDistances.length; i++){
            for(int j = 0; j < this.eventsToBeDisplayed.size(); j++){
                if(i == this.distanceCalc(this.eventsToBeDisplayed.get(j))){
                    sortedEvents.add(this.eventsToBeDisplayed.get(j));
                }
            }
        }
        this.eventsToBeDisplayed = sortedEvents;
    }
}