package ui.components.library;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class EditText2 extends androidx.appcompat.widget.AppCompatEditText implements View.OnTouchListener, TextWatcher {

    private onDrawableClickListener onDrawableClickListener;
    private TextWatcher2 textWatcher2;

    public EditText2(@NonNull Context context) {
        super(context);
    }

    public EditText2(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EditText2(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnDrawableClickListener(onDrawableClickListener onDrawableClickListener) {
        setOnTouchListener(this);
        this.onDrawableClickListener = onDrawableClickListener;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {//return true if the listener has consumed the event, false otherwise.
        final int DRAWABLE_LEFT = 0;
        final int DRAWABLE_TOP = 1;
        final int DRAWABLE_RIGHT = 2;
        final int DRAWABLE_BOTTOM = 3;
        if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            if (getLeft() + getCompoundDrawables()[DRAWABLE_LEFT].getBounds().width() >= motionEvent.getX()) {
                if (onDrawableClickListener != null)
                    onDrawableClickListener.onLeftClick();
                return true;
            } else if (getRight() - getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width() <= motionEvent.getX()) {
                if (onDrawableClickListener != null)
                    onDrawableClickListener.onRightClick();
                return true;
            }
        /*else if (getTop() > motionEvent.getY()
                && (getTop() - getCompoundDrawables()[DRAWABLE_TOP].getBounds().height()) < motionEvent.getX()) {
            if (onDrawableClickListener != null)
                onDrawableClickListener.onTopClick();
            return true;
        }*/
        }
        return false;
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (textWatcher2 != null)
            textWatcher2.afterTextChanged(editable.toString());
    }

    public void addTextChangedListener2(TextWatcher2 textWatcher2) {
        addTextChangedListener(this);
        this.textWatcher2 = textWatcher2;
    }

    public void setTextSilently(String input) {
        removeTextChangedListener(this);
        setText("");
        append(input);
        addTextChangedListener(this);
    }

    public void removeTextChangedListener() {
    }

    public interface onDrawableClickListener {
        void onLeftClick();

        void onRightClick();

        //void onTopClick();
    }

    public interface TextWatcher2 {
        void afterTextChanged(String s);
    }
}
