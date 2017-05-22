package ru.anit.weightcalculator.ui.activityes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.anit.weightcalculator.R;
import ru.anit.weightcalculator.mvp.presenters.ProdactActivityPresenter;
import ru.anit.weightcalculator.mvp.views.ProdactActivityView;

/**
 * Created by Alex on 17.05.2017.
 */

public class ProductActivity extends MvpAppCompatActivity implements ProdactActivityView {

    public static String ID = "id";

    @BindView(R.id.tilId)
    TextInputLayout tilId;

    @BindView(R.id.tilName)
    TextInputLayout tilName;


    public static Intent getIntent(final Context context, String id) {
        Intent intent = new Intent(context, ProductActivity.class);
        intent.putExtra(ID,id);
        return intent;
    }

    @InjectPresenter
    ProdactActivityPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String id = intent.getStringExtra(ID);

        mPresenter.setProduct(id);
        mPresenter.refreshPresenter();
    }

    @Override
    public void refreshView() {
        tilId  .getEditText().setText(Long.toString(mPresenter.getProduct().getId()));
        tilName.getEditText().setText(mPresenter.getProduct().getName());
    }

    @Override
    public void startBarcodeListActivityView(String id) {
        startActivity(BarcodeListActivity.getIntent(this,id));
    }

    @Override
    public void finishView() {
        finish();
    }


    //*********************************************************************************************
    //  events

    @OnClick(R.id.btCalculate)
    void onClickBtCalculate(){
        mPresenter.onClickCalculate();

    }

    @OnClick(R.id.btOK)
    void onClickBtOk(){
        mPresenter.getProduct().setName((String) tilName.getEditText().getText().toString());
        mPresenter.onClickOk();
    }

    @OnClick(R.id.btDell)
    void onClickBtDell(){
        mPresenter.onClickDell();
    }


}
