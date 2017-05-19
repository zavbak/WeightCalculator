package ru.anit.weightcalculator.servise.realm;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.anit.weightcalculator.mvp.model.intities.Product;


/**
 * Created by Alex on 15.05.2017.
 */

public class RepositoryProductsRealm implements RepositoryProductsI{


    Realm mRealm;

    public RepositoryProductsRealm(Realm realm) {
        mRealm = realm;
    }

    @Override
    public RealmResults<Product> getListProductsAll() {
        return mRealm.where(Product.class).findAll();
    }

    private void setId(Product product){
        if(product.getId() == 0){
            long id;

            try {
                id = mRealm.where(Product.class).max("id").intValue() + 1;
            } catch (Exception e) {
                id = 1;
            }

            product.setId(id);
        }
    }

    @Override
    public long save(Product product) {

        Product realmProduct;
        realmProduct = null;

        try {

            mRealm.beginTransaction();
            setId(product);
            realmProduct = mRealm.copyToRealmOrUpdate(product);

            mRealm.commitTransaction();
            mRealm.close();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

        return realmProduct.getId();
    }

    @Override
    public Product getProductById(long id) {

        try {
            return mRealm.where(Product.class).equalTo(RealmTable.ID, id).findFirst();
        } catch (Exception e) {
            return null;
        }

    }
}
