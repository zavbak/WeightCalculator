package ru.anit.weightcalculator.ui.activityes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.anit.weightcalculator.R;
import ru.anit.weightcalculator.mvp.model.intities.Barcode;
import ru.anit.weightcalculator.mvp.model.intities.Product;
import ru.anit.weightcalculator.mvp.presenters.BarcodeListActivityPresenter;
import ru.anit.weightcalculator.mvp.presenters.ProdactActivityPresenter;
import ru.anit.weightcalculator.mvp.views.BarcodeListActivityView;
import ru.anit.weightcalculator.mvp.views.ProdactActivityView;
import ru.anit.weightcalculator.ui.adapters.barcode.AdapterListBarcode;
import ru.anit.weightcalculator.ui.adapters.barcode.ItemBarcode;
import ru.anit.weightcalculator.ui.adapters.products.AdapterListProduct;
import ru.anit.weightcalculator.ui.dialog.DFBarcode;
import ru.anit.weightcalculator.ui.dialog.DialogBarcode;

/**
 * Created by Alex on 17.05.2017.
 */

public class BarcodeListActivity extends MvpAppCompatActivity implements BarcodeListActivityView {

    public static String ID = "id";

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    DialogBarcode mDialogBarcode;




    public static Intent getIntent(final Context context, String id) {
        Intent intent = new Intent(context, BarcodeListActivity.class);
        intent.putExtra(ID,id);
        return intent;
    }

    @InjectPresenter
    BarcodeListActivityPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barcode_act);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String id = intent.getStringExtra(ID);

        mPresenter.setProduct(id);
        mPresenter.refreshPresenter();



        init();
    }

    private void init() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new AdapterListBarcode(mPresenter.getListBarcode(), id -> mPresenter.clickItem(id)));
    }

    @Override
    public void refreshView() {

    }

    @Override
    public void startDilogBarcode(String id) {
        Product product = new Product();
        product.setName("Свинина");
        Barcode barcode = new Barcode();
        barcode.setBarcode("654564564564");
        barcode.setWeight(Float.parseFloat("5.2"));
        barcode.setWeight(2);

        //DFBarcode dfb = new DFBarcode();
        //dfb.setBarcode(barcode);


        //dfb.show(getFragmentManager(),null);
        startActivity(DialogBarcodeActivity.getIntent(this,id));

    }

    @OnClick(R.id.fab)
    void clickFab(){
        mPresenter.clickFabPresenter();
    }


}
