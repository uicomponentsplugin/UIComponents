package ui.components.library;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


/**
 * Created by Mahesh Balla on 17,August,2020
 */
public class CircleDrawable extends Drawable {
    private final Context context;
    //Defaults
    protected Percent percent = Percent.FIFTY;
    protected Gravity gravity = Gravity.CENTER;

    protected int filledColor;
    protected int strokeColor;
    protected int strokeWidth;
    protected int textColor;
    protected String text;

    public void setText(String text) {
        this.text = text;
        invalidateSelf();
    }

    public String getText() {
        return text;
    }

    public enum Percent {TEN, TWENTY, THIRTY, FORTY, FIFTY, SIXTY, SEVENTY, EIGHTY, NINETY, HUNDRED}

    public enum Gravity {TOP_LEFT, TOP_CENTER, TOP_RIGHT, CENTER, BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT}

    public CircleDrawable(Context context) {
        this.context = context;
    }

    public void setSizePercent(Percent percent) {
        this.percent = percent;
    }

    public void setGravity(Gravity gravity) {
        this.gravity = gravity;
    }


    public void setFilledColor(int filledColor) {
        this.filledColor = filledColor;
    }

    public void setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        Paint filledPaint = new Paint();
        filledPaint.setColor(filledColor == 0 ? context.getColor(R.color.circle_drawable_filled) : context.getColor(filledColor));
        if (strokeColor == 0)
            strokeColor = filledColor;
        filledPaint.setAntiAlias(true);// To get perfect sharpness
        filledPaint.setStyle(Paint.Style.FILL);

        Paint strokePaint = new Paint();
        strokePaint.setAntiAlias(true);// To get perfect sharpness
        strokePaint.setColor(strokeColor == 0 ? context.getColor(R.color.circle_drawable_stroke) : context.getColor(strokeColor));
        strokePaint.setStrokeWidth(strokeWidth == 0 ? 1 : strokeWidth);
        strokePaint.setStyle(Paint.Style.STROKE);

        Rect bounds = getBounds();
        int width = (bounds.right - bounds.left);
        int height = (bounds.bottom - bounds.top);
        double ratio = 0;
        switch (percent) {
            case TEN:
                ratio = 0.10;
                break;
            case TWENTY:
                ratio = 0.20;
                break;
            case THIRTY:
                ratio = 0.30;
                break;
            case FORTY:
                ratio = 0.40;
                break;
            case FIFTY:
                ratio = 0.50;
                break;
            case SIXTY:
                ratio = 0.60;
                break;
            case SEVENTY:
                ratio = 0.70;
                break;
            case EIGHTY:
                ratio = 0.80;
                break;
            case NINETY:
                ratio = 0.90;
                break;
            case HUNDRED:
                ratio = 1;
                break;
        }
        int drawableWidth = (int) ((bounds.right - bounds.left) * ratio);
        int drawableHeight = (int) ((bounds.bottom - bounds.top) * ratio);

        float pointX;
        float pointY;
        float radius;

        switch (gravity) {
            case CENTER:
            default:
                pointX = width / 2;
                pointY = height / 2;
                radius = drawableWidth < drawableHeight ? drawableHeight / 2 : drawableWidth / 2;
                break;
            case TOP_RIGHT:
                pointX = width - strokeWidth - drawableWidth / 2;
                pointY = drawableHeight / 2 + strokeWidth;
                radius = drawableWidth < drawableHeight ? drawableHeight / 2 : drawableWidth / 2;
                break;
        }
        canvas.drawCircle(pointX, pointY, radius, filledPaint);
        canvas.drawCircle(pointX, pointY, radius, strokePaint);
        if (text != null && !text.isEmpty()) {
            Paint textPaint = new Paint();
            textPaint.setColor(textColor == 0 ? context.getColor(R.color.circle_drawable_text) : context.getColor(textColor));
            textPaint.setTextAlign(Paint.Align.CENTER);
            textPaint.setAntiAlias(true);
            textPaint.setTextSize(calculateMaxTextSize(text, textPaint, (int) (drawableWidth * 0.66), (int) (drawableHeight * 0.66)));
            Rect textPaintBounds = new Rect();
            textPaint.getTextBounds(text, 0, text.length(), textPaintBounds);
            canvas.drawText(text, pointX, pointY + textPaintBounds.height() / 2, textPaint);
        }

    }

    private float calculateMaxTextSize(String text, Paint paint, int maxWidth, int maxHeight) {
        if (text == null || paint == null) return 0;
        Rect bound = new Rect();
        float size = 1.0f;
        float step = 1.0f;
        while (true) {
            paint.getTextBounds(text, 0, text.length(), bound);
            if (bound.width() < maxWidth && bound.height() < maxHeight) {
                size += step;
                paint.setTextSize(size);
            } else {
                return size - step;
            }
        }
    }

    @Override
    public void setAlpha(int i) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.UNKNOWN;
    }
}
