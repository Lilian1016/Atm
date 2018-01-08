package com.lilian.atm;

import android.icu.text.SimpleDateFormat;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Tester  {
    public static void main(String[]args){
        .Data now = new Data();
        System.out.println(now);
        System.out.println(now.getTime());
        SimpleDateFormat sdf =new SimpleDateFormat("yyy-MM-dd");
        System.out.println(sdf.format(now));
        String s ="1998-04-01";
        try{
            Data birthday = sdf.parse(s);
            System.out.println(birthday);
        }catch(ParseException e){
            e.printStackTrace();
        }
    }

}
