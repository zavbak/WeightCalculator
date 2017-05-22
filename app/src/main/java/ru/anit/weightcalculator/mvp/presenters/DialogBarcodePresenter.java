package ru.anit.weightcalculator.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import ru.anit.weightcalculator.mvp.model.intities.Barcode;
import ru.anit.weightcalculator.mvp.model.intities.Product;
import ru.anit.weightcalculator.mvp.views.DialogBarcodeActivityView;
import ru.anit.weightcalculator.repository.realm.repository.IBarcodeRepository;
import ru.anit.weightcalculator.repository.realm.repository.IProductRepository;
import ru.anit.weightcalculator.ui.adapters.barcode.ItemBarcodeI;

/**
 * Created by Alex on 22.05.2017.
 */

@InjectViewState
public class DialogBarcodePresenter extends MvpPresenter<DialogBarcodeActivityView> {

    Product mProduct;
    Barcode mBarcode;

    @Inject
    IProductRepository mIProductRepository;

    @Inject
    IBarcodeRepository mIBarcodeRepository;



    public DialogBarcodePresenter() {


    }

    void init(String productId, String barcodeId){

    }

    public void refresh(){
        getViewState().refreshView();
    }


}
