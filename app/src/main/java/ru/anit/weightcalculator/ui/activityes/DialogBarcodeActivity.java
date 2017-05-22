package ru.anit.weightcalculator.ui.activityes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.arellomobile.mvp.MvpAppCompatActivity;

import butterknife.ButterKnife;
import ru.anit.weightcalculator.R;
import ru.anit.weightcalculator.app.App;

/**
 * Created by Alex on 22.05.2017.
 */

public class DialogBarcodeActivity extends MvpAppCompatActivity implements  {

    public static Intent getIntent(final Context context, String id) {
        Intent intent = new Intent(context, DialogBarcodeActivity.class);
        intent.putExtra(ID,id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_barcode);
        //ButterKnife.bind(this);

    }
}
