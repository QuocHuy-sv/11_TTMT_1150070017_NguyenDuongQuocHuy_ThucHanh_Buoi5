package com.example.nguyenduongquochuylab3.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;

public class OrientationHelper {
    private static final String PREF = "rotate_pref";
    private static final String KEY_ALLOW = "allow_rotate";

    public static boolean isAllowed(Context ctx) {
        return ctx.getSharedPreferences(PREF, Context.MODE_PRIVATE).getBoolean(KEY_ALLOW, true);
    }

    public static void setAllowed(Context ctx, boolean allow) {
        SharedPreferences sp = ctx.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        sp.edit().putBoolean(KEY_ALLOW, allow).apply();
    }

    public static void apply(Activity act) {
        if (isAllowed(act)) {
            act.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        } else {
            act.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }
}
