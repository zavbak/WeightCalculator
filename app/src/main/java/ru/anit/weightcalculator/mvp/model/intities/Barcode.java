package ru.anit.weightcalculator.mvp.model.intities;

/**
 * Created by user on 19.05.2017.
 */

public class Barcode {
    String barcode;
    float  weight;
    int  sites;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getSites() {
        return sites;
    }

    public void setSites(int sites) {
        this.sites = sites;
    }
}
