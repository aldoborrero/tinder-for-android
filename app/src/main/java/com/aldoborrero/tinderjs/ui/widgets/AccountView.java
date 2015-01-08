package com.aldoborrero.tinderjs.ui.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.aldoborrero.tinderjs.R;

public class AccountView extends FrameLayout {

    public AccountView(Context context) {
        this(context, null);
    }

    public AccountView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AccountView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public AccountView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        LayoutInflater.from(context).inflate(R.layout.partial_account_view, this, true);
    }

}
