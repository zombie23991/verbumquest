package com.example.verbumquest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.verbumquest.adapter.RecyclerAdapter;
import com.example.verbumquest.model.ItemList;

import java.util.ArrayList;
import java.util.List;

public class monDesert extends AppCompatActivity {
    private RecyclerView rvLlista;
    private RecyclerAdapter adapter;
    private List<ItemList> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_desert);

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
        int a = 0;

        itemLists.add(new ItemList("Desert","Lvl:", "Preguntes totals: 10", R.drawable.slime,R.drawable.star, R.drawable.star, R.drawable.star));
        itemLists.add(new ItemList("Desert","Lvl:", "Preguntes totals: 10", R.drawable.adventurer,R.drawable.star, R.drawable.star, R.drawable.star));
        itemLists.add(new ItemList("Desert","Lvl:", "Preguntes totals: 10", R.drawable.skeleton,R.drawable.star, R.drawable.star, R.drawable.star));
        itemLists.add(new ItemList("Desert","Lvl:", "Preguntes totals: 10", R.drawable.adventurer,R.drawable.star, R.drawable.star, R.drawable.star));
        itemLists.add(new ItemList("Desert","Lvl:" + a, "Preguntes totals: 10", R.drawable.slime,R.drawable.star, R.drawable.star, R.drawable.star));
        return itemLists;
    }

}

