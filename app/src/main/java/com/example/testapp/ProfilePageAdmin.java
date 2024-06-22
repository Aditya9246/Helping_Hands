package com.example.testapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ProfilePageAdmin extends Activity {
    public static ArrayList<String> myEvents = new ArrayList<String>();
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_events_page);

        //new_events_page
        ImageButton eventsButton4 = (ImageButton) findViewById(R.id.eventsButton4);
        ImageButton profileButton4 = (ImageButton) findViewById(R.id.profileButton4);
        ImageButton settingsButton4 = (ImageButton) findViewById(R.id.settingsButton4);
        ScrollView eventsList = (ScrollView) findViewById(R.id.ScrollView);
        Button adminEvent1 = (Button) findViewById(R.id.Event1ButtonA);
        Button adminEvent2 = (Button) findViewById(R.id.Event2ButtonA);
        Button adminEvent3 = (Button) findViewById(R.id.Event3ButtonA);
        Button adminEvent4 = (Button) findViewById(R.id.Event4ButtonA);
        Button adminEvent5 = (Button) findViewById(R.id.Event5ButtonA);
        TextView adminEvent1Text = (TextView) findViewById(R.id.Event1TextA);
        TextView adminEvent2Text = (TextView) findViewById(R.id.Event2TextA);
        TextView adminEvent3Text = (TextView) findViewById(R.id.Event3TextA);
        TextView adminEvent4Text = (TextView) findViewById(R.id.Event4TextA);
        TextView adminEvent5Text = (TextView) findViewById(R.id.Event5TextA);
        ImageButton addEventButton = (ImageButton) findViewById(R.id.addEventButton);
        TextView addEventText = (TextView) findViewById(R.id.addEventText);
        TextView noEventsText = (TextView) findViewById(R.id.noEventsTextAdmin);

        profileButton4.setBackgroundColor(Color.rgb(23, 34, 77));

        if(MainActivity.currentTheUsersObj.myEvents.size() >= 1){
            noEventsText.setVisibility(View.INVISIBLE);
        }

        //eventsButton4 click event
        eventsButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilePageAdmin.this, mainPage.class);
                startActivity(intent);
            }
        });

        //settingsButton4 click event
        settingsButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilePageAdmin.this, SettingsPage.class);
                startActivity(intent);
            }
        });

        //addEventButton click event
        addEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilePageAdmin.this, CreateEvent.class);
                startActivity(intent);
            }
        });

        updateAdminEvents(adminEvent1, adminEvent2, adminEvent3, adminEvent4, adminEvent5, adminEvent1Text, adminEvent2Text, adminEvent3Text, adminEvent4Text, adminEvent5Text);
    }

    public static void updateAdminEvents(Button Event1, Button Event2, Button Event3, Button Event4, Button Event5, TextView Event1Text, TextView Event2Text, TextView Event3Text, TextView Event4Text, TextView Event5Text){
        if(MainActivity.currentTheUsersObj.myEvents.size() >= 1){
            Event1.setVisibility((View.VISIBLE));
            Event1.setClickable(true);
            Event1Text.setText("Event name: " + MainActivity.currentTheUsersObj.myEvents.get(0).getEventName() + "\n" + MainActivity.currentTheUsersObj.myEvents.get(0).getEventDescription() + "\n" + "Date: " + MainActivity.currentTheUsersObj.myEvents.get(0).getDate());
            Event1Text.setVisibility(View.VISIBLE);
        }
        if(MainActivity.currentTheUsersObj.myEvents.size() >= 2){
            Event2.setVisibility((View.VISIBLE));
            Event2.setClickable(true);
            Event2Text.setText("Event name: " + MainActivity.currentTheUsersObj.myEvents.get(1).getEventName() + "\n" + MainActivity.currentTheUsersObj.myEvents.get(1).getEventDescription() + "\n" + "Date: " + MainActivity.currentTheUsersObj.myEvents.get(1).getDate());
            Event2Text.setVisibility(View.VISIBLE);
        }
        if(MainActivity.currentTheUsersObj.myEvents.size() >= 3){
            Event3.setVisibility((View.VISIBLE));
            Event3.setClickable(true);
            Event3Text.setText("Event name: " + MainActivity.currentTheUsersObj.myEvents.get(2).getEventName() + "\n" + MainActivity.currentTheUsersObj.myEvents.get(2).getEventDescription() + "\n" + "Date: " + MainActivity.currentTheUsersObj.myEvents.get(2).getDate());
            Event3Text.setVisibility(View.VISIBLE);
        }
        if(MainActivity.currentTheUsersObj.myEvents.size() >= 4){
            Event4.setVisibility((View.VISIBLE));
            Event4.setClickable(true);
            Event4Text.setText("Event name: " + MainActivity.currentTheUsersObj.myEvents.get(3).getEventName() + "\n" + MainActivity.currentTheUsersObj.myEvents.get(3).getEventDescription() + "\n" + "Date: " + MainActivity.currentTheUsersObj.myEvents.get(3).getDate());
            Event4Text.setVisibility(View.VISIBLE);
        }
        if(MainActivity.currentTheUsersObj.myEvents.size() >= 5){
            Event5.setVisibility((View.VISIBLE));
            Event5.setClickable(true);
            Event5Text.setText("Event name: " + MainActivity.currentTheUsersObj.myEvents.get(4).getEventName() + "\n" + MainActivity.currentTheUsersObj.myEvents.get(4).getEventDescription() + "\n" + "Date: " + MainActivity.currentTheUsersObj.myEvents.get(4).getDate());
            Event5Text.setVisibility(View.VISIBLE);
        }
    }
}