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
    public static RecyclerView rvLlista;
    private RecyclerAdapter adapter;
    public static List<ItemList> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torre);
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

        itemLists.add(new ItemList("Torre","Lvl 1", "Preguntes totals: 10",0 ,false ,  R.drawable.minotaur,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Torre","Lvl 2", "Preguntes totals: 10",0 ,true ,  R.drawable.big_bloated,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Torre","Lvl 3", "Preguntes totals: 10",0 ,true ,  R.drawable.battle_turtle,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        return itemLists;
    }

}
