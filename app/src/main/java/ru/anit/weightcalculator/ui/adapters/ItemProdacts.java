package ru.anit.weightcalculator.ui.adapters;



public class ItemProdacts implements ItemProdactsI {

    CharSequence mName;
    CharSequence mSites;
    CharSequence mWeight;

    public ItemProdacts(CharSequence name, CharSequence weight, CharSequence sites) {
        mName = name;
        mSites = sites;
        mWeight = weight;
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
}
