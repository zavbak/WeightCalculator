package ru.anit.weightcalculator.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;

import ru.anit.weightcalculator.mvp.model.intities.Product;
import ru.anit.weightcalculator.mvp.views.BarcodeListActivityView;
import ru.anit.weightcalculator.ui.adapters.barcode.ItemBarcode;
import ru.anit.weightcalculator.ui.adapters.barcode.ItemBarcodeI;

/**
 * Created by Alex on 17.05.2017.
 */

@InjectViewState
public class BarcodeListActivityPresenter extends MvpPresenter<BarcodeListActivityView> {
    Product mProduct;



    public void setProduct(String id) {
        mProduct = new Product();
        mProduct.setName("Свинина");
        mProduct.setInitBarcode("65456456456165156156156");
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

    public List getListBarcode() {
        List list = new ArrayList<ItemBarcodeI>();
        ItemBarcodeI item = new ItemBarcode("1","654564564564654","100","15");
        list.add(item);

        item = new ItemBarcode("2","654564564564654","10","3");
        list.add(item);

        item = new ItemBarcode("3","654564564564654","18","17");
        list.add(item);


        item = new ItemBarcode("3","654564564564654","18","17");
        list.add(item);

        item = new ItemBarcode("3","654564564564654","18","17");
        list.add(item);

        item = new ItemBarcode("3","654564564564654","18","17");
        list.add(item);


        item = new ItemBarcode("3","654564564564654","18","17");
        list.add(item);

        return list;
    }

    public void clickItem(String id) {
        getViewState().startDilogBarcode(id);
    }

    public void clickFabPresenter() {
        getViewState().startDilogBarcode(null);
    }

    public void dialogBarcodePositive(String weight) {

    }
}
