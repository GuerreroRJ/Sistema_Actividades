package com.example.appgcm.Util;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.appgcm.R;


public class NavigationFragment {


    public static void addFragment(Bundle args, Fragment newFragment, String tag,
                                   Fragment oldFragment, int containerView, boolean backStack,
                                   CustomAnimation customAnimation)
    {
        if(!newFragment.isVisible()) {
            if (args != null) newFragment.setArguments(args);
            FragmentManager fragmentManager = oldFragment.getFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            switch (customAnimation) {
                case LEFT_RIGHT:
                    ft.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter,
                            R.anim.pop_exit);
                    break;
                case IN_OUT:
                    ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                    break;
                case RIGTH_LEFT:
                    ft.setCustomAnimations(R.anim.exit, R.anim.enter, R.anim.pop_enter,
                            R.anim.pop_exit);
            }

            ft.replace(containerView, newFragment, tag);
            if (backStack) {
                ft.addToBackStack("oldFragment");
            }
            ft.commit();
        }
    }
    public static void addFragment(Bundle args, Fragment newFragment, String tag,
                                   FragmentActivity fragmentActivity, int containerView,
                                   boolean backStack, CustomAnimation customAnimation)
    {
        if(!newFragment.isVisible()) {
            if (args != null) newFragment.setArguments(args);
            FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            switch (customAnimation) {
                case LEFT_RIGHT:
                    ft.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter,
                            R.anim.pop_exit);
                    break;
                case IN_OUT:
                    ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                    break;
            }
            ft.replace(containerView, newFragment, tag);
            if (backStack) {
                ft.addToBackStack("oldFragment");
            }
            ft.commit();
        }
    }
}
