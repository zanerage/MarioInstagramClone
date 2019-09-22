package com.mario_antolovic.mario_instagramclone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseUser;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {

    private Button btnlogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView txtwelcome = findViewById(R.id.txt_welcome);
        btnlogout = findViewById(R.id.btn_logout);


        txtwelcome.setText("Welcome " + ParseUser.getCurrentUser().get("username"));

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SignUpLoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
