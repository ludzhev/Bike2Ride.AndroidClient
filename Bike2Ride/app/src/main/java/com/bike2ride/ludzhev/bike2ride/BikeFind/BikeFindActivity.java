package com.bike2ride.ludzhev.bike2ride.BikeFind;

import android.os.Bundle;

import com.bike2ride.ludzhev.bike2ride.R;
import com.bike2ride.ludzhev.bike2ride.base.BaseActivity;


import java.io.Serializable;

import javax.inject.Inject;

public class BikeFindActivity
        extends BaseActivity
        implements BikeFindContracts.Router{
    private static final String EXTRA_VIEW_STATE_KEY = "VIEW_STATE_KEY_BIKE_FIND";

    @Inject
    BikeFindContracts.Presenter mBikeFindPresenter;

    private BikeFindFragment mBikeFindView;

    @Override
    protected void onResume() {
        mBikeFindView.setPresenter(mBikeFindPresenter);
        super.onResume();
    }

    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_bike_find);
        super.onCreate(savedInstanceState);

        mBikeFindView = BikeFindFragment.newInstance();
        BikeFindContracts.ViewState viewState = getViewState(savedInstanceState);
        mBikeFindPresenter.setViewState(viewState);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_bike_find, mBikeFindView)
                .commit();
    }

    private BikeFindContracts.ViewState getViewState(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(EXTRA_VIEW_STATE_KEY)) {
            return new BikeFindViewState();
        } else {
            Serializable serializable = bundle.getSerializable(EXTRA_VIEW_STATE_KEY);
            return (BikeFindContracts.ViewState) serializable;
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(EXTRA_VIEW_STATE_KEY, mBikeFindPresenter.getViewState());
    }
}
