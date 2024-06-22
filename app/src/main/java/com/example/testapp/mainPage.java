package com.example.testapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.example.testapp.databinding.ActivityMainBinding;

import org.w3c.dom.Text;

public class mainPage extends Activity {
    public static Events selectedEvent;
    public static boolean a = false;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        a=false;

        //main_page
        ScrollView eventsList = (ScrollView) findViewById(R.id.ScrollView);
        TextView welcomeMessage = (TextView) findViewById(R.id.welcomeText);
        ImageButton eventsButton = (ImageButton) findViewById(R.id.eventsButton);
        ImageButton profileButton = (ImageButton) findViewById(R.id.profileButton);
        ImageButton settingsButton = (ImageButton) findViewById(R.id.settingsButton);
        Button Event1 = (Button) findViewById(R.id.Event1Button);
        Button Event2 = (Button) findViewById(R.id.Event2Button);
        Button Event3 = (Button) findViewById(R.id.Event3Button);
        Button Event4 = (Button) findViewById(R.id.Event4Button);
        Button Event5 = (Button) findViewById(R.id.Event5Button);
        TextView Event1Text = (TextView) findViewById(R.id.Event1Text);
        TextView Event2Text = (TextView) findViewById(R.id.Event2Text);
        TextView Event3Text = (TextView) findViewById(R.id.Event3Text);
        TextView Event4Text = (TextView) findViewById(R.id.Event4Text);
        TextView Event5Text = (TextView) findViewById(R.id.Event5Text);
        ImageView blueBar = (ImageView) findViewById(R.id.solidBar);


        Spinner dropdown = findViewById(R.id.spinner1);

        eventsButton.setBackgroundColor(Color.rgb(23, 34, 77));
        blueBar.setVisibility(View.VISIBLE);


        //create a list of items for the spinner.
        String[] items = new String[]{"All", "Clean Up", "Planting", "Donation Drive"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?>arg0, View view, int arg2, long arg3) {

                String selected_val= dropdown.getSelectedItem().toString();
                MainActivity.currentTheUsersObj.filterEvents(selected_val);
                updateEvents(Event1, Event2, Event3, Event4, Event5, Event1Text, Event2Text, Event3Text, Event4Text, Event5Text);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

        MainActivity.currentTheUsersObj.filterEvents(dropdown.getSelectedItem().toString());

        MainActivity.currentTheUsersObj.distanceSorter();

        String theEmail = MainActivity.email;
        String userName = theEmail.substring(0, theEmail.indexOf("@"));

        welcomeMessage.setText("Welcome " + userName + ",");
        updateEvents(Event1, Event2, Event3, Event4, Event5, Event1Text, Event2Text, Event3Text, Event4Text, Event5Text);




        //profileButton click event
        profileButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                if(MainActivity.currentTheUsersObj.getUserType().equals("Student")) {
                    Intent intent = new Intent(mainPage.this, ProfilePage.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(mainPage.this, ProfilePageAdmin.class);
                    startActivity(intent);
                }
            }
        });

        //settingsButton click event
        settingsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent = new Intent(mainPage.this, SettingsPage.class);
                startActivity(intent);
            }
        });

        //Event1 click event
        Event1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=true;
                selectedEvent = MainActivity.currentTheUsersObj.eventsToBeDisplayed.get(0);
                Intent intent = new Intent(mainPage.this, EventSignUp.class);
                startActivity(intent);
            }
        });

        //Event2 click event
        Event2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=true;
                selectedEvent = MainActivity.currentTheUsersObj.eventsToBeDisplayed.get(1);
                Intent intent = new Intent(mainPage.this, EventSignUp.class);
                startActivity(intent);
            }
        });

        //Event3 click event
        Event3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=true;
                selectedEvent = MainActivity.currentTheUsersObj.eventsToBeDisplayed.get(2);
                Intent intent = new Intent(mainPage.this, EventSignUp.class);
                startActivity(intent);
            }
        });

        //Event4 click event
        Event4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=true;
                selectedEvent = MainActivity.currentTheUsersObj.eventsToBeDisplayed.get(3);
                Intent intent = new Intent(mainPage.this, EventSignUp.class);
                startActivity(intent);
            }
        });

        //Event5 click event
        Event5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=true;
                selectedEvent = MainActivity.currentTheUsersObj.eventsToBeDisplayed.get(4);
                Intent intent = new Intent(mainPage.this, EventSignUp.class);
                startActivity(intent);
            }
        });

    }
    public static void updateEvents(Button Event1, Button Event2, Button Event3, Button Event4, Button Event5, TextView Event1Text, TextView Event2Text, TextView Event3Text, TextView Event4Text, TextView Event5Text){
        if(MainActivity.currentTheUsersObj.eventsToBeDisplayed.size() >= 1){
            Event1.setVisibility((View.VISIBLE));
            Event1.setClickable(true);
            Event1Text.setText("Event name: " + MainActivity.currentTheUsersObj.eventsToBeDisplayed.get(0).getEventName() + "\n" + theUsers.theEvents.get(0).getEventDescription() + "\n" + "Date: " + theUsers.theEvents.get(0).getDate());
            Event1Text.setVisibility(View.VISIBLE);
        }
        if(MainActivity.currentTheUsersObj.eventsToBeDisplayed.size() >= 2){
            Event2.setVisibility((View.VISIBLE));
            Event2.setClickable(true);
            Event2Text.setText("Event name: " + MainActivity.currentTheUsersObj.eventsToBeDisplayed.get(1).getEventName() + "\n" + theUsers.theEvents.get(1).getEventDescription() + "\n" + "Date: " + theUsers.theEvents.get(1).getDate());
            Event2Text.setVisibility(View.VISIBLE);
        }
        if(MainActivity.currentTheUsersObj.eventsToBeDisplayed.size() >= 3){
            Event3.setVisibility((View.VISIBLE));
            Event3.setClickable(true);
            Event3Text.setText("Event name: " + MainActivity.currentTheUsersObj.eventsToBeDisplayed.get(2).getEventName() + "\n" + theUsers.theEvents.get(2).getEventDescription() + "\n" + "Date: " + theUsers.theEvents.get(2).getDate());
            Event3Text.setVisibility(View.VISIBLE);
        }
        if(MainActivity.currentTheUsersObj.eventsToBeDisplayed.size() >= 4){
            Event4.setVisibility((View.VISIBLE));
            Event4.setClickable(true);
            Event4Text.setText("Event name: " + MainActivity.currentTheUsersObj.eventsToBeDisplayed.get(3).getEventName() + "\n" + theUsers.theEvents.get(3).getEventDescription() + "\n" + "Date: " + theUsers.theEvents.get(3).getDate());
            Event4Text.setVisibility(View.VISIBLE);
        }
        if(MainActivity.currentTheUsersObj.eventsToBeDisplayed.size() >= 5){
            Event5.setVisibility((View.VISIBLE));
            Event5.setClickable(true);
            Event5Text.setText("Event name: " + MainActivity.currentTheUsersObj.eventsToBeDisplayed.get(4).getEventName() + "\n" + theUsers.theEvents.get(4).getEventDescription() + "\n" + "Date: " + theUsers.theEvents.get(4).getDate());
            Event5Text.setVisibility(View.VISIBLE);
        }
    }
}