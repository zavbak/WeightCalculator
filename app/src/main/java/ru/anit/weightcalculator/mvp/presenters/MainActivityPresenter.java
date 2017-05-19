package ru.anit.weightcalculator.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ru.anit.weightcalculator.mvp.views.MainActivitiesView;
import ru.anit.weightcalculator.ui.adapters.products.ItemProdacts;
import ru.anit.weightcalculator.ui.adapters.products.ItemProdactsI;


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

    public List getListProducts() {
        List list = new ArrayList<ItemProdactsI>();
        ItemProdacts item = new ItemProdacts("1","Говядина на кости","105","10");
        list.add(item);

        item = new ItemProdacts("2","Свинина на кости","320","60");
        list.add(item);

        item = new ItemProdacts("3","Голень на кости","108","15");
        list.add(item);

        item = new ItemProdacts("4","Говядина на кости","30","2");
        list.add(item);

        item = new ItemProdacts("5","Говядина на кости","30","2");
        list.add(item);

        item = new ItemProdacts("6","Говядина на кости","30","2");
        list.add(item);

        item = new ItemProdacts("7","Говядина на кости","30","2");
        list.add(item);


        return list;
    }
}
