package com.bike2ride.ludzhev.bike2ride.base;

public interface CurrentActivityProvider {
    void setCurrentActivity(BaseActivity activity);
    BaseActivity getCurrentActivity();
}

