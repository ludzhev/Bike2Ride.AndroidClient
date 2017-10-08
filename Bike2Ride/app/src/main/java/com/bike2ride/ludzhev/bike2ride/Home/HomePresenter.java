package com.bike2ride.ludzhev.bike2ride.Home;

/**
 * Represent a class that holds the logic of the Home Activity.
 * Implementation of {@link com.bike2ride.ludzhev.bike2ride.Home.HomeContracts.Presenter} interface.
 *
 * @author ludzhev
 * @version %I%, %G%
 * @since 1.0
 */
public class HomePresenter implements HomeContracts.Presenter {

    private HomeContracts.View mView;
    private HomeContracts.ViewState mViewState;

    @Override
    public void setViewState(HomeContracts.ViewState viewState) {
        mViewState = viewState;
    }

    @Override
    public HomeContracts.ViewState getViewState() {
        return mViewState;
    }

    @Override
    public void subscribe(HomeContracts.View view) {
        mView = view;
        load();
    }

    private void load() {
        mViewState.setContent("MVP Works!");
        mView.setContent(mViewState.getContent());
    }

    @Override
    public void unsubscribe() {
        mView = null;
    }
}
