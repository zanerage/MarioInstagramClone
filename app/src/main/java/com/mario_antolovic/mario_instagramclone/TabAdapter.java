package com.mario_antolovic.mario_instagramclone;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {


    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int tabPosition) {
        switch (tabPosition) {
            case 0:
                Profile profiletab = new Profile();
                return profiletab;

            case 1:
                Users userstab = new Users();
                return  userstab;
            case 2:
                SharePicture sharePicturetab = new SharePicture();
                return sharePicturetab;
                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
       switch (position) {
           case 0:
               return "Profile";
           case 1:
               return "Users";
           case 2:
               return "Share Picture";

               default:
                   return null;
       }
    }
}
