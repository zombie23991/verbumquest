package com.example.verbumquest;

import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.verbumquest.adapter.RecyclerAdapter;
import com.example.verbumquest.model.ItemList;
import com.example.verbumquest.model.preguntes;

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
    private TextView mundo;
    private ArrayList<preguntes> questionList;
    private TextView tvQuestions, tvScore, tvTimer, tvQuestionNo;
    private Button b1, b2,b3,b4;
    private int contador = 5;
    public jugador jugador = new jugador(3);
    public enemic enemic = new enemic(5);

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

        vidas();
        initViews();
        initValues();
        escenari();

        questionList = new ArrayList();
        tvQuestions = findViewById(R.id.pregunta);
        b1 = findViewById(R.id.resposta1);
        b2 = findViewById(R.id.resposta2);
        b3 = findViewById(R.id.resposta3);
        b4 = findViewById(R.id.resposta4);
        random = new Random();
        addQuestions(questionList);
        currentPos = random.nextInt(questionList.size());
        setDataToViews(currentPos);
        //do {
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionList.get(currentPos).getCorrectAnsNo().equals(b1.getText().toString())) {
                    enemic.setVides(enemic.getVides() - 1 );
                    contador++;
                    if(enemic.getVides() > 0 || contador <= 0) {
                        restarvidasenemic();
                        currentPos = random.nextInt(questionList.size());
                        setDataToViews(currentPos);
                        resetejarBotons();

                    }
                    else {
                        finish();
                    }
                } else {
                    if(jugador.getVides() == 1) {
                        jugador.setVides(jugador.getVides() - 1);
                        restarvidasprota();
                        finish();
                    } else {
                        b1.setBackgroundResource(R.drawable.boto_personalitzat_preguntes_correcte);
                        jugador.setVides(jugador.getVides() - 1);
                        restarvidasprota();
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (questionList.get(currentPos).getCorrectAnsNo().equals(b2.getText().toString())) {
                    enemic.setVides(enemic.getVides() - 1 );
                    contador++;
                    if(enemic.getVides() > 0 || contador < 0) {
                        restarvidasenemic();
                        currentPos = random.nextInt(questionList.size());
                        setDataToViews(currentPos);
                        resetejarBotons();
                    }
                    else {
                        finish();
                    }
                } else {
                    if(jugador.getVides() == 1) {
                        jugador.setVides(jugador.getVides() - 1);
                        restarvidasprota();
                        finish();
                    } else {
                        b2.setBackgroundResource(R.drawable.boto_personalitzat_preguntes_correcte);
                        jugador.setVides(jugador.getVides() - 1);
                        restarvidasprota();
                    }
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (questionList.get(currentPos).getCorrectAnsNo().equals(b3.getText().toString())) {
                    enemic.setVides(enemic.getVides() - 1 );
                    contador++;
                    if(enemic.getVides() > 0 || contador < 0) {
                        restarvidasenemic();
                        currentPos = random.nextInt(questionList.size());
                        setDataToViews(currentPos);
                        resetejarBotons();
                    }
                    else {
                        finish();
                    }
                } else {
                    if(jugador.getVides() == 1) {
                        jugador.setVides(jugador.getVides() - 1);
                        restarvidasprota();
                        finish();
                    } else {
                        b3.setBackgroundResource(R.drawable.boto_personalitzat_preguntes_correcte);
                        jugador.setVides(jugador.getVides() - 1);
                        restarvidasprota();
                    }
                }
            }
        });


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (questionList.get(currentPos).getCorrectAnsNo().equals(b4.getText().toString())) {
                    enemic.setVides(enemic.getVides() - 1 );
                    contador++;
                    if(enemic.getVides() > 0 || contador < 0) {
                        restarvidasenemic();
                        currentPos = random.nextInt(questionList.size());
                        setDataToViews(currentPos);
                        resetejarBotons();
                    }
                    else {
                        finish();
                    }
                } else {
                    if(jugador.getVides() == 1) {
                        jugador.setVides(jugador.getVides() - 1);
                        restarvidasprota();
                        finish();
                    } else {
                        b4.setBackgroundResource(R.drawable.boto_personalitzat_preguntes_correcte);
                        jugador.setVides(jugador.getVides() - 1);
                        restarvidasprota();
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

    private void addQuestions(ArrayList<preguntes> questionList) {
        questionList.add(new preguntes("Assenyala, la 2a persona del singular del Present de Subjuntiu del verb cantar:", "cantéssis" , "cantaves" , "cantis" , "cantares" , "cantis"));
        questionList.add(new preguntes("Assenyala, la 3a persona del plural de l'Imperfet de l'Indicatiu del verb dormir:", "dormien" , "dormissin" , "dormien" ,  "dormirien" ,"dormien"));
        questionList.add(new preguntes("Quin és el gerundi del verb beure?", "begut" , "bevent" , "beguent" ,  "bevut" ,"bevent"));
        questionList.add(new preguntes("Assenyala, la 1a persona del plural del Passat Simple del verb somiar:", "somiàvem" , "somiàrem" , "somiéssim" ,  "somiaríem" ,"somiàrem"));
        questionList.add(new preguntes("Assenyala, la 3a persona del singular de l'Imperfet de subjuntiu del verb tenir:", "tingués" , "tingui" , "tenia" ,  "tinguesin" ,"tingués"));
        questionList.add(new preguntes("Assenyala, la 2a persona del plural del Passat simple del verb fer:", "vau fer" , "féreu" , "fèieu" ,  "féssiu" ,"féreu"));
        questionList.add(new preguntes("Assenyala, la 3a persona del plural de l'Imperfet de subjuntiu del verb creure:", "creiéssin" , "creieren" , "creien" ,  "creguessin" ,"creguessin"));
        questionList.add(new preguntes("Assenyala, la 1a persona del plural del Futur de l'Indicatiu del verb moure:", "moguerem" , "moverem" , "mourem" ,  "mouríem" ,"mourem"));
        questionList.add(new preguntes("Quina d'aquestes conjugacions del verb pair està MAL ESCRITA?", "Cuit/a" , "Courut" , "Coent" ,  "Courut" ,"Cuit/a"));
    }

    private void resetejarBotons() {
        b1.setBackgroundResource(R.drawable.boto_personalitzat_preguntes);
        b2.setBackgroundResource(R.drawable.boto_personalitzat_preguntes);
        b3.setBackgroundResource(R.drawable.boto_personalitzat_preguntes);
        b4.setBackgroundResource(R.drawable.boto_personalitzat_preguntes);
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

    private void restarvidasprota(){

        if(jugador.getVides() == 0){
        imgLiveOne.setImageResource(R.drawable.heartoff);}
        else if(jugador.getVides() == 1){
        imgLiveTwo.setImageResource(R.drawable.heartoff);}
        else if(jugador.getVides() == 2){
        imgLiveThree.setImageResource(R.drawable.heartoff);}

    }

    private void restarvidasenemic(){

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

    private void vidas(){
        //Insertar vidas al inici del joc
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
