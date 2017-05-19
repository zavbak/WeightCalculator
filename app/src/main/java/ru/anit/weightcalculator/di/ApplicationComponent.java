package ru.anit.weightcalculator.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import io.realm.Realm;
import ru.anit.weightcalculator.general.LogHelper;
import ru.anit.weightcalculator.servise.realm.RepositoryProductsI;
import ru.anit.weightcalculator.servise.realm.RepositoryProductsRealm;

/**
 * Created by user on 17.05.2017.
 */

@Singleton
@Component(modules={ApplicationModule.class,RealmModule.class})
public interface ApplicationComponent {
    Context getAppContext();
    LogHelper getLogHelper();
    RepositoryProductsI getRepositoryProducts();

    void injectRepositoryProductsRealm(RepositoryProductsRealm repositoryProductsRealm);
}
