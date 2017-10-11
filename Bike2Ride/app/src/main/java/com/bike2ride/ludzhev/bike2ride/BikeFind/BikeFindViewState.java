package com.bike2ride.ludzhev.bike2ride.BikeFind;

import com.bike2ride.ludzhev.bike2ride.models.Location;

import java.util.List;

public class BikeFindViewState implements BikeFindContracts.ViewState {

    private List<Location> mPath;

    @Override
    public void setPath(List<Location> path) {
        mPath = path;
    }

    @Override
    public List<Location> getPath() {
        return mPath;
    }
}
