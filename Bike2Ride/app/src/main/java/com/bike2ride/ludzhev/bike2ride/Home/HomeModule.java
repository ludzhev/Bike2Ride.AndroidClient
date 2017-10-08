package com.bike2ride.ludzhev.bike2ride.Home;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {
    @Provides
    HomeContracts.Presenter provideHomePresenter() {
        return new HomePresenter();
    }
}
