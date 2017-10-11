package com.bike2ride.ludzhev.bike2ride.BikeFind;

import com.bike2ride.ludzhev.bike2ride.base.BaseContracts;
import com.bike2ride.ludzhev.bike2ride.models.Location;

import java.util.List;

public interface BikeFindContracts {
    interface View extends BaseContracts.View<Presenter> {
        void setPath(List<Location> path);
    }

    /**
     * Base Presenter for Home.
     */
    interface Presenter extends BaseContracts.ViewStatePresenter<View, ViewState> {
    }

    /**
     * Contract for Home navigation.
     */
    interface Router extends BaseContracts.Router {
    }

    /**
     * Base ViewState for Home.
     */
    interface ViewState extends BaseContracts.ViewState {
        void setPath(List<Location> path);
        List<Location> getPath();
    }
}
