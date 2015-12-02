package com.example.kuba.myapplication2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();
        setDefaults("if_connected", "Not connected", context);

        setDefaults("Device_1", "Not_connected", context);
        setDefaults("Device_2", "Connected", context);
        String value = getDefaults("Device_1", context);
        Toast toast = Toast.makeText(context, value, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void setDefaults(String key, String value, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getDefaults(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);
    }

    public void connecting(View view){
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "connecting", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        setDefaults("if_connected", "connecting", context);
    }

    public void noPermissionGrantedToast(View view){
        Context context = getApplicationContext();
        String value = getDefaults("Device_2", context);
        Toast toast = Toast.makeText(context, "Permission NOT granted", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void permissionGrantedToast(View view){
        Context context = getApplicationContext();
        String value = getDefaults("Device_2", context);
        Toast toast = Toast.makeText(context, "Permission NOT granted", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
