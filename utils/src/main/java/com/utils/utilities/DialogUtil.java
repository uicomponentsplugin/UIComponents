package com.utils.utilities;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AlertDialog;

import com.utils.R;


public class DialogUtil {

    private enum DialogType {
        Progress,
        MessageAlert,
        ConfirmAlert,
        DecisionAlert
    }

    public static ProgressDialog showProgress(Context ctx, String title, String message) {
        try {
            return ProgressDialog.show(ctx, title, message, true);
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

    public static void confirmationAlert(Context ctx, String title, String message, DialogInterface.OnClickListener callBack) {
        try {
            showAlertDialog(DialogType.ConfirmAlert, ctx, title, message, callBack, "OK");
        } catch (Exception ignore) {
        }
    }

    public static void decisionAlert(Context ctx, String title, String message, DialogInterface.OnClickListener posCallback, String... buttonNames) {
        try {
            showAlertDialog(DialogType.DecisionAlert, ctx, title, message, posCallback, buttonNames);
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
                title = ctx.getResources().getString(R.string.title);

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
                    builder.create().show();
                    return;

                case DecisionAlert:
                    builder.setPositiveButton(buttonNames[0], posCallback);
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

    public static Dialog showNoTitleCustomDialog(Context ctx, View dialogView) {
        Dialog dialog = new Dialog(ctx);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(dialogView);
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
}
