package ru.anit.weightcalculator.mvp.model.intities;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Product extends RealmObject  {


    @PrimaryKey
    private long id;
    private String name;
    private int startPosition;
    private int finishPosition;
    private float coefficient;
    private String initBarcode;

    private RealmList<Barcode> barcodes;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getFinishPosition() {
        return finishPosition;
    }

    public void setFinishPosition(int finishPosition) {
        this.finishPosition = finishPosition;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public String getInitBarcode() {
        return initBarcode;
    }

    public void setInitBarcode(String initBarcode) {
        this.initBarcode = initBarcode;
    }

    public RealmList<Barcode> getBarcodes() {
        return barcodes;
    }

    public void setBarcodes(RealmList<Barcode> barcodes) {
        this.barcodes = barcodes;
    }
}
