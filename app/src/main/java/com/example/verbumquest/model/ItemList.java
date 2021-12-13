package com.example.verbumquest.model;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class ItemList  implements Serializable {
    private String titol;
    private String npreguntes;
    private int imgResource;
    private int imgStarOne;
    private int imgStarTwo;
    private int imgStarThree;


    //Creem els getters per extreure informació
    //El ordre sera com es tindra que declarar al crear un nivell
    public ItemList(String titol, String npreguntes,int imgResource, int imgStarOne, int imgStarTwo, int imgStarThree) {
        this.titol = titol;
        this.npreguntes = npreguntes;
        this.imgResource = imgResource;
        this.imgStarOne = imgStarOne;
        this.imgStarTwo = imgStarTwo;
        this.imgStarThree = imgStarThree;
    }

    public String getTitol() {
        return titol;
    }

    public String getNpreguntes() {
        return npreguntes;
    }

    public int getImgResource() {
        return imgResource;
    }

    public int getImgStarOne() {
        return imgStarOne;
    }

    public int getImgStarTwo() {
        return imgStarTwo;
    }

    public int getImgStarThree() {
        return imgStarThree;
    }

}
