package com.example.verbumquest;

import android.content.ClipData;
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

public class monSelva extends AppCompatActivity {
    public static RecyclerView rvLlista;
    private RecyclerAdapter adapter;
    public static List<ItemList> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_selva);

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

        itemLists.add(new ItemList("Bosc","Lvl 1", "Preguntes totals: 10", 0 , false, R.drawable.skeleton, R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Bosc","Lvl 2", "Preguntes totals: 10", 0 , true, R.drawable.minitree, R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Bosc","Lvl: 3", "Preguntes totals: 5", 0 , true, R.drawable.scorpio,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Bosc","Lvl: 4", "Preguntes totals: 5", 0 , true, R.drawable.battle_turtle,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));

        itemLists.add(new ItemList("Bosc","Lvl 5", "Preguntes totals: 5", 0, true, R.drawable.snake,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Bosc","Lvl 6", "Preguntes totals: 5", 0,true,  R.drawable.hyena,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Bosc","Lvl 7", "Preguntes totals: 5", 0,true,  R.drawable.centipede,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Bosc","Lvl 8", "Preguntes totals: 5",0,true, R.drawable.scorpio,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Bosc","Lvl 9", "Preguntes totals: 5", 0,true,  R.drawable.battle_turtle,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Bosc","Lvl 10", "Preguntes totals: 5",0,true, R.drawable.minotaur,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        return itemLists;
    }
}
