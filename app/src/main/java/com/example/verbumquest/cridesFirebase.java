package com.example.verbumquest;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.verbumquest.model.preguntes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cridesFirebase extends AppCompatActivity {
    private ArrayList<preguntes> llistaPreguntes = new ArrayList<>();
    private boolean endavant = false;

    // Variables Firebase
    private FirebaseFirestore fstore = FirebaseFirestore.getInstance(); //VARIABLE BASE DE DADES DES DE FIREBASE
    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private FirebaseUser usuari = auth.getCurrentUser();

    public void setPreguntes() {
        fstore.collection("Preguntes").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for(DocumentSnapshot document : task.getResult()){
                        if(document.exists()){
                            Log.d(TAG, "Preguntes data: " + document.getData());
                            llistaPreguntes.add(new preguntes(document.getData().get("Pregunta").toString(), document.getData().get("Opcio 1").toString(), document.getData().get("Opcio 2").toString(), document.getData().get("Opcio 3").toString() , document.getData().get("Opcio 4").toString() , document.getData().get("Resposta").toString()));
                            Log.d(TAG, "Mida array preguntes" + llistaPreguntes.size());
                        } else {
                            Log.d(TAG, "No existeixen les preguntes");
                        }
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }

    public ArrayList<preguntes> getPreguntes(){
        return llistaPreguntes;
    }

    public void registrarPuntuacio(String nomMapa, int posicio, int finalPunt) {
        Map<String,Object> mPuntuacioNivell = new HashMap<>();
        posicio += 1;
        mPuntuacioNivell.put("Nivell " + posicio, finalPunt);

        fstore.collection("Usuaris").document(usuari.getUid()).
                collection("Puntuacio Nivells").
                document(nomMapa).set(mPuntuacioNivell, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(@NonNull Void unused) {
                Log.d(TAG, "onSuccess: La puntuació s'ha guardat");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "onFailure: " + e.toString());
            }
        });
    }

    public void agafarPuntuacio(String nomMapa){
        Mapa objMapa = new Mapa();
        DocumentReference cridaNivell = fstore.collection("Usuaris").document(usuari.getUid()).
                collection("Puntuacio Nivells").document(nomMapa);

        cridaNivell.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                        if(task.isSuccessful()){
                            DocumentSnapshot UsuariNivell = (DocumentSnapshot) task.getResult();
                            int posNivell = 0;
                            ArrayList<Integer> puntuacioNivells = new ArrayList<>();

                            if (UsuariNivell.exists()) {
                                Log.d(TAG, "Puntuacio usuari data: " + UsuariNivell.getData());
                                Map<String, Object> mapaLlistat = UsuariNivell.getData();

                                if(mapaLlistat != null) {
                                    for (Map.Entry<String, Object> puntuacio : mapaLlistat.entrySet()) {
                                        Log.d(TAG, "Puntuacio usuari data: " + puntuacio.getValue());
                                        puntuacioNivells.add(0, Integer.parseInt(puntuacio.getValue().toString()));

                                    }

                                    for(int puntuacioNivell : puntuacioNivells) {
                                        Log.d(TAG, "Puntuacio usuari data: " + puntuacioNivell);
                                        objMapa.canviarEstrelles(nomMapa, posNivell, puntuacioNivell);
                                        posNivell++;
                                    }
                                }

                            } else {
                                Log.d(TAG, "No existeix l'usuari");
                            }

                        } else {
                            Log.d(TAG, "get failed with ", task.getException());
                        }
                    }
                });
    }

    private void agafarUsuari(){
        String stUid = usuari.getUid();
        DocumentReference documentReference = fstore.collection("Usuaris").document(stUid);

        ArrayList<String> infoUsuari = new ArrayList<String>();

        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot dadesUsuari = task.getResult();
                    if (dadesUsuari.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + dadesUsuari.getData());
                        infoUsuari.add(dadesUsuari.getData().get("Nom Usuari").toString());
                        infoUsuari.add(dadesUsuari.getData().get("Correu").toString());
                    } else {
                        Log.d(TAG, "No existeix l'usuari");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }
}
