package com.bike2ride.ludzhev.bike2ride.BikeFind;

import com.bike2ride.ludzhev.bike2ride.models.Location;

import java.util.ArrayList;
import java.util.List;

public class BikeFindPresenter implements BikeFindContracts.Presenter {

    private BikeFindContracts.View mView;
    private BikeFindContracts.ViewState mViewState;

    @Override
    public void setViewState(BikeFindContracts.ViewState viewState) {
        mViewState = viewState;
    }

    @Override
    public BikeFindContracts.ViewState getViewState() {
        return mViewState;
    }

    @Override
    public void subscribe(BikeFindContracts.View view) {
        mView = view;
        load();
    }

    private void load() {
        List<Location> path = new ArrayList<>();
        path.add(new Location(42.651026, 23.379218));
        mViewState.setPath(path);
        mView.setPath(mViewState.getPath());
    }

    @Override
    public void unsubscribe() {
        mView = null;
    }
}
