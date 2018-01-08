package com.lilian.atm;

import android.icu.text.StringPrepParseException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import static com.lilian.atm.R.id.spinner;

public class AddrActivity extends AppCompatActivity {

    private Spinner spCity;
    private Spinner spArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addr);
        spCity = (Spinner) findViewById(R.id.sp_city);
        spArea = (Spinner)findViewById(R.id.sp_area);
        final String[]data = {"基隆市","新北市","台北市"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,data);
        spCity.setAdapter(adapter);
        spCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int
                    position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
