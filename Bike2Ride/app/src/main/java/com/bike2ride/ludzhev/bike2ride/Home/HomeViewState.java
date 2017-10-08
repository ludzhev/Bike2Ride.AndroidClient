package com.bike2ride.ludzhev.bike2ride.Home;

public class HomeViewState implements HomeContracts.ViewState {
    private String mContent;

    @Override
    public void setContent(String content) {
        mContent = content;
    }

    @Override
    public String getContent() {
        return mContent;
    }
}
