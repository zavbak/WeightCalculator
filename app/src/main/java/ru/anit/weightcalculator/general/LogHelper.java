package ru.anit.weightcalculator.general;


import android.util.Log;

import java.util.Date;

import javax.inject.Inject;

public class LogHelper {

    @Inject
    public LogHelper() {
    }

    public void logD(String mess){
        Log.d(Constants.TAG,mess + " /" + new Date());
    }
}
