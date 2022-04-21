package com.example.verbumquest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.verbumquest.adapter.RecyclerAdapter;
import com.example.verbumquest.model.ItemList;

import java.util.ArrayList;
import java.util.List;

public class monDesert extends Mapa{
    private RecyclerAdapter adapter;
    public static RecyclerView rvLlista;

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

    // Declarar vistes
    protected void initViews() {
        rvLlista = findViewById(R.id.rvLlista);
    }

    // Declarar valors
    protected void initValues() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvLlista.setLayoutManager(manager);
        adapter = new RecyclerAdapter(getArrayNivells(2));

        rvLlista.setAdapter(adapter);
    }
}

