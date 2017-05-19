package ru.anit.weightcalculator.repository.realm.repository;


import io.realm.RealmResults;
import ru.anit.weightcalculator.mvp.model.intities.Product;

/**
 * Created by roma on 16.10.15.
 */
public interface IProductRepository extends IBaseRepository {

    interface OnAddProductCallback {
        void onSuccess();
        void onError(String message);
    }

    interface OnGetAllProductCallback {
        void onSuccess(RealmResults<Product> universities);
        void onError(String message);
    }

    interface OnGetProductByIdCallback {
        void onSuccess(Product Product);
        void onError(String message);
    }

    interface OnDeleteProductCallback {
        void onSuccess();
        void onError(String message);
    }

    void saveProduct(Product Product, OnAddProductCallback callback);

    void deleteProductById(long Id, OnDeleteProductCallback callback);


    void getAllProduct(OnGetAllProductCallback callback);

    void getProductById(long id, OnGetProductByIdCallback callback);
}
