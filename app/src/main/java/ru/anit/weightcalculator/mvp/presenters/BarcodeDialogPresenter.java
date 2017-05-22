package ru.anit.weightcalculator.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.anit.weightcalculator.mvp.model.intities.Barcode;
import ru.anit.weightcalculator.mvp.model.intities.Product;
import ru.anit.weightcalculator.mvp.views.BarcodeDialogView;


@InjectViewState
public class BarcodeDialogPresenter extends MvpPresenter<BarcodeDialogView> {

    Barcode mBarcode;
    Product mProduct;

    public Barcode getBarcode() {
        return mBarcode;
    }

    public void setBarcode(Barcode barcode) {
        mBarcode = barcode;
    }

    public Product getProduct() {
        return mProduct;
    }

    public void setProduct(Product product) {
        mProduct = product;
    }

    public void refresh(){
        getViewState().refresh();
    }

}
