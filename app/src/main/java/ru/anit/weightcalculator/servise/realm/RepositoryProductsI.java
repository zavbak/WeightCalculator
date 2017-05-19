package ru.anit.weightcalculator.servise.realm;

import io.realm.RealmResults;
import ru.anit.weightcalculator.mvp.model.intities.Product;


/**
 * Created by Alex on 15.05.2017.
 */

public interface RepositoryProductsI {
    RealmResults<Product> getListProductsAll();
    long save(Product product);
    Product getProductById(long id);
}
