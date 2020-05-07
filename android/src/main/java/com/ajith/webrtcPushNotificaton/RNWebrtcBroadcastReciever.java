package com.ajith.webrtcPushNotificaton;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class RNWebrtcBroadcastReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Application applicationContext = (Application) context.getApplicationContext();
        RNWebrtcNotificationHelper rnWebrtcNotificationHelper = new RNWebrtcNotificationHelper(applicationContext);
        int notificationId = intent.getIntExtra("notificationId",0);

        switch (intent.getAction()){
            case "callDismiss":
                RNWebrtcRingtunePlayer.getInstance(context).stopMusic();
                rnWebrtcNotificationHelper.clearNotification(notificationId);
                rnWebrtcNotificationHelper.showMissCallNotification(intent.getStringExtra("missedCallTitle"), intent.getStringExtra("missedCallBody"), intent.getStringExtra("callerId"));
                break;
            case "callTimeOut":
                rnWebrtcNotificationHelper.showMissCallNotification(intent.getStringExtra("missedCallTitle"), intent.getStringExtra("missedCallBody"), intent.getStringExtra("callerId"));
                break;
            default:
                break;
        }

    }


}
