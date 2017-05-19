package ru.anit.weightcalculator.ui.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import ru.anit.weightcalculator.R;
import ru.anit.weightcalculator.mvp.model.intities.Barcode;
import ru.anit.weightcalculator.mvp.model.intities.Product;
import ru.anit.weightcalculator.ui.adapters.barcode.ItemBarcode;

/**
 * Created by user on 19.05.2017.
 */

public class DialogBarcode {

    Context mContext;
    Product mProduct;
    Barcode mBarcode;
    AlertDialog.Builder mBuilder;
    AlertDialog mAlertDialog;

    public DialogBarcode(Context context, Product product, Barcode barcode) {
        mContext = context;
        mProduct = product;
        mBarcode = barcode;
    }

    void init(){

        LayoutInflater li = LayoutInflater.from(mContext);
        View view = li.inflate(R.layout.dialog_barcode, null);


        mBuilder = new AlertDialog.Builder(mContext);

        mBuilder.setView(view);


        mBuilder
                .setTitle("Титл")
                .setMessage("Мессадже")
                .setPositiveButton("OK", (dialog, which) -> {})
                .setNegativeButton("Cancel",(dialog, which) -> {})
                .setCancelable(false);

    }


    public void show() {
        init();
        mAlertDialog = mBuilder.create();
        mAlertDialog.show();
    }

    public void dismiss() {
        if(mAlertDialog != null){
            mAlertDialog.dismiss();
        }
    }


}
