package com.mario_antolovic.mario_instagramclone;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUpLoginActivity extends AppCompatActivity {

    private Button btnlogin;
    private EditText edt_userlogin,edt_loginpass;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.signup_login_activity);
//btn login and signup
       // btnsignup = findViewById(R.id.btn_signup);
        btnlogin = findViewById(R.id.btn_login);
//sign up

//login
        edt_userlogin = findViewById(R.id.edt_loginuser);
        edt_loginpass = findViewById(R.id.edt_loginpass);

//initiliaze buttons

//loginuser
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseUser.logInInBackground(edt_userlogin.getText().toString(), edt_loginpass.getText().toString(),
                        new LogInCallback() {
                            @Override
                            public void done(ParseUser user, ParseException e) {
                                if (user !=null && e ==null) {
                                    FancyToast.makeText(SignUpLoginActivity.this,"You've successful logged " + user.get("username") , FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                                    Intent intent = new Intent(SignUpLoginActivity.this,HomeActivity.class);
                                    startActivity(intent);
                                } else {
                                    FancyToast.makeText(SignUpLoginActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();

                                }
                            }
                        });


            }
        });

    }
}
