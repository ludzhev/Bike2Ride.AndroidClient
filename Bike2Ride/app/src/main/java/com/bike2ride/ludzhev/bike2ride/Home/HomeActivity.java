package com.bike2ride.ludzhev.bike2ride.Home;

import android.os.Bundle;

import com.bike2ride.ludzhev.bike2ride.R;
import com.bike2ride.ludzhev.bike2ride.base.BaseActivity;

import java.io.Serializable;

import javax.inject.Inject;

public class HomeActivity
        extends BaseActivity
        implements HomeContracts.Router {

    private static final String EXTRA_VIEW_STATE_KEY = "VIEW_STATE_KEY_HOME";

    @Inject
    @SuppressWarnings("CheckStyle")
    HomeContracts.Presenter mHomePresenter;

    private HomeFragment mHomeView;

    private HomeContracts.ViewState getViewState(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(EXTRA_VIEW_STATE_KEY)) {
            return new HomeViewState();
        } else {
            Serializable serializable = bundle.getSerializable(EXTRA_VIEW_STATE_KEY);
            return (HomeContracts.ViewState) serializable;
        }
    }

    @Override
    protected void onResume() {
        mHomeView.setPresenter(mHomePresenter);
        super.onResume();
    }

    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_home);
        super.onCreate(savedInstanceState);

        mHomeView = HomeFragment.newInstance();
        HomeContracts.ViewState viewState = getViewState(savedInstanceState);
        mHomePresenter.setViewState(viewState);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_home, mHomeView)
                .commit();
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(EXTRA_VIEW_STATE_KEY, mHomePresenter.getViewState());
    }
}
