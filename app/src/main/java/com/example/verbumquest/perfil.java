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

    DatabaseReference VerbumQuest;
    FirebaseDatabase fbd; //VARIABLE BASE DE DADES DES DE FIREBASE
    FirebaseFirestore fstore;
    FirebaseAuth auth; //AUTENTICACIÓ FIREBASE

    TextView tvNom, tvCorreu, tvPuntuacio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        auth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        fbd = FirebaseDatabase.getInstance();

        tvNom = findViewById(R.id.nom);
        tvCorreu = findViewById(R.id.correu);
        tvPuntuacio = findViewById(R.id.puntuaciototal);

        FirebaseUser user = auth.getCurrentUser();
        assert user != null; // CONFIRMACIO DE QUE L'USUARI NO ES NULL
        Consulta(user);

    }

    private void Consulta(FirebaseUser user){
        String stUid = user.getUid();
        DocumentReference documentReference = fstore.collection("Usuaris").document(stUid);
        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot dadesUsuari = task.getResult();
                    if (dadesUsuari.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + dadesUsuari.getData());
                        tvNom.setText(dadesUsuari.getData().get("Nom Usuari").toString());
                        tvCorreu.setText(dadesUsuari.getData().get("Correu").toString());
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }


}
