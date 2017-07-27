package com.eatanimation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 123 on 2017/7/27.
 */

public class EatClipPathView extends View {

    private int widthAll;
    private int hightAll;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        RectF rectF = new RectF(0, 0, widthAll, hightAll);
        canvas.drawArc(rectF, -30, 30, true, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        widthAll = getMeasuredWidth();
        hightAll = getHeight();
    }

    public EatClipPathView(Context context) {
        super(context);
    }

    public EatClipPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EatClipPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public EatClipPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
