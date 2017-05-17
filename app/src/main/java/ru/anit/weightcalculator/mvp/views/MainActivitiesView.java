package ru.anit.weightcalculator.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;


public interface MainActivitiesView extends MvpView {
    @StateStrategyType(SkipStrategy.class)
    void showMessageView(CharSequence text);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void startProductActivity(String id);
}
