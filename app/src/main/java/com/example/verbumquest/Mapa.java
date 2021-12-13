package com.example.verbumquest;

import android.content.Intent;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        mon1 = findViewById(R.id.mon1);
        mon2 = findViewById(R.id.mon2);

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

    }


}
