package ru.anit.weightcalculator.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import ru.anit.weightcalculator.repository.realm.repository.IProductRepository;
import ru.anit.weightcalculator.repository.realm.repository.impl.ProductRepository;
import ru.anit.weightcalculator.servise.realm.RepositoryProductsI;
import ru.anit.weightcalculator.servise.realm.RepositoryProductsRealm;


@Module
public final class RealmModule {

    @Provides
    @Singleton
    Realm getRealm(){
       return Realm.getDefaultInstance();
    }

    @Provides
    @Singleton
    IProductRepository getIProductRepository(Realm realm){
        return new ProductRepository(realm);
    }



}
