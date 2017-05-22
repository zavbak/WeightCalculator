package ru.anit.weightcalculator.ui.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
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

    ClickPositiveI mClickPositive;
    ClickNegativeI mClickNegative;

    @BindView(R.id.tilWeight)
    TextInputLayout tilId;

    public DialogBarcode(Context context, Product product, Barcode barcode,
                         ClickPositiveI clickPositive, ClickNegativeI clickNegative ) {

        mContext = context;
        mProduct = product;
        mBarcode = barcode;
        mClickPositive = clickPositive;
        mClickNegative = clickNegative;


    }

    void init(){

        LayoutInflater li = LayoutInflater.from(mContext);
        View view = li.inflate(R.layout.dialog_barcode, null);

        ButterKnife.bind(this,view);

        mBuilder = new AlertDialog.Builder(mContext);

        mBuilder.setView(view);


        mBuilder
                .setTitle("Титл")
                .setMessage("Мессадже")
                .setPositiveButton("OK", (dialog, which) -> {mClickPositive.onClickPositive(tilId.getEditText().getText().toString(),"");})
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

    public interface ClickPositiveI{
        void onClickPositive(String weight, String sites);
    }

    public interface ClickNegativeI{
        void onClickNegative();
    }


}
