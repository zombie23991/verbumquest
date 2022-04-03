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

public class monSelva extends Mapa {
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

    protected void initViews() {
        rvLlista = findViewById(R.id.rvLlista);
    }

    //Declarar valors
    protected void initValues() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvLlista.setLayoutManager(manager);
        adapter = new RecyclerAdapter(getArrayNivells(3));

        rvLlista.setAdapter(adapter);
    }
}
