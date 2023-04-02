package com.example.bxj214_lab4.Controller;

import android.app.Activity;

public class StarshipController {
    private final Activity activity;
    private Fleet fleet;

    public StarshipController(Activity activity){
        this.activity = activity;
        this.fleet = new Fleet();
    }

    public void initialize(){
        fleet.loadStarship(activity.getAssets());

        update(activity.getIntent().getStringExtra("reg"));
    }

    public void update(String reg){

    }
}

