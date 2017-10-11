package com.bike2ride.ludzhev.bike2ride.dagger;

import android.app.Application;

import com.bike2ride.ludzhev.bike2ride.Bike2RideApplication;
import com.bike2ride.ludzhev.bike2ride.BikeFind.BikeFindModule;
import com.bike2ride.ludzhev.bike2ride.Home.HomeModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class,
        HomeModule.class,
        BikeFindModule.class,
})
public interface AppComponent extends AndroidInjector<DaggerApplication> {
    void inject(Bike2RideApplication application);

    @Override
    void inject(DaggerApplication instance);

    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
