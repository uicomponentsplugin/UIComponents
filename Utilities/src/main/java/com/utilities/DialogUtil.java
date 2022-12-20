package com.utilities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.viewbinding.ViewBinding;

import com.google.android.material.button.MaterialButton;

import java.util.Calendar;



public class DialogUtil {

    private enum DialogType {
        Progress,
        MessageAlert,
        ConfirmAlert,
        DecisionAlert,
        DecisionAlertMessageHtml
    }

    public static ProgressDialog showProgress(Context ctx, String title, String message) {
        try {
            ProgressDialog progressDialog = ProgressDialog.show(ctx, title, message, true);
            Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (progressDialog.isShowing()) {
                        DialogUtil.dismissProgress(progressDialog);
                        if (ctx != null)
                            DialogUtil.messageAlert(ctx, null, ctx.getString(R.string.common_something_wrong));
                    }
                }
            }, 2 * 60 * 1000);
            return progressDialog;
        } catch (Exception ignore) {
        }
        return null;
    }

    public static void dismissProgress(ProgressDialog Progress) {
        try {
            if (Progress != null)
                Progress.dismiss();
        } catch (Exception ignore) {
        }
    }

    public static void messageAlert(Context ctx, String title, String message) {
        try {
            showAlertDialog(DialogType.MessageAlert, ctx, title, message, null, "OK");
        } catch (Exception ignore) {
        }
    }

    public static void confirmationAlert(Context ctx, String title, String message, String actionText, DialogInterface.OnClickListener callBack) {
        try {
            final AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
            builder.setTitle(title)
                    .setMessage(message)
                    .setCancelable(false);
            builder.setPositiveButton(actionText, callBack);
            builder.create().show();
        } catch (Exception ignore) {
        }
    }

    public static void confirmationAlert(Context ctx, String title, String message, DialogInterface.OnClickListener callBack) {
        try {
            showAlertDialog(DialogType.ConfirmAlert, ctx, title, message, callBack, "OK", "Cancel");
        } catch (Exception ignore) {
        }
    }

    public static void decisionAlert(Context ctx, String title, String message, DialogInterface.OnClickListener posCallback, String... buttonNames) {
        try {
            showAlertDialog(DialogType.DecisionAlert, ctx, title, message, posCallback, buttonNames);
        } catch (Exception ignore) {
        }
    }

    public static void decisionAlertMessageHtml(Context ctx, String title, String message, DialogInterface.OnClickListener posCallback, String... buttonNames) {
        try {
            showAlertDialog(DialogType.DecisionAlertMessageHtml, ctx, title, message, posCallback, buttonNames);
        } catch (Exception ignore) {
        }
    }


    private static void showAlertDialog(DialogType DialogType
            , Context ctx
            , String title
            , String message
            , DialogInterface.OnClickListener posCallback
            , String... buttonNames) {
        try {

            if (title != null && title.equals(""))
                title = null;

            if (message == null) message = "default message";

            final AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
            builder.setTitle(title)
                    .setMessage(message)

                    // false = pressing back button won't dismiss this alert
                    .setCancelable(false);

            // icon on the left of title
            //.setIcon(android.R.drawable.ic_dialog_alert);

            switch (DialogType) {
                case MessageAlert:
                    break;

                case ConfirmAlert:
                    builder.setPositiveButton(buttonNames[0], posCallback);
                    builder.setNegativeButton(buttonNames[1], posCallback);
                    builder.create().show();
                    return;

                case DecisionAlert:
                    builder.setPositiveButton(buttonNames[0], posCallback);
                    break;
                case DecisionAlertMessageHtml:
                    builder.setMessage(Html.fromHtml(message))
                            .setPositiveButton(buttonNames[0], posCallback);
                    break;
            }

            builder.setNegativeButton(buttonNames[buttonNames.length - 1], new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).create().show();
        } catch (Exception ignore) {
        }
    }

    public static Dialog getCustomDialog(ViewBinding binding) {
        Dialog dialog = new Dialog(binding.getRoot().getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(binding.getRoot());
        if (dialog.getWindow() != null)
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return dialog;
    }

    /*public static Dialog showAlertDialogV2(Context ctx, String heading, String description) {
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            View dialogInfoView = inflater.inflate(R.layout.layout_card_info, null);
            TextView txtInfoHeading = dialogInfoView.findViewById(R.id.txtInfoHeading);
            TextView txtInfoDescripton = dialogInfoView.findViewById(R.id.txtInfoDescripton);
            txtInfoHeading.setText(heading);
            txtInfoDescripton.setText(description);
            Dialog dialog = new Dialog(ctx);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(dialogInfoView);
            return dialog;
        } else {
            Toast.makeText(ctx, R.string.txtSomethingWrong, Toast.LENGTH_LONG).show();
            return null;
        }
    }*/


    public static void showTimePicker(Context context, OnTimeSelectListener onTimeSelectListener) {
        Calendar calendar = Calendar.getInstance();
        final TimePickerDialog timePickerDialog = new TimePickerDialog(context, 0, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                calendar.set(calendar.get(Calendar.YEAR)
                        , calendar.get(Calendar.MONTH)
                        , calendar.get(Calendar.DAY_OF_MONTH)
                        , hourOfDay
                        , minute);
                onTimeSelectListener.onTimeSelect(calendar);
            }
        }
                , calendar.get(Calendar.HOUR_OF_DAY)
                , calendar.get(Calendar.MINUTE)
                , false);
        timePickerDialog.show();
    }

    public static void showDatePicker(Context context, @NonNull OnDateSelectListener onDateSelectListener) {
        showDatePicker(context, Calendar.getInstance(), onDateSelectListener);
    }

    public static void showDatePicker(Context context, @NonNull OnDateSelectListener onDateSelectListener, long... dateMinAndMaxInMillis) {
        showDatePicker(context, Calendar.getInstance(), onDateSelectListener, dateMinAndMaxInMillis);
    }

    public static void showDatePicker(Context context, @NonNull Calendar calendar, @NonNull OnDateSelectListener onDateSelectListener, long... dateMinAndMaxInMillis) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, 0, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMonth);
                onDateSelectListener.onDateSelect(calendar);
            }
        }
                , calendar.get(Calendar.YEAR)
                , calendar.get(Calendar.MONTH)
                , calendar.get(Calendar.DAY_OF_MONTH)
        );
        if (dateMinAndMaxInMillis != null
                && dateMinAndMaxInMillis.length > 0
                && dateMinAndMaxInMillis[0] != 0)
            datePickerDialog.getDatePicker().setMinDate(dateMinAndMaxInMillis[0]);
        if (dateMinAndMaxInMillis != null
                && dateMinAndMaxInMillis.length > 1
                && dateMinAndMaxInMillis[1] != 0)
            datePickerDialog.getDatePicker().setMaxDate(dateMinAndMaxInMillis[1]);
        datePickerDialog.show();
    }

    public interface OnDateSelectListener {
        void onDateSelect(Calendar calendar);
    }

    public interface OnTimeSelectListener {
        void onTimeSelect(Calendar calendar);
    }
}

