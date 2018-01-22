package com.example.tomasz.mobileschoolregister.helper;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;

import com.example.tomasz.mobileschoolregister.LoginActivity;

/**
 * Created by Tomasz on 22-Jan-18.
 */

public class Logout {
    public static void Logout(Activity activity){
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }
}
