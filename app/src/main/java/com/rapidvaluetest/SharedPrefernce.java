package com.rapidvaluetest;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefernce {

    public static boolean getBoolPreferences(String key) {
        SharedPreferences prefs = AppController.getInstance().getSharedPreferences("WED_APP",
                Context.MODE_PRIVATE);
        return prefs.getBoolean(key, false);
    }

    public static void setPreferences(String key, boolean value) {
        SharedPreferences.Editor editor = AppController.getInstance().getSharedPreferences(
                "WED_APP", Context.MODE_PRIVATE).edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

}
