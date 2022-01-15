package com.example.verbumquest.model;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class ItemList  implements Serializable {
    private String titol;
    private String npreguntes;
    private String mundo;
    private int imgResource;




    private int imgStarOne;
    private int imgStarTwo;
    private int imgStarThree;
    private int puntuacio;
    private boolean locked;

    //Creem els getters per extreure informació
    //El ordre sera com es tindra que declarar al crear un nivell
    public ItemList(String mundo ,String titol, String npreguntes, int puntuacio, boolean locked,  int imgResource, int imgStarOne, int imgStarTwo, int imgStarThree) {
        this.titol = titol;
        this.npreguntes = npreguntes;
        this.imgResource = imgResource;
        this.imgStarOne = imgStarOne;
        this.puntuacio = puntuacio;
        this.imgStarTwo = imgStarTwo;
        this.imgStarThree = imgStarThree;
        this.locked = locked;
        this.mundo = mundo;
        this.puntuacio = 0;
    }

    public String getTitol() {
        return titol;
    }

    public String getMundo() {
        return mundo;
    }

    public String getNpreguntes() {
        return npreguntes;
    }

    public boolean getlocked() {
        return locked;
    }

    public void setPuntuacio(int puntuacio) {
        this.puntuacio = puntuacio;
    }

    public int getPuntuacio() {
        return puntuacio;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
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

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

    public void setImgStarOne(int imgStarOne) {
        this.imgStarOne = imgStarOne;
    }

    public void setImgStarTwo(int imgStarTwo) {
        this.imgStarTwo = imgStarTwo;
    }

    public void setImgStarThree(int imgStarThree) {
        this.imgStarThree = imgStarThree;
    }

}
