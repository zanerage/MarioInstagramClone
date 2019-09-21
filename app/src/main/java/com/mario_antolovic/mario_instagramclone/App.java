package com.mario_antolovic.mario_instagramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("hAU7byzxVSc14fF3h1pUv0FTgHwiE7iOyqIm6Moy")
                // if defined
                .clientKey("RNlEohu9AzPEJQ0q8kn7FVD8kRLbGfUJFyQutRp8")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
