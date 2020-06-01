package com.example.nepalstock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.CompanyDetailList;
import com.example.TradeDetailList;
import com.example.TradeListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Trade_detail_list extends AppCompatActivity {

    private static final String TAG = "Trade_detail_list";
    private ArrayList<Object> viewItems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade_detail_list);
        addItemsFromJSON();

    }
    private void addItemsFromJSON() {
        try {
            String jsonDataString = readJSONDataFromFile();
            JSONArray jsonArray = new JSONArray(jsonDataString);

            for (int i = 0; i < jsonArray.length(); ++i) {
                JSONObject itemObj = jsonArray.getJSONObject(i);

                String cmpName = itemObj.getString("companyName");
                String syb = itemObj.getString("symbol");
                String secName = itemObj.getString("securityName");
                String stat = itemObj.getString("status");
                String cmpEmail = itemObj.getString("companyEmail");
                String web = itemObj.getString("website");
                String sect = itemObj.getString("sector");
                String regBdy = itemObj.getString("regBody");
                String insType = itemObj.getString("instType");

                TradeDetailList tdl = new TradeDetailList(cmpName,syb,secName,stat,cmpEmail,web,sect,regBdy,insType);
                viewItems.add(tdl);
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



}
