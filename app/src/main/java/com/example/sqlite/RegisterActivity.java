package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    //1.
    private AdatbazisSegito adatbazisSegito;
    private EditText editTextEmail, editTextFelh, editTextJelszo,editTextTelj;
    private Button buttonRegisztracio, buttonVissza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //3.
        init();
        buttonRegisztracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adatRogzites();
            }
        });
        buttonVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
    //2.
    public void init(){
        adatbazisSegito = new AdatbazisSegito(this);
        editTextEmail = findViewById(R.id.idEmail);
        editTextFelh = findViewById(R.id.idFelh);
        editTextJelszo = findViewById(R.id.idJelszo);
        editTextTelj = findViewById(R.id.idTelj);
        buttonRegisztracio = findViewById(R.id.idBtnReg);
        buttonVissza = findViewById(R.id.idBtnV);
    }

    public void adatRogzites(){

        String email = editTextEmail.getText().toString();
        String felhnev = editTextFelh.getText().toString();
        String jelszo = editTextJelszo.getText().toString();
        String teljesnev = editTextTelj.getText().toString();//Parsolni a jegyet és ha nagyobb vagy kisebb mint ... írja ki

        if (email.isEmpty() || felhnev.isEmpty() || jelszo.isEmpty() || teljesnev.isEmpty()){
            Toast.makeText(this, "Minden mezőt ki kell tölteni!", Toast.LENGTH_SHORT).show();
            return;// Nem fut tovább
        }

        Boolean eredmeny = adatbazisSegito.adatRogzites(email, felhnev, jelszo, teljesnev );

        if (eredmeny){
            Toast.makeText(this, "Sikeres regisztráció!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Sikertelen regisztráció, már van ilyen felhasználó! :(", Toast.LENGTH_SHORT).show();
        }
    }
}
