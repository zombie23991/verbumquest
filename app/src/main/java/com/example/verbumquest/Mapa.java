package com.example.verbumquest;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.RecoverySystem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.FirebaseDatabase;

public class Mapa extends AppCompatActivity {

    Button mon1;
    Button mon2;
    Button mon3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        mon1 = findViewById(R.id.mon1);
        mon2 = findViewById(R.id.mon2);
        mon3 = findViewById(R.id.mon3);

        //Ubicacio
        String ubicacio = "fonts/pixel.ttf";
        Typeface Tf = Typeface.createFromAsset(Mapa.this.getAssets(), ubicacio);

        //passar text a tipus de font lletra
        mon1.setTypeface(Tf);
        mon2.setTypeface(Tf);
        mon3.setTypeface(Tf);

        mon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mapa.this, MonPla.class);
                startActivity(intent);
            }
        });

        mon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mapa.this, monSelva.class);
                startActivity(intent);
            }
        });

        mon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mapa.this, monDesert.class);
                startActivity(intent);
            }
        });

    }


}
