package com.example.verbumquest;

import static com.example.verbumquest.Menu.objCridarBD;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.verbumquest.adapter.RecyclerAdapter;
import com.example.verbumquest.model.ItemList;

import java.util.ArrayList;
import java.util.List;

public class Mapa extends AppCompatActivity {

    Button mon1;
    Button mon2;
    Button mon3;
    public static List<ItemList> nivellsEsplanada = new ArrayList<ItemList>();
    public static List<ItemList> nivellsBosc = new ArrayList<ItemList>();
    public static List<ItemList> nivellsDesert = new ArrayList<ItemList>();
    private cridesFirebase objCridarBD = new cridesFirebase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        mon1 = findViewById(R.id.mon1);
        mon2 = findViewById(R.id.mon2);
        mon3 = findViewById(R.id.mon3);

        //Ubicacio
        String ubicacio = "fonts/pixel.ttf";
        Typeface Tf = Typeface.createFromAsset(Mapa.this.getAssets(), ubicacio);

        //passar text a tipus de font lletra
        mon1.setTypeface(Tf);
        mon2.setTypeface(Tf);
        mon3.setTypeface(Tf);

        mon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mapa.this, monPla.class);
                startActivity(intent);
            }
        });

        mon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mapa.this, monSelva.class);
                startActivity(intent);
            }
        });

        mon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mapa.this, monDesert.class);
                startActivity(intent);
            }
        });
    }

    public void getItems() {
        //Població arrays mon Esplanada
        nivellsEsplanada.add(new ItemList("Esplanada","Lvl 1", "Preguntes totals: 5", 0, false, R.drawable.slime,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsEsplanada.add(new ItemList("Esplanada","Lvl 2", "Preguntes totals: 5", 0,false,  R.drawable.hyena,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsEsplanada.add(new ItemList("Esplanada","Lvl 3", "Preguntes totals: 5", 0,true,  R.drawable.skeleton,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsEsplanada.add(new ItemList("Esplanada","Lvl 4", "Preguntes totals: 5",0,true, R.drawable.minifire,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsEsplanada.add(new ItemList("Esplanada","Lvl 5", "Preguntes totals: 5", 0, true, R.drawable.snake,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsEsplanada.add(new ItemList("Esplanada","Lvl 6", "Preguntes totals: 5", 0,true,  R.drawable.scorpio,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsEsplanada.add(new ItemList("Esplanada","Lvl 7", "Preguntes totals: 5", 0,true,  R.drawable.centipede,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsEsplanada.add(new ItemList("Esplanada","Lvl 8", "Preguntes totals: 5",0,true, R.drawable.big_bloated,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsEsplanada.add(new ItemList("Esplanada","Lvl 9", "Preguntes totals: 5", 0,true,  R.drawable.battle_turtle,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsEsplanada.add(new ItemList("Esplanada","Lvl 10", "Preguntes totals: 5",0,true, R.drawable.mummy,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));

        //Població arrays mon Bosc
        nivellsBosc.add(new ItemList("Bosc","Lvl 1", "Preguntes totals: 10", 0 , false, R.drawable.skeleton, R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsBosc.add(new ItemList("Bosc","Lvl 2", "Preguntes totals: 10", 0 , true, R.drawable.minitree, R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsBosc.add(new ItemList("Bosc","Lvl: 3", "Preguntes totals: 5", 0 , true, R.drawable.scorpio,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsBosc.add(new ItemList("Bosc","Lvl: 4", "Preguntes totals: 5", 0 , true, R.drawable.battle_turtle,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsBosc.add(new ItemList("Bosc","Lvl 5", "Preguntes totals: 5", 0, true, R.drawable.snake,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsBosc.add(new ItemList("Bosc","Lvl 6", "Preguntes totals: 5", 0,true,  R.drawable.hyena,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsBosc.add(new ItemList("Bosc","Lvl 7", "Preguntes totals: 5", 0,true,  R.drawable.centipede,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsBosc.add(new ItemList("Bosc","Lvl 8", "Preguntes totals: 5",0,true, R.drawable.scorpio,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsBosc.add(new ItemList("Bosc","Lvl 9", "Preguntes totals: 5", 0,true,  R.drawable.battle_turtle,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsBosc.add(new ItemList("Bosc","Lvl 10", "Preguntes totals: 5",0,true, R.drawable.minotaur,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));

        nivellsDesert.add(new ItemList("Desert","Lvl: 1", "Preguntes totals: 5", 0, false, R.drawable.minifire, R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsDesert.add(new ItemList("Desert","Lvl: 2", "Preguntes totals: 5", 0, true, R.drawable.mummy, R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsDesert.add(new ItemList("Desert","Lvl: 3", "Preguntes totals: 5", 0, true, R.drawable.scorpio, R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsDesert.add(new ItemList("Desert","Lvl: 4", "Preguntes totals: 5", 0, true, R.drawable.snake, R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsDesert.add(new ItemList("Desert","Lvl 5", "Preguntes totals: 5", 0, true, R.drawable.deceased, R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsDesert.add(new ItemList("Desert","Lvl 6", "Preguntes totals: 5", 0,true,  R.drawable.mummy, R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsDesert.add(new ItemList("Desert","Lvl 7", "Preguntes totals: 5", 0,true,  R.drawable.centipede, R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsDesert.add(new ItemList("Desert","Lvl 8", "Preguntes totals: 5",0,true, R.drawable.mummy, R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsDesert.add(new ItemList("Desert","Lvl 9", "Preguntes totals: 5", 0,true,  R.drawable.battle_turtle, R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        nivellsDesert.add(new ItemList("Desert","Lvl 10", "Preguntes totals: 5",0,true, R.drawable.skeleton, R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
    }

    public List<ItemList> getArrayNivells(int mon) {
        switch (mon) {
            case 1:
                return nivellsEsplanada;
            case 2:
                return nivellsBosc;
            case 3:
                return nivellsDesert;
        }
        return null;
    }

    public void canviarEstrelles(String nomMapa, int posNivell, int puntuacio) {
        List<ItemList> nivells = new ArrayList<ItemList>();

        if(nomMapa.equals("Esplanada")) {
            nivells = nivellsEsplanada;
        } else if (nomMapa.equals("Bosc")) {
            nivells = nivellsBosc;
        } else if (nomMapa.equals("Desert")) {
            nivells = nivellsDesert;
        }

        ItemList nivell = nivells.get(posNivell);

        if (puntuacio == 0){
            nivell.setImgStarOne(R.drawable.staroff);
            nivell.setImgStarTwo(R.drawable.staroff);
            nivell.setImgStarThree(R.drawable.staroff);
        } else if(puntuacio == 1) {
            nivell.setImgStarOne(R.drawable.star);
            nivell.setImgStarTwo(R.drawable.staroff);
            nivell.setImgStarThree(R.drawable.staroff);
        } else if(puntuacio == 2) {
            nivell.setImgStarOne(R.drawable.star);
            nivell.setImgStarTwo(R.drawable.star);
            nivell.setImgStarThree(R.drawable.staroff);
        } else if(puntuacio == 3) {
            nivell.setImgStarOne(R.drawable.star);
            nivell.setImgStarTwo(R.drawable.star);
            nivell.setImgStarThree(R.drawable.star);
        }

        nivell.setPuntuacio(puntuacio);
    }


}
