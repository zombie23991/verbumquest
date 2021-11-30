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
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    EditText etCorreuLogin, etContrassenyaLogin;
    Button btLogin;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //CONNEXIÓ AMB LA VISTA
        etCorreuLogin = findViewById(R.id.etCorreuLogin);
        etContrassenyaLogin = findViewById(R.id.etContrassenyaLogin);
        btLogin = findViewById(R.id.btLogin);
        auth = FirebaseAuth.getInstance();

        //CLICK EN EL BOTO DE LOGIN
        btLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view){
               String correu = etCorreuLogin.getText().toString();
               String contrassenya = etContrassenyaLogin.getText().toString();

               /* VALIDAR LES DADES */
                    /* VALIDACIÓ CORREU ELECTRÒNIC */
               if(!Patterns.EMAIL_ADDRESS.matcher(correu).matches()){
                   etCorreuLogin.setError("El correu introduït és invàlid");
                   etCorreuLogin.setFocusable(true);

                   /* VALIDACÓ CONTRASSENYA */
               } else if(contrassenya.length() < 6) {
                   etContrassenyaLogin.setError("La contrassenya ha de ser de 6 caracters");
                   etContrassenyaLogin.setFocusable(true);
               } else {
                   loginJugador(correu, contrassenya);
               }
           }
        });

    }

    private void loginJugador(String correu, String contrassenya) {
        auth.signInWithEmailAndPassword(correu, contrassenya)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            FirebaseUser user = auth.getCurrentUser();
                            startActivity(new Intent(Login.this, Menu.class));
                            assert user != null; // CONFIRMACIO DE QUE L'USUARI NO ES NULL
                            Toast.makeText(Login.this, "Benvingut" + user.getEmail(), Toast.LENGTH_SHORT).show();
                        }
                    }
                    //SI FALLA EL LOGIN MOSTRA:
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login.this, "El correu electrònic o la contrassenya són incorrectes", Toast.LENGTH_SHORT).show();
                    }
                });
        }
}