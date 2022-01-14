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
    private RecyclerAdapter adapter;
    public static RecyclerView rvLlista;
    public static List<ItemList> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_desert);

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
        itemLists.add(new ItemList("Desert","Lvl: 1", "Preguntes totals: 6", 0 , false, R.drawable.minifire,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Desert","Lvl: 2", "Preguntes totals: 6", 0 , true, R.drawable.skeleton,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Desert","Lvl: 3", "Preguntes totals: 6", 0 , true, R.drawable.minifire,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Desert","Lvl: 4", "Preguntes totals: 6", 0 , true, R.drawable.skeleton,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Desert","Lvl: 5", "Preguntes totals: 6", 0 , true, R.drawable.minifire,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Desert","Lvl: 6", "Preguntes totals: 6", 0 , true, R.drawable.skeleton,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Desert","Lvl: 1", "Preguntes totals: 5", 0 , true, R.drawable.minifire,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Desert","Lvl: 2", "Preguntes totals: 5", 0 , true, R.drawable.mummy,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Desert","Lvl: 3", "Preguntes totals: 5", 0 , true, R.drawable.scorpio,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Desert","Lvl: 4", "Preguntes totals: 5", 0 , true, R.drawable.snake,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));

        itemLists.add(new ItemList("Desert","Lvl 5", "Preguntes totals: 5", 0, true, R.drawable.deceased,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Desert","Lvl 6", "Preguntes totals: 5", 0,true,  R.drawable.mummy,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Desert","Lvl 7", "Preguntes totals: 5", 0,true,  R.drawable.centipede,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Desert","Lvl 8", "Preguntes totals: 5",0,true, R.drawable.mummy,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Desert","Lvl 9", "Preguntes totals: 5", 0,true,  R.drawable.battle_turtle,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        itemLists.add(new ItemList("Desert","Lvl 10", "Preguntes totals: 5",0,true, R.drawable.skeleton,R.drawable.staroff, R.drawable.staroff, R.drawable.staroff));
        return itemLists;
    }
//jkasdfbfasfjasfasfjnoñasqñfksokñfl
}

