package com.example.newapp;

import static com.example.newapp.R.*;
import static com.example.newapp.R.array.*;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;

import java.lang.reflect.Array;

public  class SettingsActivity extends AppCompatActivity {
String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.settings_activity);

//            SharedPreferences sp=getSharedPreferences("KeyValue",MODE_PRIVATE);
//            SharedPreferences.Editor editor = sp.edit();
//            editor.putString("reply",value);
//            editor.apply();
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(id.settings, new SettingsFragment())
                    .commit();
        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                startActivity(new Intent(this,MainActivity.class));
                onBackPressed();
//                Toast.makeText(this, "lollllllllllllllll", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



    public void onBackPressed() {

        Intent intent = new Intent(this,
                MainActivity.class);
        startActivity(intent);

        return;
    }
    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(xml.root_preferences , rootKey);

//             value=getPreferenceManager().getSharedPreferences().toString();
        }
    }

}