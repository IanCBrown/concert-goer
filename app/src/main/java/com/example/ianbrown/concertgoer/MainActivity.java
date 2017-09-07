package com.example.ianbrown.concertgoer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    String[] defaultBandNames = {"Band", "names", "go", "here"};
    ListView lv;

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    private EditText txtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listView);
        registerForContextMenu(lv);

        arrayList = new ArrayList<>(Arrays.asList(defaultBandNames));

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList);
        lv.setAdapter(adapter);

        txtInput = (EditText) findViewById(R.id.editText);

        Button b = (Button) findViewById(R.id.button);

        //TODO Create method for band name validation

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> defaultBandNamesList = new ArrayList<>(Arrays.asList(defaultBandNames));
                addBandsToList(defaultBandNamesList, txtInput);
             }
        });

        txtInput.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                ArrayList<String> defaultBandNamesList = new ArrayList<>(Arrays.asList(defaultBandNames));
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    addBandsToList(defaultBandNamesList, txtInput);
                    return true;
                }
                return false;
            }
        });
    }

    public void addBandsToList(ArrayList<String> defaultBandNamesList, EditText txtInput) {
        if (defaultBandNamesList.equals(arrayList)) {
            arrayList.clear();
        }
        else if (!txtInput.getText().toString().isEmpty()) {
            String newBand = txtInput.getText().toString();
            adapter.add(newBand);
            txtInput.getText().clear();
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.edit:
                //edit();
                Toast.makeText(this, "Placeholder", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.delete:
                delete(info);
                Toast.makeText(this, R.string.item_removed, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.delete_all:
                deleteAll();
                Toast.makeText(this, R.string.list_cleared, Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void delete(AdapterView.AdapterContextMenuInfo info) {
        adapter.remove(adapter.getItem(info.position));
    }

    public void deleteAll() {
        adapter.clear();
    }

    public void edit(AdapterView.AdapterContextMenuInfo info) {
        //TODO add proper edit functionality
    }
}
