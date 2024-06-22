package com.example.testapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class SettingsPage extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        //settings
        ImageButton eventsButton3 = (ImageButton) findViewById(R.id.eventsButton3);
        ImageButton profileButton3 = (ImageButton) findViewById(R.id.profileButton3);
        ImageButton settingsButton3 = (ImageButton) findViewById(R.id.settingsButton3);
        Button updateUsernameButton = (Button) findViewById(R.id.updateUsernameButton);
        Button updatePasswordButton = (Button) findViewById(R.id.updatePasswordButton);
        Button confirmButton1 = (Button) findViewById(R.id.confirmButton1);
        Button cancelButton1 = (Button) findViewById(R.id.cancelButton1);
        Button confirmButton2 = (Button) findViewById(R.id.confirmButton2);
        Button cancelButton2 = (Button) findViewById(R.id.cancelButton2);
        Button signOutButton = (Button) findViewById(R.id.signOutButton);
        EditText updateUsernameField = (EditText) findViewById(R.id.updateUsernameField);
        EditText updatePasswordField = (EditText) findViewById(R.id.updatePasswordField);

        settingsButton3.setBackgroundColor(Color.rgb(23, 34, 77));


        //eventsButton3 click event
        eventsButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsPage.this, mainPage.class);
                startActivity(intent);
            }
        });
        //profileButton3 click event
        profileButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(MainActivity.currentTheUsersObj.getUserType().equals("Student")) {
                    Intent intent = new Intent(SettingsPage.this, ProfilePage.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(SettingsPage.this, ProfilePageAdmin.class);
                    startActivity(intent);
                }
            }
        });


        //signOutButton click event
        signOutButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(SettingsPage.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //updateUsernameButton click event
        updateUsernameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUsernameField.setVisibility(View.VISIBLE);
                updateUsernameField.setClickable(true);
                confirmButton1.setVisibility(View.VISIBLE);
                confirmButton1.setClickable(true);
                cancelButton1.setVisibility(View.VISIBLE);
                cancelButton1.setClickable(true);
                updateUsernameButton.setVisibility(View.INVISIBLE);
                updateUsernameButton.setClickable(false);
            }
        });

        //updatePasswordButton click event
        updatePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePasswordField.setVisibility(View.VISIBLE);
                updatePasswordField.setClickable(true);
                confirmButton2.setVisibility(View.VISIBLE);
                confirmButton2.setClickable(true);
                cancelButton2.setVisibility(View.VISIBLE);
                cancelButton2.setClickable(true);
                updatePasswordButton.setVisibility(View.INVISIBLE);
                updatePasswordButton.setClickable(false);
            }
        });

        //cancelButton1 click event
        cancelButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                updateUsernameField.setVisibility(View.INVISIBLE);
                updateUsernameField.setClickable(false);
                confirmButton1.setVisibility(View.INVISIBLE);
                confirmButton1.setClickable(false);
                updateUsernameButton.setVisibility(View.VISIBLE);
                updateUsernameButton.setClickable(true);
                cancelButton1.setVisibility(View.INVISIBLE);
                cancelButton1.setClickable(false);
            }
        });

        //cancelButton2 click event
        cancelButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                updatePasswordField.setVisibility(View.INVISIBLE);
                updatePasswordField.setClickable(false);
                confirmButton2.setVisibility(View.INVISIBLE);
                confirmButton2.setClickable(false);
                updatePasswordButton.setVisibility(View.VISIBLE);
                updatePasswordButton.setClickable(true);
                cancelButton2.setVisibility(View.INVISIBLE);
                cancelButton2.setClickable(false);
            }
        });

        //confirmButton1 click event
        confirmButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newUsername = updateUsernameField.getText().toString();
                MainActivity.currentTheUsersObj.updateEmail(newUsername);
            }
        });

        //confirmButton2 click event
        confirmButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newPassword = updatePasswordField.getText().toString();
                MainActivity.currentTheUsersObj.updatePassword(newPassword);
            }
        });
    }
}
