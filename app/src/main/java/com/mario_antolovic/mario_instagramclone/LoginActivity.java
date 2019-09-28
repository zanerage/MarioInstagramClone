package com.mario_antolovic.mario_instagramclone;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnlogin;
    private EditText edt_userlogin,edt_loginpass;
    private Button nextactivity;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.login_activity);
//btn login and signup
       // btnsignup = findViewById(R.id.btn_signup);
        btnlogin = findViewById(R.id.btn_login);
        nextactivity = findViewById(R.id.btn_regactivity);
//sign up

//login
        edt_userlogin = findViewById(R.id.edt_loginuser);
        edt_loginpass = findViewById(R.id.edt_loginpass);
        edt_loginpass.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode== KeyEvent.KEYCODE_ENTER && event.getAction()== KeyEvent.ACTION_DOWN) {
                    onClick(btnlogin);
                }
                return false;
            }
        });

        if (ParseUser.getCurrentUser() != null) {

            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);

        }


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
                                    FancyToast.makeText(LoginActivity.this,"You've successful logged " + user.get("username") , FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    FancyToast.makeText(LoginActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();

                                }
                            }
                        });


            }
        });
        nextactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {

    }
    public void user_tap2(View view) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
