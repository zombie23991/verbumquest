package com.example.verbumquest.adapter;

import android.content.ClipData;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.verbumquest.JocAvtivity;
import com.example.verbumquest.Mapa;
import com.example.verbumquest.MonPla;
import com.example.verbumquest.R;
import com.example.verbumquest.model.ItemList;

import java.util.List;

import pl.droidsonroids.gif.GifImageView;

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.RecyclerHolder>{
    private List<ItemList> items;
    private CardView nivell;

    public RecyclerAdapter(List<ItemList> items) {
        this.items= items;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nivell, parent, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        ItemList item = items.get(position);

            if (items.get(position).getlocked() == true) {
                holder.itemView.setEnabled(false);

            }
            else {
                holder.itemView.setEnabled(true);
            }


        holder.imgResource.setImageResource(item.getImgResource());
        holder.imgStarOne.setImageResource(item.getImgStarOne());
        holder.imgStarTwo.setImageResource(item.getImgStarTwo());
        holder.imgStarThree.setImageResource(item.getImgStarThree());
        holder.tvNpreguntes.setText(item.getNpreguntes());
        holder.mundo.setText(item.getMundo());
        holder.tvTitol.setText(item.getTitol());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), JocAvtivity.class);
                intent.putExtra("detallItem", item);
                holder.itemView.getContext().startActivity(intent);}
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class RecyclerHolder extends RecyclerView.ViewHolder{
        //imatge portada
        private GifImageView imgResource;

        //estrellas
        private ImageView imgStarOne;
        private ImageView imgStarTwo;
        private ImageView imgStarThree;

        //Text titol i nº preguntes
        private TextView tvTitol;
        private TextView tvNpreguntes;
        private TextView mundo;
        private CardView nivell;


        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            imgResource = itemView.findViewById(R.id.imgResource);
            imgStarOne = itemView.findViewById(R.id.imgStarOne);
            imgStarTwo = itemView.findViewById(R.id.imgStarTwo);
            imgStarThree = itemView.findViewById(R.id.imgStarThree);
            tvTitol = itemView.findViewById(R.id.tvTitol);
            tvNpreguntes = itemView.findViewById(R.id.tvNpreguntes);
            mundo = itemView.findViewById(R.id.mundo);
            nivell = itemView.findViewById(R.id.nivellGlobal);


        }
    }


}
