package com.bike2ride.ludzhev.bike2ride.Home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bike2ride.ludzhev.bike2ride.R;

/**
 * A simple {@link Fragment} subclass.
 */

public class HomeFragment
        extends Fragment
        implements HomeContracts.View {
    private HomeContracts.Presenter mPresenter;
    private TextView mHomeContentView;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        mHomeContentView = root.findViewById(R.id.content);

        return root;
    }

    @Override
    public void setContent(String content) {
        mHomeContentView.setText(content);
    }

    @Override
    public void setPresenter(HomeContracts.Presenter presenter) {
        mPresenter = presenter;
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
