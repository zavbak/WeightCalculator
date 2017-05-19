package ru.anit.weightcalculator.ui.adapters.barcode;


public class ItemBarcode implements ItemBarcodeI {


    CharSequence mSites;
    CharSequence mWeight;
    CharSequence mBarcode;
    String mId;

    public ItemBarcode(String id,CharSequence barcode,CharSequence weight, CharSequence sites) {
        mSites = sites;
        mWeight = weight;
        mId = id;
        mBarcode = barcode;
    }

    @Override
    public CharSequence getSites() {
        return mSites;
    }

    @Override
    public CharSequence getWeight() {
        return mWeight;
    }

    @Override
    public CharSequence getBarcode() {
        return mBarcode;
    }

    @Override
    public String getId() {
        return mId;
    }
}
