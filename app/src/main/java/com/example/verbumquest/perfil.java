package com.example.verbumquest;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.net.Authenticator;

public class perfil extends AppCompatActivity {

    TextView tvNom, tvCorreu, tvPuntuacio, titol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tvNom = findViewById(R.id.nom);
        tvCorreu = findViewById(R.id.correu);
        tvPuntuacio = findViewById(R.id.puntuaciototal);
        titol = findViewById(R.id.titol);

        //Ubicacio
        String ubicacio = "fonts/pixel.ttf";
        Typeface Tf = Typeface.createFromAsset(perfil.this.getAssets(), ubicacio);

        //passar text a tipus de font lletra
        tvNom.setTypeface(Tf);
        tvCorreu.setTypeface(Tf);
        tvPuntuacio.setTypeface(Tf);
        titol.setTypeface(Tf);



    }

}
