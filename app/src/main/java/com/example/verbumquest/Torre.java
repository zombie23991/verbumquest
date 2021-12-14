package com.example.verbumquest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.verbumquest.adapter.RecyclerAdapter;
import com.example.verbumquest.model.ItemList;

import java.util.ArrayList;
import java.util.List;

public class Torre extends AppCompatActivity {
    private RecyclerView rvLlista;
    private RecyclerAdapter adapter;
    private List<ItemList> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torre);
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

        itemLists.add(new ItemList("Lvl 1", "Preguntes totals: 10", R.drawable.slime,R.drawable.star, R.drawable.star, R.drawable.star));
        itemLists.add(new ItemList("Lvl 2", "Preguntes totals: 10", R.drawable.adventurer,R.drawable.star, R.drawable.star, R.drawable.star));
        itemLists.add(new ItemList("Lvl 3", "Preguntes totals: 10", R.drawable.skeleton,R.drawable.star, R.drawable.star, R.drawable.star));
        itemLists.add(new ItemList("Lvl 4", "Preguntes totals: 10", R.drawable.adventurer,R.drawable.star, R.drawable.star, R.drawable.star));
        itemLists.add(new ItemList("Lvl 5", "Preguntes totals: 10", R.drawable.slime,R.drawable.star, R.drawable.star, R.drawable.star));
        return itemLists;
    }

}
