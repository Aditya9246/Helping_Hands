package com.example.testapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.annotation.Nullable;

public class CreateEvent extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_event_page);

        Button createEventFinalButton = (Button) findViewById(R.id.createEventFinalButton);
        Button cancelButton3 = (Button) findViewById(R.id.cancelButton3);
        EditText eventNameField = (EditText) findViewById(R.id.eventNameFeild);
        EditText descriptionField = (EditText) findViewById(R.id.descriptionField);
        EditText zipCodeInput = (EditText) findViewById(R.id.NewEventZipCodeInput);
        ImageButton profileButton5 = (ImageButton) findViewById(R.id.profileButton5);
        ImageButton settingsButton5 = (ImageButton) findViewById(R.id.settingsButton5);
        ImageButton eventsButton5 = (ImageButton) findViewById(R.id.eventsButton5);
        EditText dateInput = (EditText) findViewById(R.id.editTextDate);
        Spinner dropdown = findViewById(R.id.spinner2);

        //create a list of items for the spinner.
        String[] items = new String[]{"Clean Up", "Planting", "Donation Drive"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?>arg0, View view, int arg2, long arg3) {
                String selected_val= dropdown.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

        String dropdownSelectedItem = dropdown.getSelectedItem().toString();


        profileButton5.setBackgroundColor(Color.rgb(33, 150, 243));

        //createEventFinalButton
        createEventFinalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eventName = eventNameField.getText().toString();
                String description = descriptionField.getText().toString();
                String zipCode = zipCodeInput.getText().toString();
                String date = dateInput.getText().toString();
                Events newEvent = new Events(eventName, description, MainActivity.currentTheUsersObj, zipCode, date, dropdownSelectedItem);
                theUsers.theEvents.add(newEvent);
                MainActivity.currentTheUsersObj.myEvents.add(newEvent);
                Intent intent = new Intent(CreateEvent.this, ProfilePageAdmin.class);
                startActivity(intent);
            }
        });

        //cancelButton3 click event
        cancelButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateEvent.this, ProfilePageAdmin.class);
                startActivity(intent);
            }
        });

        //eventsButton5 click event
        eventsButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateEvent.this, mainPage.class);
                startActivity(intent);
            }
        });

        //settingsButton5 click event
        settingsButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateEvent.this, SettingsPage.class);
                startActivity(intent);
            }
        });

        //profileButton5 click event
        profileButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateEvent.this, ProfilePageAdmin.class);
                startActivity(intent);
            }
        });
    }
}
