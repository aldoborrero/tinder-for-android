/*
 * Copyright 2015 Aldo Borrero <aldo@aldoborrero.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.aldoborrero.tinder.ui.widgets;

import android.content.Context;
import android.util.AttributeSet;

import com.aldoborrero.tinder.utils.Dimens;

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
        int width = Dimens.getScreenWidth(getContext()) - actionBarSize;
        setMeasuredDimension(width, getMeasuredHeight());
    }

}
