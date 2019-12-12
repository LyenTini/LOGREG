package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //1.
    private AdatbazisSegito adatbazisSegito;
    private Button buttonRegisztracio, buttonBejelentkezes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //3.
        init();
        buttonRegisztracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonBejelentkezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoggedInActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    //2.
    public void init(){
        adatbazisSegito = new AdatbazisSegito(this);
        buttonRegisztracio = findViewById(R.id.idBtnReg);
        buttonBejelentkezes = findViewById(R.id.idBtnBejel);

    }

}
