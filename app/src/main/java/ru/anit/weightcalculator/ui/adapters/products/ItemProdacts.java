package ru.anit.weightcalculator.ui.adapters.products;



public class ItemProdacts implements ItemProdactsI {

    CharSequence mName;
    CharSequence mSites;
    CharSequence mWeight;
    String mId;

    public ItemProdacts(String id,CharSequence name, CharSequence weight, CharSequence sites) {
        mName = name;
        mSites = sites;
        mWeight = weight;
        mId = id;
    }

    @Override
    public CharSequence getName() {
        return mName;
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
    public String getId() {
        return mId;
    }
}
