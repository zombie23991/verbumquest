package com.example.verbumquest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.verbumquest.adapter.RecyclerAdapter;

public class JocAvtivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monpla);
        setTitle(getClass().getSimpleName());

        //Per cridar cuncions del XML
        initViews();
        initValues();
    }

    //Declarar vistas
    private void initViews() {

    }

    //Declarar valors
    private void initValues() {

    }
}
