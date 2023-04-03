package com.example.bxj214_lab4.Controller;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.view.View;

import com.example.bxj214_lab4.Model.Starship;
import com.example.bxj214_lab4.R;
import com.example.bxj214_lab4.StarshipActivity;

/**
 * MainController class which calls the starship activity
 * Implements the View.OnClickListener interface to listen for user input from the GUI
 * Is a part of the Controller class
 *
 * @author Matthew Muriel bxj214
 * UTSA CS 3443 - Lab 2
 * Spring 2023
 */
public class MainController implements View.OnClickListener{
    private final Activity activity;
    /**
     * MainController constructor method which builds the variables for the Controller class
     *
     * @param activity
     */
    public MainController(Activity activity){
        this.activity = activity;
    }

    /**
     * onClick method which instructs the app on what to do when the user interacts with the GUI
     * Buttons are hardcoded with specific starship, once pressed starshipactivity is launched
     *
     * @param view
     */
    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.button1){
            launchStarShipActivity("NCC-1701-A");
        }
        else if(view.getId() == R.id.button2){
            launchStarShipActivity("NCC-1701-D");
        }
        else if(view.getId() == R.id.button3){
            launchStarShipActivity("NCC-74656");
        }
    }

    /**
     * launchStarShipActivity method which will take a starship string and load the data from the assets folder
     *
     * @param reg
     * */
    private void launchStarShipActivity(String reg){
        Intent intent = new Intent(activity, StarshipActivity.class);
        intent.putExtra("reg", reg);
        activity.startActivity(intent);
    }

}
