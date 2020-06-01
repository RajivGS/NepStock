package com.example.nepalstock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.CompanyDetailList;
import com.example.OnDetailList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Display_list_activity extends AppCompatActivity implements OnDetailList {

    private RecyclerView mRecyclerView;
    private List<Object> viewItems = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private static final String TAG = "Display_list_activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_activity);
        setUpRecyclerView();
        addItemsFromJSON();
    }
    private void setUpRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new RecyclerAdapter(this, viewItems,this);
        mRecyclerView.setAdapter(mAdapter);
    }
    private void addItemsFromJSON() {
        try {
            String jsonDataString = readJSONDataFromFile();
            JSONArray jsonArray = new JSONArray(jsonDataString);

            for (int i = 0; i < jsonArray.length(); ++i) {
                JSONObject itemObj = jsonArray.getJSONObject(i);
                String name = itemObj.getString("companyName");
                CompanyDetailList holidays = new CompanyDetailList(name);
                viewItems.add(holidays);
            }
        } catch (IOException | JSONException e) {
            Log.d(TAG, "addItemsFromJSON: ", e);
        }
    }
    private String readJSONDataFromFile() throws IOException {

        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();

        try {
            String jsonString = null;
            inputStream = getResources().openRawResource(R.raw.companies);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream, "UTF-8"));

            while ((jsonString = bufferedReader.readLine()) != null) {
                builder.append(jsonString);
            }

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return new String(builder);
    }

    @Override
    public void onItemClickDetail(int position) {
        viewItems.get(position);
        TextView textview  = findViewById(R.id.companyName);

        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Trade_detail_list();
            }
        });
    }
    private void Trade_detail_list() {
        Intent intent = new Intent(Display_list_activity.this,Trade_detail_list.class);
        startActivity(intent);

    }
}

