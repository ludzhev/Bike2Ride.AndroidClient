package com.bike2ride.ludzhev.bike2ride.base;

import android.support.annotation.NonNull;

import com.bike2ride.ludzhev.bike2ride.Bike2RideApplication;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    private OnRequestPermissionResultLister mOnRequestPermissionResultLister;

    @Override
    protected void onResume() {
        super.onResume();
        ((Bike2RideApplication) getApplication())
                .setCurrentActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((Bike2RideApplication) getApplication())
                .setCurrentActivity(null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        ((Bike2RideApplication) getApplication())
                .setCurrentActivity(null);
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            @NonNull String[] permissions,
            @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (mOnRequestPermissionResultLister == null) {
            return;
        }

        mOnRequestPermissionResultLister.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void setOnRequestPermissionResultLister(OnRequestPermissionResultLister onRequestPermissionResultLister) {
        mOnRequestPermissionResultLister = onRequestPermissionResultLister;
    }

    public interface OnRequestPermissionResultLister {
        void onRequestPermissionsResult(
                int requestCode,
                @NonNull String[] permissions,
                @NonNull int[] grantResults);
    }
}