package com.google.ai.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Slamat_Datang extends AppCompatActivity {

    TextView Username, Password;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slamat__datang);
        SharedPreferences        sp = getSharedPreferences("com.google.ai.aplication", MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();

        Username = findViewById(R.id.textuser);
        Password = findViewById(R.id.textpass);

        Intent in   = getIntent();
        String data = in.getStringExtra(MainActivity.TAG_MESSAGE);
        data = in.getStringExtra(splashscreen.TAG_MESSAGE);


        Intent inte  = getIntent();
        String data1 = inte.getStringExtra(MainActivity.TAG_MESSAGEUser);
        data1 = inte.getStringExtra(splashscreen.TAG_MESSAGEUser);
        Username.setText(data1);
        Password.setText(data);
        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Slamat_Datang.this, MainActivity.class);
                startActivity(in);
            }
        });
    }
}
