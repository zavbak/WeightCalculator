package ru.anit.weightcalculator.app;

import android.app.Application;

import ru.anit.weightcalculator.di.ApplicationComponent;
import ru.anit.weightcalculator.di.ApplicationModule;
import ru.anit.weightcalculator.di.DaggerApplicationComponent;



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
        mAppComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static ApplicationComponent getAppComponent() {
        return mAppComponent;
    }
}
