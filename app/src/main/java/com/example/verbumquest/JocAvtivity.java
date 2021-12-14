package com.example.verbumquest;

import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
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
    private GifImageView imgResource;
    private ImageView fons;
    private ArrayList<preguntes> questionList;
    private TextView tvQuestions, tvScore, tvTimer, tvQuestionNo;
    private Button b1, b2,b3,b4;
    Random random;
    int currentScore = 0, questionAttempted = 1, currentPos;

    //obtenir items de la llista
    private ItemList detallItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joc);
        setTitle(getClass().getSimpleName());

        initViews();
        initValues();

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

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questionList.get(currentPos).getCorrectAnsNo().equals(b1.getText().toString())) {
                    currentPos = random.nextInt(questionList.size());
                    setDataToViews(currentPos);
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questionList.get(currentPos).getCorrectAnsNo().equals(b2.getText().toString())) {
                    currentPos = random.nextInt(questionList.size());
                    setDataToViews(currentPos);
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questionList.get(currentPos).getCorrectAnsNo().equals(b3.getText().toString())) {
                    currentPos = random.nextInt(questionList.size());
                    setDataToViews(currentPos);
                }
            }
        });


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questionList.get(currentPos).getCorrectAnsNo().equals(b4.getText().toString())) {
                    currentPos = random.nextInt(questionList.size());
                    setDataToViews(currentPos);
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
        questionList.add(new preguntes("A is correct", "A" , "B" , "C" , "D" , "A"));
        questionList.add(new preguntes("B is correct", "A" , "B" , "C" ,  "D" ,"B"));
        questionList.add(new preguntes("C is correct", "A" , "B" , "C" ,  "D" ,"C"));
        questionList.add(new preguntes("D is correct", "A" , "B" , "C" ,  "D" ,"D"));

    }


    private void initViews(){
        imgResource = findViewById(R.id.gifEnemic);
    }

    private void initValues(){
        detallItem = (ItemList) getIntent().getExtras().getSerializable("detallItem");

        //extreure la informacio del Recycler View a la pantalla
        imgResource.setImageResource(detallItem.getImgResource());
    }
}
