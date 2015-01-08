package com.aldoborrero.tinderjs.ui.widgets;

import android.content.Context;
import android.util.AttributeSet;

import com.aldoborrero.tinderjs.utils.Dimens;

public class DrawerContainerFrameLayout extends ScrimInsetsFrameLayout {

    private int actionBarSize;

    public DrawerContainerFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawerContainerFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.actionBarSize = Dimens.getActionBarSize(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // See http://www.google.com/design/spec/layout/structure.html#structure-side-nav
        setMinimumWidth(Dimens.getScreenWidth(getContext()) - actionBarSize);
    }

}
