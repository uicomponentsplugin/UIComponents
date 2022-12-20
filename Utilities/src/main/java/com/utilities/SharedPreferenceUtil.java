package com.utilities;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class SharedPreferenceUtil {
    public static void saveStringLocal(Context context, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(key, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }
    public static void saveIntLocal(Context context, String key, int value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(key, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static void saveBooleanLocal(Context context, String key, boolean value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(key, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static String getStringLocal(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(key, MODE_PRIVATE);
        return sharedPreferences.getString(key, null);
    }

    public static boolean getBooleanLocal(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(key, MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, false);
    }

    public static long getLongLocal(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(key, MODE_PRIVATE);
        return sharedPreferences.getLong(key, 0);
    }

    public static int getIntLocal(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(key, MODE_PRIVATE);
        return sharedPreferences.getInt(key, 0);

    }
}
