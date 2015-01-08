package com.aldoborrero.tinderjs.ui.base;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import butterknife.ButterKnife;

public class TinderJsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.inject(this);
    }

}
