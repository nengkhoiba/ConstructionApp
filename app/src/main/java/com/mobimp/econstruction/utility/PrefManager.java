package com.mobimp.econstruction.utility;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Lincoln on 05/05/16.
 */
public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences constants
    private static final String PREF_NAME = "SolidWastePref";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String LOGIN = "Login";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return true; //pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public void setLoginDetails(String name, String profile_url, String email, String id, String token){
        editor.putBoolean(LOGIN,true);
        editor.commit();
        editor.putString(LOGIN+"name",name);
        editor.commit();
        editor.putString(LOGIN+"profile_url",profile_url);
        editor.commit();
        editor.putString(LOGIN+"email",email);
        editor.commit();
        editor.putString(LOGIN+"id",id);
        editor.commit();
        editor.putString(LOGIN+"token",token);
        editor.commit();
    }
    public void setLogout(){
        editor.putBoolean(LOGIN,false);
        editor.commit();

    }
    public String getDataFromPref(String keycode) {
        SharedPreferences prefs = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        String restoredText = prefs.getString(keycode, null);
        return restoredText;
    }
    public Boolean getBoolDataFromPref(String keycode) {
        SharedPreferences prefs = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        Boolean restoredText = prefs.getBoolean(keycode, false);
        return restoredText;
    }

}
