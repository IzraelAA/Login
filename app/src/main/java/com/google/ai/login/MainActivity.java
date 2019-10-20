package com.google.ai.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    public static String TAG_MESSAGE, TAG_MESSAGEUser = "data.MainActivity";
private Bitmap bitmap;
    EditText Username, Password;
    Button Daftar;
ImageView gambar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gambar = findViewById(R.id.img);
        Password = findViewById(R.id.edt_pass);
        Username = findViewById(R.id.edt_User);
        Daftar = findViewById(R.id.btn_daftar);
        Daftar.setOnClickListener(this);
        gambar.setOnClickListener(this);
    }

    private void DaftarUser(String Username, String Password) {
        SharedPreferences        sp   = getSharedPreferences("com.google.ai.aplication", MODE_PRIVATE);
        SharedPreferences.Editor ed   = sp.edit();
        String                   User = Username;
        String                   Pass = Password;
        ed.putString("Username", User);
        ed.putString("Password", Pass);
        ed.commit();

        Intent intent = new Intent(this, Slamat_Datang.class);
        intent.putExtra(TAG_MESSAGEUser, Username);
        intent.putExtra(TAG_MESSAGE, Password);
        startActivity(intent);
    }

    public void onClick(View v) {
        if (v == Daftar) {
            DaftarUser(Username.getText().toString(), Password.getText().toString());

        }else if (v == gambar){
            pilihGambar();
        }
    }

    private void pilihGambar(){
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i,"Pilih"),1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1 && resultCode == RESULT_OK && data != null && data.getData() != null){
            Uri f = data.getData();
            try {

                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), f);
              gambar.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}