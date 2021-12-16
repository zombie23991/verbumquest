package com.example.verbumquest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;

public class Menu extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseUser user;

    Button usuari ,jugarBtn, torre, quisom, TancarSessio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        //Ubicacio
        String ubicacio = "fonts/pixel.ttf";
        Typeface Tf = Typeface.createFromAsset(Menu.this.getAssets(), ubicacio);

        TancarSessio = findViewById(R.id.TancarSessio);

        jugarBtn = findViewById(R.id.jugarBtn);
        torre = findViewById(R.id.torre);
        quisom = findViewById(R.id.quisom);
       // usuari = findViewById(R.id.usuari);

       // usuari.setTypeface(Tf);
        TancarSessio.setTypeface(Tf);
        jugarBtn.setTypeface(Tf);
        torre.setTypeface(Tf);
        quisom.setTypeface(Tf);

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
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dragonfactory.cat/about-us/"));
                        startActivity(browserIntent);
            }
        });

        /*usuari.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Menu.this, perfil.class);
                startActivity(intent);
            }
        });*/

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

    //Motodo comproba si jugador a iniciat sesio :)
    private void UsuariLogin(){

        if(user != null){
            Toast.makeText(this, "Jugador conectat", Toast.LENGTH_SHORT).show();
        }else {
            startActivity(new Intent(Menu.this,MainActivity.class));
            finish();
        }
    }

    //Motode per tancar sessió
    private void TancarSessio() {
        auth.signOut();
        startActivity(new Intent(Menu.this,MainActivity.class));
        Toast.makeText(this, "Has tancat sessió", Toast.LENGTH_SHORT).show();
    }
}