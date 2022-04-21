package com.example.verbumquest.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.verbumquest.JocActivity;
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

        item.setImgStarOne(R.drawable.staroff);
        item.setImgStarTwo(R.drawable.staroff);
        item.setImgStarThree(R.drawable.staroff);

        if(item.getPuntuacio() == 1) {
            item.setImgStarOne(R.drawable.star);
        }

        else if (item.getPuntuacio() == 2) {
            item.setImgStarOne(R.drawable.star);
            item.setImgStarTwo(R.drawable.star);
        }

        else if(item.getPuntuacio() == 3) {
            item.setImgStarOne(R.drawable.star);
            item.setImgStarTwo(R.drawable.star);
            item.setImgStarThree(R.drawable.star);
        }

        bloquejarnivells(item, position);

            // en cas de que el nivell no es pugui jugar
            if (items.get(position).getlocked() == true) {
                holder.itemView.setEnabled(false);
                holder.imgResource2.setImageResource(R.drawable.candau);
                holder.imgResource.setImageResource(0);
                holder.imgStarOne.setImageResource(0);
                holder.imgStarTwo.setImageResource(0);
                holder.imgStarThree.setImageResource(0);
                holder.tvNpreguntes.setText(null);
                holder.mundo.setText(null);
                holder.tvTitol.setText(null);
            }
            //en cas de que el nivell si que es pugui jugar
            else {
                holder.itemView.setEnabled(true);
                holder.imgResource2.setImageResource(R.drawable.espasa);
                holder.imgResource.setImageResource(item.getImgResource());
                holder.imgStarOne.setImageResource(item.getImgStarOne());
                holder.imgStarTwo.setImageResource(item.getImgStarTwo());
                holder.imgStarThree.setImageResource(item.getImgStarThree());
                holder.tvNpreguntes.setText(item.getNpreguntes());
                holder.mundo.setText(item.getMundo());
                holder.tvTitol.setText(item.getTitol());

                //si es torre fa el fons diferent
                if (holder.mundo.getText() == "Torre"){
                    holder.imgResource2.setImageResource(R.drawable.torreespasa);

                }
            }


        final int posicio = position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), JocActivity.class);
                intent.putExtra("detallItem", item);
                intent.putExtra("pos",posicio);
                holder.itemView.getContext().startActivity(intent);
            }

        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    private void bloquejarnivells(ItemList item, int position) {

        if(position == 0) {
            items.get(0).setLocked(false);
        } else if(position == items.size() && items.get(position - 1).getPuntuacio() > 0) {
                 items.get(position).setLocked(false);
        }
        else if(items.get(position - 1).getPuntuacio() > 0 ) {
            items.get(position).setLocked(false);
        }
    }


    public static class RecyclerHolder extends RecyclerView.ViewHolder{

        //Element visual si el nivell esta bloquejat
        public ImageView imgResource2;

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
            imgResource2 = itemView.findViewById(R.id.imgResource2);
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
