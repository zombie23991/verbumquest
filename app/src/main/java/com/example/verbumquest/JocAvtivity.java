package com.example.verbumquest;

import android.content.ClipData;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.verbumquest.adapter.RecyclerAdapter;
import com.example.verbumquest.model.ItemList;

import pl.droidsonroids.gif.GifImageView;

public class JocAvtivity extends AppCompatActivity {
    private GifImageView imgResource;
    private ConstraintLayout fons;
    private TextView mundo;

    //obtenir items de la llista
    private ItemList detallItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joc);
        setTitle(getClass().getSimpleName());
        fons = findViewById(R.id.fons);

        initViews();
        initValues();
        escenari();
    }

    private void escenari(){

        if(mundo.getText().equals("Esplanada")){
            fons.setBackgroundResource(R.drawable.esplanada);
        }else if(mundo.getText().equals("Bosc")){
            fons.setBackgroundResource(R.drawable.bosc);
        }else if(mundo.getText().equals("Desert")){
            fons.setBackgroundResource(R.drawable.casa);
        }
    }

    private void initViews(){
        mundo = findViewById(R.id.mundo);
        imgResource = findViewById(R.id.gifEnemic);
    }

    private void initValues(){
        detallItem = (ItemList) getIntent().getExtras().getSerializable("detallItem");

        //extreure la informacio del Recycler View a la pantalla
        imgResource.setImageResource(detallItem.getImgResource());
        mundo.setText(detallItem.getMundo());
    }
}
