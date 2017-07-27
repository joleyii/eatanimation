package com.eatanimation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 123 on 2017/7/24.
 */

public class EatView extends View {

    private int widthAll;
    private int hightAll;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ShapeDrawable shapeDrawableO = new ShapeDrawable(new OvalShape());
        shapeDrawableO.setIntrinsicHeight(widthAll);
        shapeDrawableO.setIntrinsicWidth(widthAll);
        shapeDrawableO.setBounds(0, 0, widthAll, widthAll);
        shapeDrawableO.getPaint().setColor(Color.BLACK);

        Bitmap bitmapO = drawableToBitmapO(shapeDrawableO);

        ShapeDrawable shapeDrawableR = new ShapeDrawable(new RectShape());
        shapeDrawableR.setIntrinsicHeight(widthAll / 2);
        shapeDrawableR.setIntrinsicWidth(widthAll / 2);
        shapeDrawableR.setPadding(50, 50, 50, 50);
        shapeDrawableR.setBounds(100, 100, widthAll, hightAll);
        shapeDrawableR.getPaint().setColor(Color.WHITE);

        Bitmap bitmapR = drawableToBitmapR(shapeDrawableR);

        canvas.drawBitmap(createImage(bitmapO, bitmapR), 0, 0, null);
    }

    private Bitmap createImage(Bitmap shapeLayerBitmap, Bitmap showLayerBitmap) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        Bitmap finalBmp = Bitmap.createBitmap(widthAll, widthAll, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(finalBmp);
        if (null != shapeLayerBitmap) {
            canvas.drawBitmap(shapeLayerBitmap, 0, 0, paint);
        }
        if (null != showLayerBitmap) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            canvas.drawBitmap(showLayerBitmap, 0, 0, paint);
        }
        return finalBmp;
    }


    public static Bitmap drawableToBitmapO(Drawable drawable) {
        // 取 drawable 的长宽
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();

        // 取 drawable 的颜色格式
        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                : Bitmap.Config.RGB_565;
        // 建立对应 bitmap
        Bitmap bitmap = Bitmap.createBitmap(w, h, config);
        // 建立对应 bitmap 的画布
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        // 把 drawable 内容画到画布中
        drawable.draw(canvas);
        return bitmap;
    }

    public static Bitmap drawableToBitmapR(Drawable drawable) {
        // 取 drawable 的长宽
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();

        // 取 drawable 的颜色格式
        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                : Bitmap.Config.RGB_565;

        Bitmap bitmap = Bitmap.createBitmap(w, h, config);
        // 建立对应 bitmap 的画布
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(50, 50, w + 50, h + 50);
        drawable.draw(canvas);

        Matrix matrix = new Matrix();
        matrix.postScale(1f, 1f);
        matrix.postRotate(-45);
        //bmp.getWidth(), 500分别表示重绘后的位图宽高
        Bitmap dstbmp = Bitmap.createBitmap(bitmap, 0, 0, w, h,
                matrix, true);
        return dstbmp;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        widthAll = getMeasuredWidth();
        hightAll = getHeight();
    }

    public EatView(Context context) {
        super(context);
    }

    public EatView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EatView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public EatView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

}
