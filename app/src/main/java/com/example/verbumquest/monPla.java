package com.example.verbumquest;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.verbumquest.adapter.RecyclerAdapter;
import com.example.verbumquest.model.ItemList;

import java.util.ArrayList;
import java.util.List;

public class monPla extends Mapa {
    public static RecyclerView rvLlista;
    private RecyclerAdapter adapter;
    public static List<ItemList> nivells = new ArrayList<ItemList>();
    private cridesFirebase objCridarBD = new cridesFirebase();

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

    protected void initViews() {
        rvLlista = findViewById(R.id.rvLlista);
    }

    //Declarar valors
    protected void initValues() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvLlista.setLayoutManager(manager);
        adapter = new RecyclerAdapter(getArrayNivells(1));

        rvLlista.setAdapter(adapter);
    }

}
