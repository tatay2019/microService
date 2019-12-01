package com.example.montasar;

import java.io.Serializable;
import java.util.ArrayList;
@SuppressWarnings("serial")
public class Voyage implements Serializable {

    private int id;
    private String designation;
    private String continant;
    private byte [] image;
    private double superficie;



    public Voyage() {
    }

    public Voyage(String designation, String continant, byte[] image, double superficie) {
        this.designation = designation;
        this.continant = continant;
        this.image = image;
        this.superficie = superficie;
    }

    public Voyage(int id, String designation, String continant, byte[] image, double superficie) {
        this.id = id;
        this.designation = designation;
        this.continant = continant;
        this.image = image;
        this.superficie = superficie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getContinant() {
        return continant;
    }

    public void setContinant(String continant) {
        this.continant = continant;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }
}
