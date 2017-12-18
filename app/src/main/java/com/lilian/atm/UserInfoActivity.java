package com.lilian.atm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UserInfoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        EditText edName = (EditText)findViewById(R.id.edname);
        EditText edNum = (EditText)findViewById(R.id.ednum);
        SharedPreferences setting =
                getSharedPreferences("atm",MODE_PRIVATE);
        edName.setText(setting.getString("PREF_NAME",""));
        edNum.setText(setting.getString("PREF_NUMBER",""));

    }

    public void ok(View view){
        EditText edName = (EditText) findViewById(R.id.edname);
        EditText edNum = (EditText)findViewById(R.id.ednum);
        String edname = edName.getText().toString();
        String ednum = edNum.getText().toString();
        SharedPreferences setting =
                getSharedPreferences("atm",MODE_PRIVATE);
             setting.edit()
                     .putString("PREF_NUMBER",ednum)
                     .putString("PREF_NAME",edname)
                     .commit();
        getIntent().putExtra("EXTRA_NAME",edname);
        getIntent().putExtra("EXTRA_NUM",ednum);
        setResult(RESULT_OK,getIntent());
        finish();
    }
}
