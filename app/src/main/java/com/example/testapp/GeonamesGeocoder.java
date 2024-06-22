package com.example.testapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import org.json.JSONArray;
import org.json.JSONObject;

public class GeonamesGeocoder {
    public static void main(String[] args, String zip) {

    }

    public static double[] getCoordinates(String zip){
        double[] result = new double[2];
        try {
            String apiKey = "bR33Arp_JhWl13UMg0tjnZmP1XgIK0L2SHYeXElR0yg"; // Replace with your Azure Maps API key
            String zipCode = "98074"; // Replace with the ZIP code you want to geocode

            String apiUrl = "https://atlas.microsoft.com/search/address/json?subscription-key=" + apiKey + "&api-version=1.0&query=" + zipCode + "&countrySet=US";

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(apiUrl)
                    .build();

            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();

            // Parse the JSON response
            JsonObject jsonResponse = JsonParser.parseString(responseBody).getAsJsonObject();
            String type = jsonResponse.get("type").getAsString();

            if (type.equals("Point")) {
                JsonObject coordinates = jsonResponse.getAsJsonObject("coordinates");
                double latitude = coordinates.get("lat").getAsDouble();
                double longitude = coordinates.get("lon").getAsDouble();

                result[0] = latitude;
                result[1] = longitude;
            } else {
                System.out.println("Geocoding failed. No results found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
