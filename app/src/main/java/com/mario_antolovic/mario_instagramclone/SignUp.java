package com.mario_antolovic.mario_instagramclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    private Button savebtn;
    private EditText edtName,edtPP,edtPS,edtKP,edtKS;

    public SignUp() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        savebtn = findViewById(R.id.btn_save);
        savebtn.setOnClickListener(SignUp.this);

        edtName = findViewById(R.id.edtName);
        edtPP= findViewById(R.id.edtPP);
        edtPS = findViewById(R.id.edtPS);
        edtKP = findViewById(R.id.edtKP);
        edtKS = findViewById(R.id.edtKS);


    }

    @Override
    public void onClick(View v) {

            final ParseObject kickboxer = new ParseObject("KickBoxer");
            kickboxer.put("Name",edtName.getText().toString());

            kickboxer.put("Punch_Power",Integer.parseInt(edtPP.getText().toString()));
            kickboxer.put("Punch_Speed",Integer.parseInt(edtPS.getText().toString()));
            kickboxer.put("Kick_Power",Integer.parseInt(edtKP.getText().toString()));
            kickboxer.put("Kick_Speed",Integer.parseInt(edtKS.getText().toString()));
            kickboxer.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        Toast.makeText(SignUp.this,kickboxer.get("Name") + " has been added to database!",Toast.LENGTH_LONG).show();
                    } else
                    {
                        Toast.makeText(SignUp.this,e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

