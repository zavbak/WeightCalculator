package ru.anit.weightcalculator.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpDialogFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.anit.weightcalculator.R;
import ru.anit.weightcalculator.mvp.model.intities.Barcode;
import ru.anit.weightcalculator.mvp.model.intities.Product;
import ru.anit.weightcalculator.mvp.presenters.BarcodeDialogPresenter;
import ru.anit.weightcalculator.mvp.views.BarcodeDialogView;
import ru.anit.weightcalculator.mvp.views.ProdactActivityView;
import ru.anit.weightcalculator.ui.activityes.ProductActivity;

/**
 * Created by Alex on 22.05.2017.
 */

public class DFBarcode extends MvpDialogFragment implements BarcodeDialogView {

    @InjectPresenter
    BarcodeDialogPresenter mPresenter;

    @BindView(R.id.tilWeight)
    TextInputLayout tilWeight;


    public void setBarcode(Barcode barcode) {
        mPresenter.setBarcode(barcode);
    }

    public void setProduct(Product product) {
       mPresenter.setProduct(product);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_barcode, null);
        getDialog().setTitle("Title!!!");
        ButterKnife.bind(this,view);

        //tilWeight.getEditText().setText(Float.toString(mBarcode.getWeight()));

        return view;
    }

    @Override
    public void refresh() {

    }
}
