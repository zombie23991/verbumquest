package com.example.verbumquest;

import android.app.Dialog;
import android.content.ClipData;
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
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.verbumquest.adapter.RecyclerAdapter;
import com.example.verbumquest.model.ItemList;
import com.example.verbumquest.model.preguntes;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class JocAvtivity extends AppCompatActivity {
    private ImageView imgLiveOne, imgLiveTwo, imgLiveThree, imgEvilLive1, imgEvilLive2, imgEvilLive3, imgEvilLive4, imgEvilLive5;
    private GifImageView imgResource;
    private ConstraintLayout fons;
    private TextView mundo, pregunta;
    private ArrayList<preguntes> questionList;
    private TextView tvQuestions, tvScore, tvTimer, tvQuestionNo;
    private Button b1, b2,b3,b4;
    private int contador = 5;
    private GifImageView gifprota;
    public jugador jugador = new jugador(3);
    public enemic enemic = new enemic(5);
    private boolean endavant = false;

    private generarPreguntes generador = Menu.generador;

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
        miDialog = new Dialog(JocAvtivity.this);

        //Ubicacio
        String ubicacio = "fonts/pixel.ttf";
        Typeface Tf = Typeface.createFromAsset(JocAvtivity.this.getAssets(), ubicacio);

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

        protagonista();
        vides();
        initViews();
        initValues();
        escenari();

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

        questionList = generador.getPreguntes();
        currentPos = random.nextInt(questionList.size());
        setDataToViews(currentPos);
        //do {
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!GameOver) {
                    if (questionList.get(currentPos).getCorrectAnsNo().equals(b1.getText().toString())) {
                        enemic.setVides(enemic.getVides() - 1);
                        executarAttackJugador();
                        contador++;
                        if (enemic.getVides() > 0 || contador <= 0) {
                            restarvidesenemic();
                            currentPos = random.nextInt(questionList.size());
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
                    if (questionList.get(currentPos).getCorrectAnsNo().equals(b2.getText().toString())) {
                        enemic.setVides(enemic.getVides() - 1);
                        executarAttackJugador();
                        contador++;
                        if (enemic.getVides() > 0 || contador < 0) {
                            restarvidesenemic();
                            currentPos = random.nextInt(questionList.size());
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
                    if (questionList.get(currentPos).getCorrectAnsNo().equals(b3.getText().toString())) {
                        enemic.setVides(enemic.getVides() - 1);
                        executarAttackJugador();
                        contador++;
                        if (enemic.getVides() > 0 || contador < 0) {
                            restarvidesenemic();
                            currentPos = random.nextInt(questionList.size());
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
                    if (questionList.get(currentPos).getCorrectAnsNo().equals(b4.getText().toString())) {
                        enemic.setVides(enemic.getVides() - 1);
                        executarAttackJugador();
                        contador++;
                        if (enemic.getVides() > 0 || contador < 0) {
                            restarvidesenemic();
                            currentPos = random.nextInt(questionList.size());
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
        tvQuestions.setText(questionList.get(currentPos).getQuestion());
        b1.setText(questionList.get(currentPos).getOption1());
        b2.setText(questionList.get(currentPos).getOption2());
        b3.setText(questionList.get(currentPos).getOption3());
        b4.setText(questionList.get(currentPos).getOption4());

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
//comentari
        if(mundo.getText().equals("Esplanada")){
            fons.setBackgroundResource(R.drawable.esplanada);
        }else if(mundo.getText().equals("Bosc")){
            fons.setBackgroundResource(R.drawable.bosc);
        }else if(mundo.getText().equals("Desert")){
            fons.setBackgroundResource(R.drawable.desert);
        }else if(mundo.getText().equals("Torre")){
            fons.setBackgroundResource(R.drawable.torre);
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
        }

    }

    private void vides(){
        //Insertar vides al inici del joc
        //protagonista
        imgLiveOne.setImageResource(R.drawable.hearton);
        imgLiveTwo.setImageResource(R.drawable.hearton);
        imgLiveThree.setImageResource(R.drawable.hearton);


        //enemic
        imgEvilLive1.setImageResource(R.drawable.heartevil);
        imgEvilLive2.setImageResource(R.drawable.heartevil);
        imgEvilLive3.setImageResource(R.drawable.heartevil);
        imgEvilLive4.setImageResource(R.drawable.heartevil);
        imgEvilLive5.setImageResource(R.drawable.heartevil);

    }

    private void gameover(){
       GameOver = true;
       MensajeGameOver();
    }

    private void MensajeGameOver(){
        String ubicacio = "fonts/pixel.ttf";
        Typeface Tf = Typeface.createFromAsset(JocAvtivity.this.getAssets(), ubicacio);

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
        }
        else if(jugador.getVides() == 1){
            imgStarOne.setImageResource(R.drawable.star);
        }
        else if(jugador.getVides() == 2){
            imgStarOne.setImageResource(R.drawable.star);
            imgStarTwo.setImageResource(R.drawable.star);
        }
        else if(jugador.getVides() == 3){
            imgStarOne.setImageResource(R.drawable.star);
            imgStarTwo.setImageResource(R.drawable.star);
            imgStarThree.setImageResource(R.drawable.star);
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
                enemic.setVides(enemic.getVides() + 5);
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

        //extreure la informacio del Recycler View a la pantalla
        imgResource.setImageResource(detallItem.getImgResource());
        mundo.setText(detallItem.getMundo());
    }
}
