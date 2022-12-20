package ui.components.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class IconView extends AppCompatTextView {
    public IconView(Context context) {
        super(context);
    }

    public IconView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (attrs != null)
            applyTypeface(context, attrs);
    }

    public IconView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (attrs != null)
            applyTypeface(context, attrs);
    }

    private void applyTypeface(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.IconView);
        String fileName = typedArray.getString(R.styleable.IconView_fileName);
        if (fileName == null || fileName.isEmpty())
            return;
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), fileName);
        this.setTypeface(typeface);
        typedArray.recycle();
    }
}
