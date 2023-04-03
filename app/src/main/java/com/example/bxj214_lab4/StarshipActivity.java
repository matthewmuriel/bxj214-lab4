package com.example.bxj214_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bxj214_lab4.Controller.StarshipController;
/**
 * StarShipActivity class which shows the activity_starship.xml to the user
 * invokes the MainController class to receive, interpret, & update the model class
 *
 * @author Matthew Muriel bxj214
 * UTSA CS 3443 - Lab 4
 * Spring 2023
 */

public class StarshipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starship);

        StarshipController controller = new StarshipController(this);
        controller.initialize();
    }
}