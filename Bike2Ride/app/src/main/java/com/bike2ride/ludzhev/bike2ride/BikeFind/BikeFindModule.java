package com.bike2ride.ludzhev.bike2ride.BikeFind;

import dagger.Module;
import dagger.Provides;

@Module
public class BikeFindModule {
    @Provides
    BikeFindContracts.Presenter provideBikeFindPresenter() {
        return new BikeFindPresenter();
    }
}
