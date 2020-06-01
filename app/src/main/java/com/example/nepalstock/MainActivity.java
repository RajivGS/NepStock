package com.example.nepalstock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.CompanyDetailList;
import com.example.HomeFragment;
import com.example.NotificationFragment;
import com.example.PlusFragment;
import com.example.SettingFragment;
import com.example.ViewFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;
    private HomeFragment homeFragment;
    private NotificationFragment notificationFragment;
    private ViewFragment viewFragment;
    private PlusFragment plusFragment;
    private SettingFragment settingFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navBarFunction();
        displayListFiles();
    }
    private void displayListFiles() {
        button = (Button) findViewById(R.id.showListButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display_list_activity();
            }
        });
    }
    public void Display_list_activity() {
        Intent intent = new Intent(this,Display_list_activity.class);
        startActivity(intent);
        }

    public void navBarFunction() {
        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        homeFragment = new HomeFragment();
        notificationFragment = new NotificationFragment();
        viewFragment = new ViewFragment();
        plusFragment = new PlusFragment();
        settingFragment = new SettingFragment();

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.nav_home:     // This should open up the home fragment and color
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(homeFragment);
                        return true;

                    case R.id.nav_list:
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(viewFragment);
                        return true;

                    case R.id.nav_add:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(plusFragment);
                        return true;

                    case R.id.nav_notif:
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(notificationFragment);
                        return true;

                    case R.id.nav_setting:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(settingFragment);
                        return true;
                    default:
                        return false;
                }
            }

            protected void setFragment(Fragment fragment) {

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frame, fragment);
                fragmentTransaction.commit();

            }

        });


    }

}
