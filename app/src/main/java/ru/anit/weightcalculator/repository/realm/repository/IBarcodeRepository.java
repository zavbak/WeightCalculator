package ru.anit.weightcalculator.repository.realm.repository;



import io.realm.RealmList;
import io.realm.RealmResults;
import ru.anit.weightcalculator.mvp.model.intities.Barcode;

/**
 * Created by roma on 16.10.15.
 */
public interface IBarcodeRepository {

    interface OnSaveBarcodeCallback {
        void onSuccess();
        void onError(String message);
    }

    interface OnDeleteBarcodeCallback {
        void onSuccess();
        void onError(String message);
    }

    interface OnGetBarcodeByIdCallback {
        void onSuccess(Barcode Barcode);
        void onError(String message);
    }

    interface OnGetAllBarcodesCallback {
        void onSuccess(RealmResults<Barcode> Barcodes);
        void onError(String message);
    }

    interface OnGetBarcodesCallback{
        void onSuccess(RealmList<Barcode> Barcodes);
        void onError(String message);
    }

    void saveBarcode(Barcode barcode, OnSaveBarcodeCallback callback);

    void saveBarcodeByProduct(Barcode Barcode, long productId, OnSaveBarcodeCallback callback);

    void deleteBarcodeById(long id, OnDeleteBarcodeCallback callback);

    void getAllBarcodes(OnGetAllBarcodesCallback callback);

    void getAllBarcodesByProductId(long id, OnGetBarcodesCallback callback);

    void getBarcodeById(long id, OnGetBarcodeByIdCallback callback);

}
