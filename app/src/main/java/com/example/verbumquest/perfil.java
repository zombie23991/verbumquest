package com.example.verbumquest;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.net.Authenticator;

public class perfil extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference VerbumQuest;

    TextView titol,nom ,correu, puntuaciototal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        firebaseDatabase = FirebaseDatabase.getInstance();
        VerbumQuest = firebaseDatabase .getReference("VerbumQuest");

    }

    private void Consulta(){
    }


}
