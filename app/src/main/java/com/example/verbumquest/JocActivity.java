package com.example.verbumquest;

import static com.example.verbumquest.Menu.objCridarBD;

import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.verbumquest.model.ItemList;
import com.example.verbumquest.model.preguntes;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class JocActivity<asyncTask> extends AppCompatActivity {
    private ImageView imgLiveOne, imgLiveTwo, imgLiveThree, imgEvilLive1, imgEvilLive2, imgEvilLive3, imgEvilLive4, imgEvilLive5;
    private GifImageView imgResource;
    private ConstraintLayout fons;
    private TextView mundo, pregunta;
    private ArrayList<preguntes> llistatPreguntes;
    private TextView tvQuestions, tvScore, tvTimer, tvQuestionNo;
    private Button b1, b2,b3,b4;
    private int contador = 5;
    private GifImageView gifprota;
    public jugador jugador = new jugador(3);
    public enemic enemic = new enemic(5);
    int finalPunt = 0;

    private FirebaseFirestore fstore = FirebaseFirestore.getInstance();
    private FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseUser usuari = auth.getCurrentUser();

    int posicio;

    boolean GameOver = false;
    Dialog miDialog;

    Random random;

    int currentScore = 0, questionAttempted = 1, currentPos;

    //obtenir items de la llista
    private ItemList detallItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joc);
        setTitle(getClass().getSimpleName());
        fons = findViewById(R.id.fons);
        gifprota = findViewById(R.id.gifProta);

        //iniciar dialog
        miDialog = new Dialog(JocActivity.this);

        //Ubicacio
        String ubicacio = "fonts/pixel.ttf";
        Typeface Tf = Typeface.createFromAsset(JocActivity.this.getAssets(), ubicacio);

        //vides del protagonista
        imgLiveOne = findViewById(R.id.imgLiveOne);
        imgLiveTwo = findViewById(R.id.imgLiveTwo);
        imgLiveThree = findViewById(R.id.imgLiveThree);

        //vides del enemic
        imgEvilLive1 = findViewById(R.id.imgEvilLive1);
        imgEvilLive2 = findViewById(R.id.imgEvilLive2);
        imgEvilLive3 = findViewById(R.id.imgEvilLive3);
        imgEvilLive4 = findViewById(R.id.imgEvilLive4);
        imgEvilLive5 = findViewById(R.id.imgEvilLive5);

        //text
        pregunta = findViewById(R.id.pregunta);
        mundo = findViewById(R.id.mundo);

        //inicialitzem nivell
        protagonista();
        initViews();
        initValues();
        escenari();
        vides();
        tvQuestions = findViewById(R.id.pregunta);

        //botons de nivell
        b1 = findViewById(R.id.resposta1);
        b2 = findViewById(R.id.resposta2);
        b3 = findViewById(R.id.resposta3);
        b4 = findViewById(R.id.resposta4);

        //passar text a tipus de font lletra
        pregunta.setTypeface(Tf);
        mundo.setTypeface(Tf);
        b1.setTypeface(Tf);
        b2.setTypeface(Tf);
        b3.setTypeface(Tf);
        b4.setTypeface(Tf);

        random = new Random();


        llistatPreguntes = objCridarBD.getPreguntes();

        currentPos = random.nextInt(llistatPreguntes.size());

        setDataToViews(currentPos);
        //do {
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!GameOver) {
                    if (llistatPreguntes.get(currentPos).getCorrectAnsNo().equals(b1.getText().toString())) {
                        enemic.setVides(enemic.getVides() - 1);
                        executarAttackJugador();
                        contador++;
                        if (enemic.getVides() > 0 || contador <= 0) {
                            restarvidesenemic();
                            currentPos = random.nextInt(llistatPreguntes.size());
                            setDataToViews(currentPos);
                            resetejarBotons();

                        } else {
                            gameover();
                        }
                    } else {
                        if (jugador.getVides() == 1) {
                            jugador.setVides(jugador.getVides() - 1);
                            restarvidesprota();
                            gameover();
                        } else {
                            b1.setBackgroundResource(R.drawable.boto_personalitzat_preguntes_correcte);
                            b1.setEnabled(false);
                            jugador.setVides(jugador.getVides() - 1);
                            restarvidesprota();
                        }
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!GameOver) {
                    if (llistatPreguntes.get(currentPos).getCorrectAnsNo().equals(b2.getText().toString())) {
                        enemic.setVides(enemic.getVides() - 1);
                        executarAttackJugador();
                        contador++;
                        if (enemic.getVides() > 0 || contador < 0) {
                            restarvidesenemic();
                            currentPos = random.nextInt(llistatPreguntes.size());
                            setDataToViews(currentPos);
                            resetejarBotons();
                        } else {
                            gameover();
                        }
                    } else {
                        if (jugador.getVides() == 1) {
                            jugador.setVides(jugador.getVides() - 1);
                            restarvidesprota();
                            gameover();
                        } else {
                            b2.setBackgroundResource(R.drawable.boto_personalitzat_preguntes_correcte);
                            b2.setEnabled(false);
                            jugador.setVides(jugador.getVides() - 1);
                            restarvidesprota();
                        }
                    }
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!GameOver) {
                    if (llistatPreguntes.get(currentPos).getCorrectAnsNo().equals(b3.getText().toString())) {
                        enemic.setVides(enemic.getVides() - 1);
                        executarAttackJugador();
                        contador++;
                        if (enemic.getVides() > 0 || contador < 0) {
                            restarvidesenemic();
                            currentPos = random.nextInt(llistatPreguntes.size());
                            setDataToViews(currentPos);
                            resetejarBotons();
                        } else {
                            gameover();
                        }
                    } else {
                        if (jugador.getVides() == 1) {
                            jugador.setVides(jugador.getVides() - 1);
                            restarvidesprota();
                            gameover();
                        } else {
                            b3.setBackgroundResource(R.drawable.boto_personalitzat_preguntes_correcte);
                            b3.setEnabled(false);
                            jugador.setVides(jugador.getVides() - 1);
                            restarvidesprota();
                        }
                    }
                }
            }
        });


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!GameOver) {
                    if (llistatPreguntes.get(currentPos).getCorrectAnsNo().equals(b4.getText().toString())) {
                        enemic.setVides(enemic.getVides() - 1);
                        executarAttackJugador();
                        contador++;
                        if (enemic.getVides() > 0 || contador < 0) {
                            restarvidesenemic();
                            currentPos = random.nextInt(llistatPreguntes.size());
                            setDataToViews(currentPos);
                            resetejarBotons();
                        } else {
                            gameover();
                        }
                    } else {
                        if (jugador.getVides() == 1) {
                            jugador.setVides(jugador.getVides() - 1);
                            restarvidesprota();
                            gameover();
                        } else {
                            b4.setBackgroundResource(R.drawable.boto_personalitzat_preguntes_correcte);
                            b4.setEnabled(false);
                            jugador.setVides(jugador.getVides() - 1);
                            restarvidesprota();
                        }
                    }
                }
            }
        });
    }


    private void setDataToViews(int currentPos) {
        tvQuestions.setText(llistatPreguntes.get(currentPos).getQuestion());
        b1.setText(llistatPreguntes.get(currentPos).getOption1());
        b2.setText(llistatPreguntes.get(currentPos).getOption2());
        b3.setText(llistatPreguntes.get(currentPos).getOption3());
        b4.setText(llistatPreguntes.get(currentPos).getOption4());

    }

    private void resetejarBotons() {
        b1.setBackgroundResource(R.drawable.boto_personalitzat_preguntes);
        b1.setEnabled(true);
        b2.setBackgroundResource(R.drawable.boto_personalitzat_preguntes);
        b2.setEnabled(true);
        b3.setBackgroundResource(R.drawable.boto_personalitzat_preguntes);
        b3.setEnabled(true);
        b4.setBackgroundResource(R.drawable.boto_personalitzat_preguntes);
        b4.setEnabled(true);
    }

    private void escenari(){
        pregunta.getBackground().setAlpha(100);
        if(mundo.getText().equals("Esplanada")){
            fons.setBackgroundResource(R.drawable.esplanada);
        }else if(mundo.getText().equals("Bosc")){
            fons.setBackgroundResource(R.drawable.bosc);
        }else if(mundo.getText().equals("Desert")){
            fons.setBackgroundResource(R.drawable.desert);
        }else if(mundo.getText().equals("Torre")){
            fons.setBackgroundResource(R.drawable.torre);
            enemic.vides = 10;
        }
    }

    private void executarAttackJugador() {
        gifprota.setBackgroundResource(R.drawable.adventureratack);

        new CountDownTimer( 3000, 50 ) {

            public void onTick(long millisUntilFinished) {

            }
            public void onFinish() {
                gifprota.setBackgroundResource(R.drawable.adventurerrescalat);
            }
        }.start();
    }
    private void protagonista() {
        gifprota.setBackgroundResource(R.drawable.adventurerrescalat);
    }

    private void restarvidesprota(){

        if(jugador.getVides() == 0){
        imgLiveOne.setImageResource(R.drawable.heartoff);}
        else if(jugador.getVides() == 1){
        imgLiveTwo.setImageResource(R.drawable.heartoff);}
        else if(jugador.getVides() == 2){
        imgLiveThree.setImageResource(R.drawable.heartoff);}

    }

    private void restarvidesenemic(){

        //ultima fila de lineas
        if(enemic.getVides() == 4) {
            imgEvilLive5.setImageResource(R.drawable.heartoff);
        }else if(enemic.getVides() == 3){
            imgEvilLive4.setImageResource(R.drawable.heartoff);
        }else if(enemic.getVides() == 2) {
            imgEvilLive3.setImageResource(R.drawable.heartoff);
        }else if(enemic.getVides() == 1) {
            imgEvilLive2.setImageResource(R.drawable.heartoff);
        }else if(enemic.getVides() == 0) {
            imgEvilLive1.setImageResource(R.drawable.heartoff);

        //segona linea de vides
        }else if(enemic.getVides() == 9) {
            imgEvilLive5.setImageResource(R.drawable.heartevil);
        }else if(enemic.getVides() == 8){
            imgEvilLive4.setImageResource(R.drawable.heartevil);
        }else if(enemic.getVides() == 7) {
            imgEvilLive3.setImageResource(R.drawable.heartevil);
        }else if(enemic.getVides() == 6) {
            imgEvilLive2.setImageResource(R.drawable.heartevil);
        }else if(enemic.getVides() == 5) {
            imgEvilLive1.setImageResource(R.drawable.heartevil);
        }

    }

    private void vides(){

    if(mundo.getText().equals("Torre")){
        enemic.vides = 10;
    }
        //Insertar vides al inici del joc
        //protagonista
        imgLiveOne.setImageResource(R.drawable.hearton);
        imgLiveTwo.setImageResource(R.drawable.hearton);
        imgLiveThree.setImageResource(R.drawable.hearton);


        //enemic
        if(mundo.getText().equals("Torre")) {
            imgEvilLive1.setImageResource(R.drawable.heartevil2);
            imgEvilLive2.setImageResource(R.drawable.heartevil2);
            imgEvilLive3.setImageResource(R.drawable.heartevil2);
            imgEvilLive4.setImageResource(R.drawable.heartevil2);
            imgEvilLive5.setImageResource(R.drawable.heartevil2);
        }
        else{
            imgEvilLive1.setImageResource(R.drawable.heartevil);
            imgEvilLive2.setImageResource(R.drawable.heartevil);
            imgEvilLive3.setImageResource(R.drawable.heartevil);
            imgEvilLive4.setImageResource(R.drawable.heartevil);
            imgEvilLive5.setImageResource(R.drawable.heartevil);}


    }

    private void gameover(){
       GameOver = true;
       MensajeGameOver();
    }

    private void MensajeGameOver(){
        String ubicacio = "fonts/pixel.ttf";
        Typeface Tf = Typeface.createFromAsset(JocActivity.this.getAssets(), ubicacio);
        int punt = 0;
        TextView Fi, punts;
        ImageView imgStarOne, imgStarTwo, imgStarThree;
        Button sortir, reintentar;

        miDialog.setContentView(R.layout.gameover);
        miDialog.setCanceledOnTouchOutside(false);
        miDialog.setCancelable(false);

        Fi = miDialog.findViewById(R.id.Fi);
        punts = miDialog.findViewById(R.id.punts);

        //Tranformem el text
        Fi.setTypeface(Tf);
        punts.setTypeface(Tf);

        imgStarOne = miDialog.findViewById(R.id.imgStarOne);
        imgStarTwo = miDialog.findViewById(R.id.imgStarTwo);
        imgStarThree = miDialog.findViewById(R.id.imgStarThree);

        sortir = miDialog.findViewById(R.id.sortir);
        reintentar = miDialog.findViewById(R.id.reintentar);

        imgStarOne.setImageResource(R.drawable.staroff);
        imgStarTwo.setImageResource(R.drawable.staroff);
        imgStarThree.setImageResource(R.drawable.staroff);


        if(jugador.getVides() == 0){
                Fi.setText("Has perdut, torna a intentar-ho!");
                objCridarBD.registrarPuntuacio(detallItem.getMundo(), posicio, 0);
            }
            else if(jugador.getVides() == 1){
                imgStarOne.setImageResource(R.drawable.star);
                objCridarBD.registrarPuntuacio(detallItem.getMundo(), posicio, 1);
            }
            else if(jugador.getVides() == 2){
                imgStarOne.setImageResource(R.drawable.star);
                imgStarTwo.setImageResource(R.drawable.star);
                objCridarBD.registrarPuntuacio(detallItem.getMundo(), posicio, 2);
            }
            else if(jugador.getVides() == 3){
                imgStarOne.setImageResource(R.drawable.star);
                imgStarTwo.setImageResource(R.drawable.star);
                imgStarThree.setImageResource(R.drawable.star);
                objCridarBD.registrarPuntuacio(detallItem.getMundo(), posicio, 3);

            objCridarBD.agafarPuntuacio(detallItem.getMundo());
        }

        sortir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        reintentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                miDialog.dismiss();
                GameOver = false;
                //Treiem i tornem a posar vides
                jugador.setVides(0);
                jugador.setVides(jugador.getVides() + 3);
                enemic.setVides(0);
                if(mundo.getText().equals("Torre")){
                    enemic.setVides(enemic.getVides() + 10);
                } else {
                enemic.setVides(enemic.getVides() + 5);}
                contador = 5;
                vides();
                resetejarBotons();
                initViews();
                initValues();
            }
        });

        miDialog.show();
    }

    private void initViews(){
        mundo = findViewById(R.id.mundo);
        imgResource = findViewById(R.id.gifEnemic);

    }

    private void initValues(){
        detallItem = (ItemList) getIntent().getExtras().getSerializable("detallItem");
        posicio = getIntent().getExtras().getInt("pos");

        //extreure la informacio del Recycler View a la pantalla
        imgResource.setImageResource(detallItem.getImgResource());
        mundo.setText(detallItem.getMundo());
    }
}
