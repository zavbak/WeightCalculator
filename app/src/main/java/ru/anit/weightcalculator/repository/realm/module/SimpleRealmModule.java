package ru.anit.weightcalculator.repository.realm.module;



import io.realm.annotations.RealmModule;
import ru.anit.weightcalculator.mvp.model.intities.Barcode;
import ru.anit.weightcalculator.mvp.model.intities.Product;

/**
 * Created by roma on 15.10.15.
 */
@RealmModule(classes = {Product.class, Barcode.class})
public class SimpleRealmModule {

}
