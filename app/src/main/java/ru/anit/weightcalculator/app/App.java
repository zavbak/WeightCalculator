package ru.anit.weightcalculator.app;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import ru.anit.weightcalculator.di.ApplicationComponent;
import ru.anit.weightcalculator.di.ApplicationModule;
import ru.anit.weightcalculator.di.DaggerApplicationComponent;
import ru.anit.weightcalculator.repository.realm.module.RealmMigration;


public class App extends Application {

    private static ApplicationComponent mAppComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    /*
    Инициализация всего
     */
    void init(){

        Realm.init(this);

        RealmConfiguration config = new RealmConfiguration.Builder()
                .schemaVersion(1)
                .migration(new RealmMigration())
                .build();

        Realm.setDefaultConfiguration(config);

        mAppComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static ApplicationComponent getAppComponent() {
        return mAppComponent;
    }
}
