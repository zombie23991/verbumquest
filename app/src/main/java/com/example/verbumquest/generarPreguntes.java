package com.example.verbumquest;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.verbumquest.model.preguntes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class generarPreguntes {
    private ArrayList<preguntes> llistaPreguntes = new ArrayList<>();
    private FirebaseFirestore fstore = FirebaseFirestore.getInstance(); //VARIABLE BASE DE DADES DES DE FIREBASE
    private boolean endavant = false;

    public void setPreguntes() {
        fstore.collection("Preguntes").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for(DocumentSnapshot document : task.getResult()){
                        if(document.exists()){
                            Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                            llistaPreguntes.add(new preguntes(document.getData().get("Pregunta").toString(), document.getData().get("Opcio 1").toString(), document.getData().get("Opcio 2").toString(), document.getData().get("Opcio 3").toString() , document.getData().get("Opcio 4").toString() , document.getData().get("Resposta").toString()));
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
}
