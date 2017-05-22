package ru.anit.weightcalculator.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by Alex on 22.05.2017.
 */

public interface DialogBarcodeActivityView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void refreshView();

}
