package com.utils.utilities;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import static com.utils.Constants.CHANNEL_NAME;


public class NotificationUtil {

    private static Notification notificationBuilder(Context context, String channel, String title, String text, int smallIcon, PendingIntent pendingIntent) {
        createNotificationChannel(context, channel);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, (channel == null ? CHANNEL_NAME : channel))
                .setContentTitle(title)
                .setContentText(text)
                .setAutoCancel(true);
        if (smallIcon != 0)
            builder.setSmallIcon(smallIcon);

        if (pendingIntent != null)
            builder.setContentIntent(pendingIntent);

        return builder.build();
    }

    private static void createNotificationChannel(Context context, String channel) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(
                    (channel == null ? CHANNEL_NAME : channel)
                    , (channel == null ? CHANNEL_NAME : channel)
                    , NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                if (notificationManager.getNotificationChannel(channel) == null)
                    notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }

    public static void triggerNotification(Context context, int notificationId, String title, String text) {
        Notification notification = notificationBuilder(context, null, title, text, 0, null);
        notify(context, notificationId, notification);
    }

    public static void triggerNotification(Context context, int notificationId, String title, String text, int smallIcon) {
        Notification notification = notificationBuilder(context, null, title, text, smallIcon, null);
        notify(context, notificationId, notification);
    }

    public static void triggerNotification(Context context, int notificationId, String title, String text, PendingIntent pendingIntent) {
        Notification notification = notificationBuilder(context, null, title, text, 0, pendingIntent);
        notify(context, notificationId, notification);
    }

    public static void triggerNotification(Context context, int notificationId, String title, String text, int smallIcon, PendingIntent pendingIntent) {
        Notification notification = notificationBuilder(context, null, title, text, smallIcon, pendingIntent);
        notify(context, notificationId, notification);
    }

    public static void triggerNotification(Context context, int notificationId, String channel, String title, String text, int smallIcon, PendingIntent pendingIntent) {
        Notification notification = notificationBuilder(context, channel, title, text, smallIcon, pendingIntent);
        notify(context, notificationId, notification);
    }


    private static void notify(Context context, int notificationId, Notification notification) {
        NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
        if (notificationManager != null) {
            notificationManager.notify(notificationId, notification);
        }
    }

    public static Notification getNotification(Context context, String channel, String title, String text, int smallIcon) {
        return notificationBuilder(context, channel, title, text, smallIcon, null);
    }

    public static Notification getNotification(Context context, String channel, String title, String text) {
        return notificationBuilder(context, channel, title, text, 0, null);
    }
}
