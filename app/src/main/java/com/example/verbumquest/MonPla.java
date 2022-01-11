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
    private RecyclerView rvLlista;
    private RecyclerAdapter adapter;
    private List<ItemList> items;
    private RecyclerView block;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monpla);

        //Crida de procesos
        initViews();
        initValues();
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

        itemLists.add(new ItemList("Esplanada","Lvl 1", "Preguntes totals: 10", 0 , false, R.drawable.slime,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Esplanada","Lvl 2", "Preguntes totals: 10", 0,true,  R.drawable.minitree,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Esplanada","Lvl 3", "Preguntes totals: 10", 0,true,  R.drawable.skeleton,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Esplanada","Lvl 4", "Preguntes totals: 10",0,true, R.drawable.minifire,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        return itemLists;
    }

}
