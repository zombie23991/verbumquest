package com.example.verbumquest;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.net.Authenticator;

public class perfil extends AppCompatActivity {

    FirebaseUser user;

    DatabaseReference Jugadors;

    TextView tvTitol, tvNomUsuari, tvCorreu, tvPuntuacioTotal;
    String stUidUsuari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        user = FirebaseAuth.getInstance().getCurrentUser();
        Jugadors = FirebaseDatabase.getInstance().getReference("Users");
        stUidUsuari = user.getUid();

        tvNomUsuari = findViewById(R.id.nom);
        tvCorreu = findViewById(R.id.correu);
        tvPuntuacioTotal = findViewById(R.id.puntuaciototal);

        Consulta();
    }

    private void Consulta(){
        // CONSULTA
        Jugadors.child(stUidUsuari).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()){
                    Usuari perfilUsuari = snapshot.getValue(Usuari.class);

                    if(perfilUsuari != null){
                        // S'OBTENEN LES DADES DE LA BASE DE DADES
                        String stPuntuacio = ""+ds.child("Puntuacio").getValue();
                        String stCorreu = ""+ds.child("Correu").getValue();
                        String stNomUsuari = ""+ds.child("Nom Usuari").getValue();

                        // S'ASSIGNEN LES DADES ALS TEXTVIEWS
                        tvPuntuacioTotal.setText(stPuntuacio);
                        tvCorreu.setText(stCorreu);
                        tvNomUsuari.setText(stNomUsuari);
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(perfil.this, "No furula eh", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
