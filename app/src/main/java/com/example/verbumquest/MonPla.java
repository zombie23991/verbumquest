package com.example.verbumquest;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.verbumquest.adapter.RecyclerAdapter;
import com.example.verbumquest.model.ItemList;

import java.util.ArrayList;
import java.util.List;

public class MonPla extends AppCompatActivity {
    public static RecyclerView rvLlista;
    private RecyclerAdapter adapter;
    public static List<ItemList> items;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monpla);

        //Crida de procesos
        initViews();
        initValues();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        adapter.notifyDataSetChanged();
    }


    //Declarar vistas
    private void initViews() {
        rvLlista = findViewById(R.id.rvLlista);
    }

    //Declarar valors
    private void initValues() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvLlista.setLayoutManager(manager);

        items = getItems();
        adapter = new RecyclerAdapter(items);
        rvLlista.setAdapter(adapter);
    }

    //Creacio de nivells
    private List<ItemList> getItems() {
        List<ItemList> itemLists = new ArrayList<>();

        itemLists.add(new ItemList("Esplanada","Lvl 1", "Preguntes totals: 5", 0, false, R.drawable.slime,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Esplanada","Lvl 2", "Preguntes totals: 5", 0,false,  R.drawable.hyena,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Esplanada","Lvl 3", "Preguntes totals: 5", 0,false,  R.drawable.skeleton,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Esplanada","Lvl 4", "Preguntes totals: 5",0,false, R.drawable.minifire,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));

        itemLists.add(new ItemList("Esplanada","Lvl 5", "Preguntes totals: 5", 0, false, R.drawable.snake,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Esplanada","Lvl 6", "Preguntes totals: 5", 0,false,  R.drawable.scorpio,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Esplanada","Lvl 7", "Preguntes totals: 5", 0,false,  R.drawable.centipede,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Esplanada","Lvl 8", "Preguntes totals: 5",0,false, R.drawable.big_bloated,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Esplanada","Lvl 9", "Preguntes totals: 5", 0,false,  R.drawable.battle_turtle,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Esplanada","Lvl 10", "Preguntes totals: 5",0,false, R.drawable.mummy,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        return itemLists;
    }

}
