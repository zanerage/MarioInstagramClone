package com.mario_antolovic.mario_instagramclone;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseUser;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {

      private android.support.v7.widget.Toolbar toolbar;
      private ViewPager viewPager;
      private TabLayout tabLayout;
      private TabAdapter tabAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setTitle("Mario Insta Clone");

        toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.viewPager);
        tabAdapter = new TabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabAdapter);

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager,false);


    }
}
