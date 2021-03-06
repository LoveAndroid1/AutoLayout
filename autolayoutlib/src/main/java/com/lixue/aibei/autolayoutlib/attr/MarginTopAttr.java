/*
 * Copyright (c) 2016 by xiaoxue. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lixue.aibei.autolayoutlib.attr;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/2/22.
 */
public class MarginTopAttr extends AutoAttr {
    public MarginTopAttr(int pxVal, int baseWidth, int baseHeight) {
        super(pxVal, baseWidth, baseHeight);
    }

    @Override
    protected int attrVal() {
        return Attrs.MARGIN_TOP;
    }

    @Override
    protected boolean defaultBaseWidth() {
        return false;
    }

    @Override
    protected void execute(View view, int val) {
        if (!(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)){
            return;
        }
        ViewGroup.MarginLayoutParams mp = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        mp.topMargin = val;
    }
    public static MarginTopAttr generate(int val, int baseFlag) {
        MarginTopAttr attr = null;
        switch (baseFlag) {
            case AutoAttr.BASE_WIDTH:
                attr = new MarginTopAttr(val, Attrs.MARGIN_TOP, 0);
                break;
            case AutoAttr.BASE_HEIGHT:
                attr = new MarginTopAttr(val, 0, Attrs.MARGIN_TOP);
                break;
            case AutoAttr.BASE_DEFAULT:
                attr = new MarginTopAttr(val, 0, 0);
                break;
        }
        return attr;
    }
}
