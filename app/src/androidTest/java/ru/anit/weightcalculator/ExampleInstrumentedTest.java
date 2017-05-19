package ru.anit.weightcalculator;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import ru.anit.weightcalculator.app.App;
import ru.anit.weightcalculator.general.LogHelper;
import ru.anit.weightcalculator.mvp.model.intities.Product;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    LogHelper mLogHelper;

    public ExampleInstrumentedTest() {
        mLogHelper = new LogHelper();
    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        mLogHelper.logD("Start useAppContext");

        Product product = new Product();
        product.setName("ghkjhkjhkjhkj");
        long id = App.getAppComponent().getRepositoryProducts().save(product);
        mLogHelper.logD("Save product: " + id);


        assertEquals("ru.anit.weightcalculator", appContext.getPackageName());
    }
}
