package com.bike2ride.ludzhev.bike2ride.dagger;

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
}
