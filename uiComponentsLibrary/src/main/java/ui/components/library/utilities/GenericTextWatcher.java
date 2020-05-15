package ui.components.library.utilities;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class GenericTextWatcher implements TextWatcher {
    private EditText editText;
    private EditTextListener editTextListener;

    public GenericTextWatcher(EditText editText, EditTextListener editTextListener) {
        this.editText = editText;
        this.editTextListener = editTextListener;
    }

    public GenericTextWatcher(EditTextListener editTextListener) {
        this.editTextListener = editTextListener;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (editText != null)
            editTextListener.onResponse(editText, s.toString());
        else
            editTextListener.onResponse(s.toString());

    }

    public interface EditTextListener {
        void onResponse(EditText focusedEditText, String response);

        void onResponse(String response);
    }
}

