package ru.anit.weightcalculator.repository.realm.repository;



import io.realm.RealmList;
import io.realm.RealmResults;
import ru.anit.weightcalculator.mvp.model.intities.Barcode;

/**
 * Created by roma on 16.10.15.
 */
public interface IBurcodeRepository {

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

    void addBarcode(Barcode Barcode, OnSaveBarcodeCallback callback);

    void addBarcodeByProduct(Barcode Barcode, long barcodeId, OnSaveBarcodeCallback callback);

    void deleteBarcodeById(long id, OnDeleteBarcodeCallback callback);

    void deleteBarcodeByPosition(int position, OnDeleteBarcodeCallback callback);

    void getAllBarcodes(OnGetAllBarcodesCallback callback);

    void getAllBarcodesByProductId(long id, OnGetBarcodesCallback callback);

    void getBarcodeById(long id, OnGetBarcodeByIdCallback callback);

}
