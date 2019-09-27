package com.mario_antolovic.mario_instagramclone;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SharePicture extends Fragment implements View.OnClickListener{
    private ImageView imgshare;
    private EditText edt_description;
    private Button btnshare;


    public SharePicture() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_share_picture, container, false);

        imgshare = view.findViewById(R.id.edt_shareimg);
        edt_description = view.findViewById(R.id.edt_describe);
        btnshare = view.findViewById(R.id.btn_share);

        imgshare.setOnClickListener(SharePicture.this);
        btnshare.setOnClickListener(SharePicture.this);
        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.edt_shareimg:
                if (Build.VERSION.SDK_INT >= 23 && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1000);
                } else {
                    getChosenImage();
                }
                break;
            case R.id.btn_share:
                break;
        }


    }

    private void getChosenImage() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode==1000) {
            if (grantResults.length > 0 && grantResults[0] ==
            PackageManager.PERMISSION_GRANTED) {
    getChosenImage();
            }
        }
    }
}
