package ru.anit.weightcalculator.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.anit.weightcalculator.mvp.views.MainActivitiesView;


@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MainActivitiesView> {

    public void clickFabPresenter(){
        getViewState().startProductActivity(null);
    }

    public void clickItem(String id){
        getViewState().startProductActivity(id);
    }

    public void startProductActivity(String id){
        getViewState().startProductActivity(id);
    }


}
