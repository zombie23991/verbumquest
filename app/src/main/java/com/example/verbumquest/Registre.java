package com.example.verbumquest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Registre extends AppCompatActivity {
    //VARIABLE DECLARADES
    EditText etCorreu, etContrassenya, etNomUsuari;
    Button Registrar;
    FirebaseAuth auth; //AUTENTICACIÓ FIREBASE

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);

        //INICIALITZACIÓ DE LES VARIABLE
        etCorreu = findViewById(R.id.etCorreu);
        etContrassenya = findViewById(R.id.etContrassenya);
        etNomUsuari = findViewById(R.id.etNomUsuari);
        Registrar = findViewById(R.id.btRegistre);

        auth = FirebaseAuth.getInstance();

        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String correu = etCorreu.getText().toString();
                String contrassenya = etContrassenya.getText().toString();

                /* VALIDAR LES DADES */
                /* VALIDACIÓ CORREU ELECTRÒNIC */
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
                            FirebaseUser user = auth.getCurrentUser();

                            int contador = 0;

                            /* STRINGS */
                            assert user != null; /* VERIFICA QUE L'USUARI NO ÉS NULL*/
                            String stUid= user.getUid();
                            String stCorreu = etCorreu.getText().toString();
                            String stContrassenya = etContrassenya.getText().toString();
                            String stNomUsuari = etNomUsuari.getText().toString();

                            HashMap<Object,Object> dadesJugador = new HashMap<>();

                            dadesJugador.put("Uid", stUid);
                            dadesJugador.put("Correu", stCorreu);
                            dadesJugador.put("Contrassenya", stContrassenya);
                            dadesJugador.put("Nom Usuari", stNomUsuari);

                            FirebaseDatabase database = FirebaseDatabase.getInstance(); //INSTANCIAMENT BASE DE DADES
                            DatabaseReference reference = database.getReference("Verbum Quest Database"); // NOM DE LA BASE DE DADES
                            reference.child(stUid).setValue(dadesJugador);

                            startActivity(new Intent(Registre.this, Menu.class));
                            Toast.makeText(Registre.this, "L'usuari s'ha registrat amb èxit", Toast.LENGTH_SHORT).show();
                            finish();
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