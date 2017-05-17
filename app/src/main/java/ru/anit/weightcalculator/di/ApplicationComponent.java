package ru.anit.weightcalculator.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by user on 17.05.2017.
 */

@Singleton
@Component(modules={ApplicationModule.class})
public interface ApplicationComponent {
    Context getAppContext();
}
