package com.aldoborrero.tinder.ui.app;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;

import com.aldoborrero.tinder.R;
import com.aldoborrero.tinder.ui.base.TinderActivity;

public class MainActivity extends TinderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        initNavigationDrawer();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, new ExploreFragment())
                    .commit();
        }

    }

    private void initNavigationDrawer() {
        DrawerLayout drawerLayout = ((DrawerLayout) findViewById(R.id.drawer_layout));
        drawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.primary_dark));
    }

}
