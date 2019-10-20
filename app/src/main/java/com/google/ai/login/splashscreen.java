package com.google.ai.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class splashscreen extends AppCompatActivity {

    private int waktu_loading = 3000;

    public static String TAG_MESSAGE, TAG_MESSAGEUser = "data.splashscreen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override


            public void run() {
               SharedPreferences  sp = getSharedPreferences("com.google.ai.aplication", MODE_PRIVATE);

                String Username = sp.getString("Username", "");
                String password = sp.getString("Pasword", "");


                if (Username.equals("") && password.equals("")) {
                    Intent intent = new Intent(splashscreen.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(splashscreen.this, Slamat_Datang.class);
                    intent.putExtra(TAG_MESSAGEUser, Username);
                    intent.putExtra(TAG_MESSAGE, password);
                    startActivity(intent);
                }
            }
        }, waktu_loading);
    }
}

