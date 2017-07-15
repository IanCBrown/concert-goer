package com.example.ianbrown.concertgoer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    String[] defaultBandNames = {"Band", "names", "would", "go", "here"};
    ListView lv;

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    private EditText txtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listView);


        arrayList = new ArrayList<>(Arrays.asList(defaultBandNames));

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList);
        lv.setAdapter(adapter);

        txtInput = (EditText) findViewById(R.id.editText);

        Button b = (Button) findViewById(R.id.button);

        //TODO Create method for band name validation

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sketchy hard coding incoming, don't cringe
                ArrayList<String> defaultBandNamesList = new ArrayList<>(Arrays.asList(defaultBandNames));
                if (defaultBandNamesList.equals(arrayList)) {
                    arrayList.clear();
                }
                else if (!txtInput.getText().toString().isEmpty()) {
                    String newBand = txtInput.getText().toString();
                    adapter.add(newBand);
                    txtInput.getText().clear();
                }
        }
        });

        txtInput.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //sketchy hard coding incoming, don't cringe
                ArrayList<String> defaultBandNamesList = new ArrayList<>(Arrays.asList(defaultBandNames));
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    if (defaultBandNamesList.equals(arrayList)) {
                        arrayList.clear();
                    }
                    else if (!txtInput.getText().toString().isEmpty()) {
                        String newBand = txtInput.getText().toString();
                        adapter.add(newBand);
                        txtInput.getText().clear();
                    }
                    return true;
                }
                return false;
            }
        });
    }
}
