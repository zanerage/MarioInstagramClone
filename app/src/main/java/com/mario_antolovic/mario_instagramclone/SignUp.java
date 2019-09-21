package com.mario_antolovic.mario_instagramclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.List;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    private Button savebtn;
    private EditText edtName,edtPP,edtPS,edtKP,edtKS;
    private TextView txt_getdata;

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

        txt_getdata = findViewById(R.id.txt_getdata);

        txt_getdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("KickBoxer");
                parseQuery.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {
                        if (e == null) {
                            if (objects.size()>0) {
                                FancyToast.makeText(SignUp.this, "Succes", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();

                            } else
                            {
                                FancyToast.makeText(SignUp.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();

                            }
                        }
                    }
                });
            }


              //  parseQuery.getInBackground("ffC3AvlgFv", new GetCallback<ParseObject>()
               // {
                   // @Override
                  //  public void done(ParseObject object, ParseException e) {
                 //    if (object != null && e == null) {
                 //        txt_getdata.setText(object.get("Name") + " - " + "Punch Power:" + object.get("Punch_Power"));

              //       }
             //       }
             //   });


        });




    }

    @Override
    public void onClick(View v) {

        try {

            final ParseObject kickboxer = new ParseObject("KickBoxer");
            kickboxer.put("Name", edtName.getText().toString());

            kickboxer.put("Punch_Power", Integer.parseInt(edtPP.getText().toString()));
            kickboxer.put("Punch_Speed", Integer.parseInt(edtPS.getText().toString()));
            kickboxer.put("Kick_Power", Integer.parseInt(edtKP.getText().toString()));
            kickboxer.put("Kick_Speed", Integer.parseInt(edtKS.getText().toString()));
            kickboxer.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        FancyToast.makeText(SignUp.this, kickboxer.get("Name") + " has been added to database!", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();


                    } else {
                        FancyToast.makeText(SignUp.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();


                    }
                }
            });
        } catch (Exception e) {
            FancyToast.makeText(SignUp.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();

        }
        }
    }

