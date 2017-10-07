package com.bike2ride.ludzhev.bike2ride;

import com.bike2ride.ludzhev.bike2ride.dagger.AppComponent;
import com.bike2ride.ludzhev.bike2ride.dagger.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class Bike2RideApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        return appComponent;
    }
}
