package ru.anit.weightcalculator.repository.realm.repository.impl;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import ru.anit.weightcalculator.mvp.model.intities.Barcode;
import ru.anit.weightcalculator.mvp.model.intities.Product;
import ru.anit.weightcalculator.repository.realm.repository.IBurcodeRepository;
import ru.anit.weightcalculator.repository.realm.table.RealmTable;

/**
 * Created by Alex on 22.05.2017.
 */

public class BarcodeRepository implements IBurcodeRepository {

    Realm mRealm = Realm.getDefaultInstance();

    public BarcodeRepository(Realm realm) {
        mRealm = realm;
    }

    public <E extends RealmModel> long getNextId(Class<E> clazz) {

        long id = 1;

        try {
            id = mRealm.where(Product.class).max(RealmTable.ID).intValue() + 1;
        } catch (Exception e) {

        }

        return id;
    }

    @Override
    public void saveBarcode(Barcode barcode, OnSaveBarcodeCallback callback) {

        mRealm.executeTransaction(
                realm -> {

                    try {
                        if (barcode.getId() == 0) {
                            barcode.setId(getNextId(Product.class));
                        }
                        Barcode realmStudent = mRealm.copyToRealmOrUpdate(barcode);

                        callback.onSuccess();
                    } catch (Exception e) {
                        e.printStackTrace();
                        callback.onError(e.getMessage());
                    }


                });

    }

    @Override
    public void saveBarcodeByProduct(Barcode barcode, long productId, OnSaveBarcodeCallback callback) {


        mRealm.executeTransaction(
                realm -> {

                    try {
                        if (barcode.getId() == 0) {
                            barcode.setId(getNextId(Product.class));
                        }
                        Barcode realmBarcode = mRealm.copyToRealmOrUpdate(barcode);

                        Product product = mRealm.where(Product.class).equalTo(RealmTable.ID, productId).findFirst();
                        product.getBarcodes().add(realmBarcode);

                        callback.onSuccess();
                    } catch (Exception e) {
                        e.printStackTrace();
                        callback.onError(e.getMessage());
                    }


                });

    }

    @Override
    public void deleteBarcodeById(long id, OnDeleteBarcodeCallback callback) {
        mRealm.executeTransaction(
                realm -> {

                    try {
                        Barcode barcode = mRealm.where(Barcode.class).equalTo(RealmTable.ID, id).findFirst();
                        barcode.deleteFromRealm();
                        callback.onSuccess();
                    } catch (Exception e) {
                        e.printStackTrace();
                        callback.onError(e.getMessage());
                    }

                });
    }

    @Override
    public void getAllBarcodes(OnGetAllBarcodesCallback callback) {

        RealmQuery<Barcode> query = mRealm.where(Barcode.class);
        RealmResults<Barcode> results = query.findAll();

        if (callback != null)
            callback.onSuccess(results);

    }

    @Override
    public void getAllBarcodesByProductId(long id, OnGetBarcodesCallback callback) {
        RealmQuery<Barcode> query = mRealm.where(Barcode.class);
        Product product = mRealm.where(Product.class).equalTo(RealmTable.ID, id).findFirst();
        RealmList<Barcode> barcodes = product.getBarcodes();

        if (callback != null)
            callback.onSuccess(barcodes);
    }

    @Override
    public void getBarcodeById(long id, OnGetBarcodeByIdCallback callback) {
        Barcode barcode = mRealm.where(Barcode.class).equalTo(RealmTable.ID, id).findFirst();

        if (callback != null)
            callback.onSuccess(barcode);

    }
}
