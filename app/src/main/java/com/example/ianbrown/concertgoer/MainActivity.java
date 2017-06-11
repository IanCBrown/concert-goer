package com.example.ianbrown.concertgoer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    ListView lv;
    public String[] defaultBandNames = {"Band", "names", "would", "go", "here"};
    public String[] userBandNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.idListView);

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, defaultBandNames);
        lv.setAdapter(adapter);

    }
}
