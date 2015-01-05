package com.aldoborrero.tinderjs.ui.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aldoborrero.tinderjs.R;
import com.aldoborrero.tinderjs.ui.base.TinderJsFragment;

public class DrawerFragment extends TinderJsFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
    }

}
