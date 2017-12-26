package com.lilian.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AreaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String[] areas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        ListView area = (ListView) findViewById(R.id.area);
        Intent intent =getIntent();
        int position = intent.getIntExtra("CITY_EXTRA",0);
        if(position ==0) {
            areas =new String[]{"中正區","暖暖區","八堵區"};
        }
        if(position==1) {
            areas =new String[]{"永和區","板橋區","新莊區"};
        }
        if(position==2){
            areas =new String[]{"信義區","大安區","士林區"};
        }

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,areas);
        area.setAdapter(adapter);
        area.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

    }
}
