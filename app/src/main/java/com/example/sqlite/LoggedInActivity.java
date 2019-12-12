package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoggedInActivity extends AppCompatActivity {

    private AdatbazisSegito adatbazisSegito;

    private TextView textUdvozles;
    private Button buttonKijelentkezes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();

        buttonKijelentkezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoggedInActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }


    public void init(){
        textUdvozles = findViewById(R.id.idUdvozles);
        buttonKijelentkezes = findViewById(R.id.idBtnKi);
    }
}
