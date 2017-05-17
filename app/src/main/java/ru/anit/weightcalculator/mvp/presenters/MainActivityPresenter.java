package ru.anit.weightcalculator.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ru.anit.weightcalculator.mvp.views.MainActivitiesView;
import ru.anit.weightcalculator.ui.adapters.ItemProdacts;
import ru.anit.weightcalculator.ui.adapters.ItemProdactsI;




@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MainActivitiesView> {

    public void clickFabPresenter(){
        getViewState().showMessageView("Hello" +new Date());
    }

    public List getListProducts() {
        List list = new ArrayList<ItemProdactsI>();
        ItemProdacts item = new ItemProdacts("Говядина на кости","105","10");
        list.add(item);

        item = new ItemProdacts("Свинина на кости","320","60");
        list.add(item);

        item = new ItemProdacts("Голень на кости","108","15");
        list.add(item);

        item = new ItemProdacts("Говядина на кости","30","2");
        list.add(item);

        item = new ItemProdacts("Говядина на кости","30","2");
        list.add(item);

        item = new ItemProdacts("Говядина на кости","30","2");
        list.add(item);

        item = new ItemProdacts("Говядина на кости","30","2");
        list.add(item);


        return list;
    }
}
