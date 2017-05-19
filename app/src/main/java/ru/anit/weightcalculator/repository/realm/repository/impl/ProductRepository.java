package ru.anit.weightcalculator.repository.realm.repository.impl;


import android.support.annotation.NonNull;

import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import ru.anit.weightcalculator.mvp.model.intities.Product;
import ru.anit.weightcalculator.repository.realm.repository.IProductRepository;
import ru.anit.weightcalculator.repository.realm.table.RealmTable;

/**
 * Created by roma on 16.10.15.
 */
public class ProductRepository implements IProductRepository {

    Realm mRealm = Realm.getDefaultInstance();

    public ProductRepository(Realm realm) {
        mRealm = realm;
    }

    private <E extends RealmModel> long getNextId(Class<E> clazz) {

        long id = 1;

        try {
            id = mRealm.where(Product.class).max(RealmTable.ID).intValue() + 1;
        } catch (Exception e) {

        }

        return id;
    }

    @Override
    public void saveProduct(Product product, @NonNull OnAddProductCallback callback) {


        mRealm.executeTransaction(
                realm -> {

                    try {
                        if (product.getId() == 0) {
                            product.setId(getNextId(Product.class));
                        }
                        Product realmStudent = mRealm.copyToRealmOrUpdate(product);

                        callback.onSuccess();
                    } catch (Exception e) {
                        e.printStackTrace();
                        callback.onError(e.getMessage());
                    }


                });
    }


    @Override
    public void deleteProductById(long Id, OnDeleteProductCallback callback) {

        mRealm.executeTransaction(
                realm -> {

                    try {
                        Product product = mRealm.where(Product.class).equalTo(RealmTable.ID, Id).findFirst();
                        product.deleteFromRealm();
                        callback.onSuccess();
                    } catch (Exception e) {
                        e.printStackTrace();
                        callback.onError(e.getMessage());
                    }


                });

    }


    @Override
    public void getAllProduct(OnGetAllProductCallback callback) {

        RealmQuery<Product> query = mRealm.where(Product.class);
        RealmResults<Product> results = query.findAll();

        if (callback != null)
            callback.onSuccess(results);

    }

    @Override
    public void getProductById(long id, OnGetProductByIdCallback callback) {


        Product result = mRealm.where(Product.class).equalTo(RealmTable.ID, id).findFirst();

        if (callback != null)
            callback.onSuccess(result);

    }
}
