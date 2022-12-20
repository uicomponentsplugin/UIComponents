package com.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

public class Util {
    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    public static void Toast(Context context, String message, int toastLength) {
        Toast.makeText(context, message, toastLength).show();
    }

    public static String getColoredText(Context context, String text, String hexValue) {
        //String hexValue = context.getString(colorResId);
        return "<font color=" + hexValue + ">" + text + "</font>";
    }

    public static void setMargin(LinearLayout.LayoutParams layoutParams, float dimensionInDp) {
        int dimensionInDpIntValue = (int) dimensionInDp;
        layoutParams.setMargins(dimensionInDpIntValue, dimensionInDpIntValue, dimensionInDpIntValue, dimensionInDpIntValue);
    }

    public static void hideKeyboard(Context context) {
        View view = ((Activity) context).getCurrentFocus();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    public static int generateRandomInteger(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    public static boolean integerArrayContains(Integer[] array, Integer key) {
        return Arrays.asList(array).contains(key);
    }
}
