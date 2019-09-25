package com.mario_antolovic.mario_instagramclone;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Profile extends Fragment {
    private EditText edtProfileName,edtProfileBio,edtProfileProff,edtProfileHobbies,edtProfilefavsport;
    private Button btnUpdate;


    public Profile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);
        edtProfileName = view.findViewById(R.id.txt_profile);
        edtProfileBio = view.findViewById(R.id.txt_bio);
        edtProfileProff = view.findViewById(R.id.txt_profy);
        edtProfileHobbies = view.findViewById(R.id.txt_hobbie);
        edtProfilefavsport = view.findViewById(R.id.txt_favsport);
        //button
        btnUpdate = view.findViewById(R.id.btn_update);
        //parse bk4app

        final ParseUser parseUser = ParseUser.getCurrentUser();
// i tried .equals instead of == // but it compare context not objects
        if (parseUser.get("profileName")==null) {
            edtProfileName.setText("");
            if (parseUser.get("profileBio")==null) {
                edtProfileBio.setText("");
            }
            if (parseUser.get("profileProff")==null) {
                edtProfileProff.setText("");
            }
            if (parseUser.get("profileHobbie")==null) {
                edtProfileHobbies.setText("");
            }
            if (parseUser.get("profileFavSport")==null) {
                edtProfilefavsport.setText("");
            }
        } else {
            edtProfileName.setText(parseUser.get("profileName").toString());
            edtProfileBio.setText(parseUser.get("profileBio").toString());
            edtProfileProff.setText(parseUser.get("profileProff").toString());
            edtProfileHobbies.setText(parseUser.get("profileHobbie").toString());
            edtProfilefavsport.setText(parseUser.get("profileFavSport").toString());


        }

// toString will crash app so had to use empty string



        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseUser.put("profileName",edtProfileName.getText().toString());
                parseUser.put("profileBio",edtProfileBio.getText().toString());
                parseUser.put("profileProff",edtProfileProff.getText().toString());
                parseUser.put("profileHobbie",edtProfileHobbies.getText().toString());
                parseUser.put("profileFavSport",edtProfilefavsport.getText().toString());

                parseUser.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            FancyToast.makeText(getContext(),"Info is Updated", FancyToast.LENGTH_SHORT, FancyToast.INFO, true).show();

                        }  else {
                            FancyToast.makeText(getContext(),e.getMessage(), FancyToast.LENGTH_SHORT, FancyToast.ERROR, true).show();

                        }
                    }
                });
            }
        });

        return view;

    }

}
