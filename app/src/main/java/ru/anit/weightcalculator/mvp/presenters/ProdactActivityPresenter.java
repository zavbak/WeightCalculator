package ru.anit.weightcalculator.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.anit.weightcalculator.mvp.model.intities.Product;
import ru.anit.weightcalculator.mvp.views.ProdactActivityView;

/**
 * Created by Alex on 17.05.2017.
 */

@InjectViewState
public class ProdactActivityPresenter extends MvpPresenter<ProdactActivityView> {
    Product mProduct;

    public void setProduct(String id) {
        mProduct = new Product();
        mProduct.setName("Свинина");
        mProduct.setBarcode("65456456456165156156156");
        mProduct.setId(Long.parseLong(id));
        mProduct.setStartPosition(5);
        mProduct.setFinishPosition(10);
        mProduct.setCoefficient(Float.parseFloat("0.01"));
    }


    public CharSequence getId() {
        return  Long.toString(mProduct.getId());
    }

    public void refreshPresenter() {
        getViewState().refreshView();
    }

    public void startBarcodeListActivityPresenter() {
        getViewState().startBarcodeListActivityView(Long.toString(mProduct.getId()));
    }

    public void onClickCalculate() {
        startBarcodeListActivityPresenter();
    }

    public void onClickCancel() {
        getViewState().finishView();
    }
}
