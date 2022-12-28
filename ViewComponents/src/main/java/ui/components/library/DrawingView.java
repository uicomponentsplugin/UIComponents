package ui.components.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

import androidx.annotation.Nullable;


public class DrawingView extends View {
    private Paint mPaint;
    //    private Paint strokePaint = new Paint();
    private Path mPath;
    //    private int mCanvasColor;
    private ScrollView scrollView;

    public DrawingView(Context context) {
        super(context);
    }

    public DrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPath = new Path();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DrawingView);
        mPaint.setColor(typedArray.getColor(R.styleable.DrawingView_lineColor, getResources().getColor(R.color.black)));
        mPaint.setStrokeWidth(typedArray.getInteger(R.styleable.DrawingView_lineStrokeWidth, 5));
        setBackgroundResource(typedArray.getResourceId(R.styleable.DrawingView_backgroundSrc, R.color.white));
        typedArray.recycle();


//        strokePaint.setStyle(Paint.Style.STROKE);
//        strokePaint.setColor(Color.BLACK);
//        strokePaint.setStrokeWidth(2);
    }

    public DrawingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DrawingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.drawColor(mCanvasColor);
        canvas.drawPath(mPath, mPaint);

//        RectF r = new RectF(30, 30, canvas.getWidth()-30, canvas.getHeight()-30);
//        int cornerRadius = 50;
//        // stroke
//        canvas.drawRoundRect(r, cornerRadius, cornerRadius, strokePaint);
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (scrollView != null) {
            scrollView.requestDisallowInterceptTouchEvent(false); // Any type of motion event initially InterceptTouchEvent(true)
        }
        Log.d("TAG", "onTouchEvent:  X-" + event.getX() + ", Y -" + event.getY() + "event Action: " + getEventActionName(event.getAction()));
        float x = event.getX();
        float y = event.getY();
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            mPath.moveTo(x, y);
            if (scrollView != null)
                scrollView.requestDisallowInterceptTouchEvent(true);
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            mPath.lineTo(x, y);
            if (scrollView != null)
                scrollView.requestDisallowInterceptTouchEvent(true);
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            if (scrollView != null)
                scrollView.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        return true;
    }

    private String getEventActionName(int action) {
        if (action == MotionEvent.ACTION_UP)
            return "ACTION_UP";
        else if (action == MotionEvent.ACTION_DOWN)
            return "ACTION_DOWN";
        else if (action == MotionEvent.ACTION_MOVE)
            return "ACTION_MOVE";
        else if (action == MotionEvent.ACTION_CANCEL)
            return "ACTION_CANCEL";
        return action + "";
    }

    public Bitmap getBitmap() {
        //Define a bitmap with the same size as the view
        Bitmap returnedBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnedBitmap);
        //Get the view's background
        Drawable bgDrawable = getBackground();
        setBackground(null);
//        if (bgDrawable != null)
//            //has background drawable, then draw it on the canvas
//            bgDrawable.draw(canvas);
//        else
        //does not have background drawable, then draw white background on the canvas
        canvas.drawColor(Color.WHITE);

        // draw the view on the canvas
        draw(canvas);
        //return the bitmap
        setBackground(bgDrawable);
        return returnedBitmap;
    }

    public void clearDrawable() {
        mPath.reset();
        invalidate();
    }

    public void addScrollView(ScrollView scrollView) {
        this.scrollView = scrollView;
    }

    public boolean isEmpty() {
        return mPath.isEmpty();
    }

//    public void setError() {
//
//    }
}