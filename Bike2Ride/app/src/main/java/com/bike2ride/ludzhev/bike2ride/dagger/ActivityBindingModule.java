package com.bike2ride.ludzhev.bike2ride.dagger;

import com.bike2ride.ludzhev.bike2ride.BikeFind.BikeFindActivity;
import com.bike2ride.ludzhev.bike2ride.BikeFind.BikeFindModule;
import com.bike2ride.ludzhev.bike2ride.Home.HomeActivity;
import com.bike2ride.ludzhev.bike2ride.Home.HomeModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            HomeModule.class,
    })
    abstract HomeActivity homeActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            BikeFindModule.class,
    })
    abstract BikeFindActivity bikeFindActivity();

}
