package com.example.verbumquest;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Menu extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseUser user;
    Button usuari, jugarBtn, torre, quisom, TancarSessio;
    //static public cridesFirebase generador;
    static public cridesFirebase objCridarBD = new cridesFirebase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Mapa carregarPuntuacio = new Mapa();
        carregarPuntuacio.getItems();
        objCridarBD.agafarPuntuacio("Esplanada");

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        //Ubicacio
        String ubicacio = "fonts/pixel.ttf";
        Typeface Tf = Typeface.createFromAsset(Menu.this.getAssets(), ubicacio);

        TancarSessio = findViewById(R.id.TancarSessio);

        jugarBtn = findViewById(R.id.jugarBtn);
        torre = findViewById(R.id.torre);
        quisom = findViewById(R.id.quisom);
        usuari = findViewById(R.id.usuari);

        usuari.setTypeface(Tf);
        TancarSessio.setTypeface(Tf);
        jugarBtn.setTypeface(Tf);
        torre.setTypeface(Tf);
        quisom.setTypeface(Tf);

        if(objCridarBD.getPreguntes().size() < 1) {
            objCridarBD.setPreguntes();
        }

        jugarBtn.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Menu.this, Mapa.class);
                startActivity(intent);
            }
        });

        torre.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Menu.this, Torre.class);
                startActivity(intent);
            }
        });

        quisom.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Menu.this, Credits.class);
                startActivity(intent);
            }
        });

        usuari.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Menu.this, perfil.class);
                startActivity(intent);
            }
        });

        TancarSessio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TancarSessio();
            }
        });
    }

    //S'executa quan el joc esta obert
    @Override
    protected void onStart() {
        UsuariLogin();
        super.onStart();
    }

    //Metode comproba si jugador ha iniciat sessio :)
    private void UsuariLogin(){

        if(user != null){
            Toast.makeText(this, "Jugador conectat", Toast.LENGTH_SHORT).show();
        }else {
            startActivity(new Intent(Menu.this,MainActivity.class));
            finish();
        }
    }

    //Motode per tancar sessi??
    private void TancarSessio() {
        auth.signOut();
        startActivity(new Intent(Menu.this,MainActivity.class));
        Toast.makeText(this, "Has tancat sessi??", Toast.LENGTH_SHORT).show();
    }
}