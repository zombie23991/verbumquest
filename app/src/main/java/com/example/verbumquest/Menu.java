package com.example.verbumquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    Button TancarSessio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        TancarSessio = findViewById(R.id.TancarSessio);

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