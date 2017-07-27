package com.eatanimation;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 123 on 2017/7/27.
 */

public class EatCenterView extends View {

    private int widthAll;
    private int hightAll;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        widthAll = getMeasuredWidth();
        hightAll = getHeight();
    }

    public EatCenterView(Context context) {
        super(context);
    }

    public EatCenterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EatCenterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public EatCenterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
