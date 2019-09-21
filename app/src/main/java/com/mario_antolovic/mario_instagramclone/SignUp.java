package com.mario_antolovic.mario_instagramclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }
    public void helloworldp(View view) {
        ParseObject boxer = new ParseObject("Boxer");
        boxer.put("Punch_Power",200);
        boxer.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(SignUp.this,"Boxer object is saved!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void kickboxer(View view) {
        ParseObject kickboxer = new ParseObject("KickBoxer");
        kickboxer.put("Name","Mario");
        kickboxer.put("Country","Country");
        kickboxer.put("Punch_Power",150);
        kickboxer.put("Punch_Speed",350);
        kickboxer.put("Kick_Power",250);
        kickboxer.put("Kick_Speed",400);
        kickboxer.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(SignUp.this,"Kickboxer Info has been added to database!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
