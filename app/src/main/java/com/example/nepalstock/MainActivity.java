package com.example.nepalstock;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Swabhimaan Laghubitta Bittiya Sanstha Limited","Upper Tamakoshi Hydropower Ltd","Womi Microfinance Bittiya Sanstha Ltd.","Butwal Power Company Limited"};

    int[] image ={R.drawable.bpcl,R.drawable.sbsl,R.drawable.uthl,R.drawable.wmbsl};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyAdapter adapter = new MyAdapter(this,mTitle,image);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    Toast.makeText(MainActivity.this, "",Toast.LENGTH_SHORT).show();
                }
                if(position == 1) {
                    Toast.makeText(MainActivity.this, "",Toast.LENGTH_SHORT).show();
                }
                if(position == 2) {
                    Toast.makeText(MainActivity.this, "",Toast.LENGTH_SHORT).show();
                }
                if(position == 3) {
                    Toast.makeText(MainActivity.this, "",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        int rImgs[];

        public MyAdapter(Context c,String title[], int imgs[]) {
            super(c,R.layout.row,title);
            this.context = c;
            this.rTitle = title;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row,parent,false);
            ImageView images = row.findViewById(R.id.image);
            //TextView myTitle = row.findViewById(R.id.textView);

           images.setImageResource(rImgs[position]);


            return row;
        }
    }


}
