package ru.anit.weightcalculator.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by Alex on 17.05.2017.
 */

public interface ProdactActivityView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void refreshView();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void startBarcodeListActivityView(String id);
}
