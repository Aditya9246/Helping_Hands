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

public class ProfilePage extends Activity {

    public static Events selectedEvent;
    public static boolean a = false;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        a=false;

        //profile
        ImageButton eventsButton2 = (ImageButton) findViewById(R.id.eventsButton2);
        ImageButton profileButton2 = (ImageButton) findViewById(R.id.profileButton2);
        ImageButton settingsButton2 = (ImageButton) findViewById(R.id.settingsButton2);
        Button Event1 = (Button) findViewById(R.id.Event1ButtonU);
        Button Event2 = (Button) findViewById(R.id.Event2ButtonU);
        Button Event3 = (Button) findViewById(R.id.Event3ButtonU);
        Button Event4 = (Button) findViewById(R.id.Event4ButtonU);
        Button Event5 = (Button) findViewById(R.id.Event5ButtonU);
        TextView Event1Text = (TextView) findViewById(R.id.Event1TextU);
        TextView Event2Text = (TextView) findViewById(R.id.Event2TextU);
        TextView Event3Text = (TextView) findViewById(R.id.Event3TextU);
        TextView Event4Text = (TextView) findViewById(R.id.Event4TextU);
        TextView Event5Text = (TextView) findViewById(R.id.Event5TextU);

        ScrollView eventsList = (ScrollView) findViewById(R.id.ScrollView);

        profileButton2.setBackgroundColor(Color.rgb(23, 34, 77));

        updateEvents(Event1, Event2, Event3, Event4, Event5, Event1Text, Event2Text, Event3Text, Event4Text, Event5Text);

        //eventsButton2 click event
        eventsButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilePage.this, mainPage.class);
                startActivity(intent);
            }
        });

        //settingsButton click event
        settingsButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent = new Intent(ProfilePage.this, SettingsPage.class);
                startActivity(intent);
            }
        });

        //Event1 click event
        Event1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = true;
                selectedEvent = MainActivity.currentTheUsersObj.myEvents.get(0);
                Intent intent = new Intent(ProfilePage.this, EventSignUp.class);
                startActivity(intent);
            }
        });

        //Event2 click event
        Event2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = true;
                selectedEvent = MainActivity.currentTheUsersObj.myEvents.get(1);
                Intent intent = new Intent(ProfilePage.this, EventSignUp.class);
                startActivity(intent);
            }
        });

        //Event3 click event
        Event3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = true;
                selectedEvent = MainActivity.currentTheUsersObj.myEvents.get(2);
                Intent intent = new Intent(ProfilePage.this, EventSignUp.class);
                startActivity(intent);
            }
        });

        //Event4 click event
        Event4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = true;
                selectedEvent = MainActivity.currentTheUsersObj.myEvents.get(3);
                Intent intent = new Intent(ProfilePage.this, EventSignUp.class);
                startActivity(intent);
            }
        });

        //Event5 click event
        Event5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = true;
                selectedEvent = MainActivity.currentTheUsersObj.myEvents.get(4);
                Intent intent = new Intent(ProfilePage.this, EventSignUp.class);
                startActivity(intent);
            }
        });
    }

    public static void updateEvents(Button Event1, Button Event2, Button Event3, Button Event4, Button Event5, TextView Event1Text, TextView Event2Text, TextView Event3Text, TextView Event4Text, TextView Event5Text){
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
