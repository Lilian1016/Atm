package com.lilian.atm;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    boolean logon = false;
    public  static final int REQUEST_LOGIN=102;
    public  static final  int REQUEST_USERINFO=105;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!logon) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent, REQUEST_LOGIN);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userInfo = new Intent(MainActivity.this, UserInfoActivity.class);
                startActivityForResult(userInfo, REQUEST_USERINFO);
                //    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //           .setAction("Action", null).show();
            }
        });
        ListView ListView = (ListView) findViewById(R.id.listview);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1);
        ListView.setAdapter(adapter);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQUEST_LOGIN:
                if (resultCode == RESULT_OK) {
                    String userid = data.getStringExtra("EXRA_USERID");
                    Toast.makeText(this,"Login userid:" +userid,Toast.LENGTH_LONG).show();
                    getSharedPreferences("atm",MODE_PRIVATE)
                            .edit()
                            .putString("USERID",userid)
                            .apply();
                } else {
                    finish();
                }
                break;
            case REQUEST_USERINFO:
                if (resultCode == RESULT_OK) {
                    String edname = data.getStringExtra("EXTRA_NAME");
                    String ednum = data.getStringExtra("EXTRA_NUM");
                    Toast.makeText(this,"Name:" +edname,Toast.LENGTH_LONG).show();
                    Toast.makeText(this,"Phone: " +ednum,Toast.LENGTH_LONG).show();
                }
                break;
        }}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
