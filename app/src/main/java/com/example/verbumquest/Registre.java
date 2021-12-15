package com.example.verbumquest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Registre extends AppCompatActivity {
    //VARIABLE DECLARADES
    EditText etCorreu, etContrassenya, etNomUsuari;
    Button Registrar;
    FirebaseAuth auth; //AUTENTICACIÓ FIREBASE
    DatabaseReference baseDades; // REFERENCIA A LA BASE DE DADES
    FirebaseDatabase fbd; //VARIABLE BASE DE DADES DES DE FIREBASE

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);

        //INICIALITZACIÓ DE LES VARIABLES
        etCorreu = findViewById(R.id.etCorreu);
        etContrassenya = findViewById(R.id.etContrassenya);
        etNomUsuari = findViewById(R.id.etNomUsuari);
        Registrar = findViewById(R.id.btRegistre);

        auth = FirebaseAuth.getInstance();
        fbd = FirebaseDatabase.getInstance();

        //PROVA PER A COMPROVAR QUE ES MODIFIQUI LA BASE DE DADES (NO FUNCIONA)
        /* FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Usuaris");
        myRef.setValue("Hello, eeeeeee!"); */

        baseDades = fbd.getReference("Usuaris"); // INSTANCIAMENT BASE DE DADES + NOM DE LA BASE DE DADES
        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String nom = etNomUsuari.getText().toString();
                String correu = etCorreu.getText().toString();
                String contrassenya = etContrassenya.getText().toString();

                /* VALIDAR LES DADES */
                    /* VALIDACIÓ CORREU ELECTRÒNIC */
                if(!nom.isEmpty() && !correu.isEmpty() && !contrassenya.isEmpty()){
                    if(!Patterns.EMAIL_ADDRESS.matcher(correu).matches()){
                        etCorreu.setError("El correu introduït és invàlid");
                        etCorreu.setFocusable(true);

                        /* VALIDACÓ CONTRASSENYA */
                    } else if(contrassenya.length() < 6) {
                        etContrassenya.setError("La contrassenya ha de ser de 6 caracters");
                        etContrassenya.setFocusable(true);
                    } else {
                        registrarJugador(correu, contrassenya);
                    }
                } else{
                    Toast.makeText(Registre.this, "Has de completar tots els camps.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    /* MÈTODE DE REGISTRE D'USUARI NOU */
    private void registrarJugador(String correu, String contrassenya) {
        auth.createUserWithEmailAndPassword(correu, contrassenya)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        /* SI ES REGISTRA AMB ÈXIT */
                        if(task.isSuccessful()){
                            /* STRINGS */
                            String stUid = auth.getCurrentUser().getUid();
                            String stCorreu = etCorreu.getText().toString();
                            String stContrassenya = etContrassenya.getText().toString();
                            String stNomUsuari = etNomUsuari.getText().toString();

                            Map<String,Object> dadesJugador = new HashMap<>();

                            dadesJugador.put("Uid", stUid);
                            dadesJugador.put("Correu", stCorreu);
                            dadesJugador.put("Contrassenya", stContrassenya);
                            dadesJugador.put("Nom Usuari", stNomUsuari);

                            Usuari u = new Usuari(stUid,stCorreu,stContrassenya,stNomUsuari);
                            baseDades.setValue(u);
                            Toast.makeText(Registre.this, "L'usuari s'ha registrat amb èxit", Toast.LENGTH_SHORT).show();
                            finish();

                            /*baseDades.child("Usuaris").child(stUid).setValue(dadesJugador).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task2) {
                                    if(task2.isSuccessful()){
                                        startActivity(new Intent(Registre.this, Menu.class));
                                        Toast.makeText(Registre.this, "L'usuari s'ha registrat amb èxit", Toast.LENGTH_SHORT).show();
                                        finish();
                                    } else {
                                        Toast.makeText(Registre.this, "Hmm Hmm ha petat", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });*/


                        } else {
                            Toast.makeText(Registre.this, "Hi ha hagut un problema", Toast.LENGTH_SHORT).show();
                        }
                    }
                    /* SI FALLA EL REGISTRE */
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Registre.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }


}