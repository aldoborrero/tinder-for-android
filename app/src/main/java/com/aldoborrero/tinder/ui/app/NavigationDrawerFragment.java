package com.aldoborrero.tinder.ui.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aldoborrero.tinder.R;
import com.aldoborrero.tinder.ui.base.TinderFragment;

public class NavigationDrawerFragment extends TinderFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
    }

}
