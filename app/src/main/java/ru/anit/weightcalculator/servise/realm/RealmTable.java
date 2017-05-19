package ru.anit.weightcalculator.servise.realm;

public interface RealmTable {

    String ID = "id";

    interface Product {
        String NAME        = "name";
        String STRAT       = "startPosition";
        String FINISH      = "finishPosition";
        String COEFFICIENT = "coefficient";
        String BARCODE     = "initialBarcode";
    }

    interface Student{
        String NAME = "name";
        String AGE = "age";
        String EMAIL = "email";
        String BOOKS = "books";
        String LESSONS = "lessons";
    }
}
