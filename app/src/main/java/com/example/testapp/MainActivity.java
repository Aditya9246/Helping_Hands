package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static String email;
    public static String password;
    public static String userType;
    public static String zipcode;
    public static theUsers currentTheUsersObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
//        Users adi = new Users("Aditya", "Pikachu123", "Student", "98074");
//        Users admin = new Users("Admin", "Admin123", "Admin", "98074");
//        usersList.add(adi);
//        usersList.add(admin);

        FirebaseApp.initializeApp(this);

        //home_page
        TextView usernameTextID = (TextView) findViewById(R.id.usernameText);
        EditText usernameEntryField = (EditText) findViewById(R.id.usernameEntry);
        EditText passwordEntryField = (EditText) findViewById(R.id.passwordEntry);
        Button loginButton = (Button) findViewById(R.id.loginButton);
        Button signUpButton = (Button) findViewById(R.id.signUpButton);
        Button cancelSignUpButton = (Button) findViewById(R.id.cancelSignUpButton);
        TextView passwordSignUpText = (TextView) findViewById(R.id.passwordSignUpText);
        TextView newUserText = (TextView) findViewById(R.id.newUserText);
        RadioButton studentRadioButton = (RadioButton) findViewById(R.id.studentRadioButton);
        RadioButton adminRadioButton = (RadioButton) findViewById(R.id.adminRadioButton);
        TextView userTypeText = (TextView) findViewById(R.id.userTypeText);
        TextView zipCodeText = (TextView) findViewById(R.id.zipCodeText);
        EditText zipCodeInput = (EditText) findViewById(R.id.zipCodeInput);


        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(signUpButton.getText().equals("Sign Up")) {
                    newUserText.setVisibility(View.INVISIBLE);
                    cancelSignUpButton.setVisibility(View.VISIBLE);
                    cancelSignUpButton.setClickable(true);
                    loginButton.setClickable(false);
                    loginButton.setVisibility(View.INVISIBLE);
                    signUpButton.setText("Create login");
                    userTypeText.setVisibility(View.VISIBLE);
                    studentRadioButton.setVisibility(View.VISIBLE);
                    studentRadioButton.setClickable(true);
                    studentRadioButton.setChecked(true);
                    adminRadioButton.setVisibility(View.VISIBLE);
                    adminRadioButton.setClickable(true);
                    adminRadioButton.setChecked(false);
                    zipCodeText.setVisibility(View.VISIBLE);
                    zipCodeInput.setVisibility(View.VISIBLE);
                    zipCodeInput.setClickable(true);
                }
                else{
                    email = usernameEntryField.getText().toString();
                    password = passwordEntryField.getText().toString();
                    zipcode = zipCodeInput.getText().toString();
                    if(studentRadioButton.isChecked()){
                        userType = "Student";
                    }
                    else{
                        userType = "Admin";
                    }
                    theUsers newTheUsers = new theUsers(email, password, userType, zipcode.toString());
                    currentTheUsersObj = newTheUsers;

                    DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("Users");

                    usersRef.child(email.substring(0, email.indexOf("@"))).setValue(newTheUsers);

                    Intent intent = new Intent(MainActivity.this, mainPage.class);
                    startActivity(intent);
                }
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = usernameEntryField.getText().toString();
                password = passwordEntryField.getText().toString();
                String userName = email.substring(0, email.indexOf("@"));

                DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("Users").child(userName);
                usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            theUsers user = dataSnapshot.getValue(theUsers.class);
                            // Use the user's data
                            if(user.getPassword().equals(password)){
                                currentTheUsersObj = user;
                                Intent intent = new Intent(MainActivity.this, mainPage.class);
                                startActivity(intent);
                            }
                        } else {
                            // User data does not exist
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle any errors
                    }
                });
            }
        });
        cancelSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newUserText.setVisibility(View.VISIBLE);
                loginButton.setVisibility(View.VISIBLE);
                loginButton.setClickable(true);
                signUpButton.setText("Sign Up");
                userTypeText.setVisibility(View.INVISIBLE);
                studentRadioButton.setVisibility(View.INVISIBLE);
                studentRadioButton.setClickable(false);
                adminRadioButton.setVisibility(View.INVISIBLE);
                adminRadioButton.setClickable(false);
                cancelSignUpButton.setVisibility(View.INVISIBLE);
                cancelSignUpButton.setClickable(false);
                zipCodeText.setVisibility(View.INVISIBLE);
                zipCodeInput.setClickable(false);
                zipCodeText.setVisibility(View.INVISIBLE);
                zipCodeInput.setVisibility(View.INVISIBLE);
            }
        });

        studentRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(studentRadioButton.isChecked()){
                    adminRadioButton.setChecked(false);
                }
                else{
                    adminRadioButton.setChecked(true);
                }
            }
        });

        adminRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adminRadioButton.isChecked()){
                    studentRadioButton.setChecked(false);
                }
                else{
                    studentRadioButton.setChecked(true);
                }
            }
        });
    }

}