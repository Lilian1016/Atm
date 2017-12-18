package com.lilian.atm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.lilian.atm.MainActivity.REQUEST_LOGIN;

public class LoginActivity extends AppCompatActivity {

    private EditText edUserid;
    private EditText edPasswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUserid = (EditText) findViewById(R.id.userid);
        edPasswd = (EditText) findViewById(R.id.passwd);
        String userid =getSharedPreferences("atm",MODE_PRIVATE)
                .getString("PREF_USERID","");
        edUserid.setText(userid);
        String passwd = getSharedPreferences("atm",MODE_PRIVATE)
                .getString("PREF_PASSWD","");
    }



    public void login (View view){

        String userid = edUserid.getText().toString();
        String passwd = edPasswd.getText().toString();
        if ("jack".equals(userid)&&"1234".equals(passwd)){
            SharedPreferences setting =
            getSharedPreferences("atm",MODE_PRIVATE);
            setting.edit()
                    .putString("PREF_PASSWD",passwd)
                    .putString("PREF_USERID",userid)
                    .commit();
            Toast.makeText(this,"登入成功",Toast.LENGTH_LONG).show();
            getIntent().putExtra("EXRA_USERID",userid);
            setResult(RESULT_OK,getIntent());
            finish();
        }else{
            new AlertDialog.Builder(this)
                    .setTitle("登入")
                    .setMessage("登入失敗")
                    .setPositiveButton("ok",null)
                    .show();
        }
    }
    public  void cencel (View view){

    }
}
