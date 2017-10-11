package com.bike2ride.ludzhev.bike2ride.BikeFind;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bike2ride.ludzhev.bike2ride.R;
import com.bike2ride.ludzhev.bike2ride.models.Location;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */

public class BikeFindFragment
        extends Fragment
        implements BikeFindContracts.View, OnMapReadyCallback {

    private BikeFindContracts.Presenter mPresenter;
    private MapView mMapView;
    private GoogleMap mMap;
    private List<Location> mPath;

    public BikeFindFragment() {
        // Required empty public constructor
    }

    public static BikeFindFragment newInstance() {
        return new BikeFindFragment();
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bike_find, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        mMapView = view.findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();
        mMapView.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Location start = mPath.get(0);
        LatLng currentLocation = new LatLng(start.getLatitude(), start.getLongitude());
        mMap.addMarker(new MarkerOptions().position(currentLocation).title("You are here."));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(currentLocation));
    }

    @Override
    public void setPresenter(BikeFindContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setPath(List<Location> path) {
        mPath = path;
    }

    @Override
    public void onResume() {
        mPresenter.subscribe(this);
        super.onResume();
    }

    @Override
    public void onPause() {
        mPresenter.unsubscribe();
        super.onPause();
    }
}
