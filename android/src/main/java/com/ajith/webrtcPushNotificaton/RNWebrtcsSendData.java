package com.ajith.webrtcPushNotificaton;

import android.content.Intent;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

public class RNWebrtcsSendData {
    private ReactApplicationContext mReactContext;
    public RNWebrtcsSendData(ReactApplicationContext reactContext) {
        mReactContext = reactContext;
    }

    public void sendIntilialData(Promise promise, Intent intent){
        WritableMap params = Arguments.createMap();
        String action = intent.getAction();
        if(action == null){
            promise.reject("error","no new Call Notications");
            return;
        }
        try {
            params.putString("action", action);
            params.putInt("notificationId", intent.getIntExtra("notificationId", 0));
            params.putString("callerId", intent.getStringExtra("callerId"));
            params.putString("message","success");

            switch (action) {
                case "callAnswer":
                    promise.resolve(params);
                    break;
                case "fullScreenIntent":
                    promise.resolve(params);
                    break;
                case "contentTap":
                    promise.resolve(params);
                    break;
                case "missedCallTape":
                    promise.resolve(params);
                    break;
                default:
                    promise.reject("error","no new Call Notications");
                    break;
            }
        }catch (Exception e){
            promise.reject("error",e.toString());
        }
    }

    public  void sentEventToJsModule(Intent intent){
        String action = intent.getAction();
        WritableMap params = Arguments.createMap();
        params.putString("action",action);
        params.putInt("notificationId", intent.getIntExtra("notificationId", 0));
       switch (action){
           case "callAnswer":
                params.putString("callerId", intent.getStringExtra("callerId"));
                sendEvent(mReactContext,"RNWebrtcCallAnswer", params);
                break;
           case "fullScreenIntent":
               params.putString("callerId", intent.getStringExtra("callerId"));
               sendEvent(mReactContext,"RNWebrtcFullScreenIntent", params);
               break;
           case "contentTap":
               params.putString("callerId", intent.getStringExtra("callerId"));
               sendEvent(mReactContext,"RNWebrtcNotificationTap", params);
               break;
           case "callDismiss":
               sendEvent(mReactContext,"RNWebrtcCallDismiss", params);
               break;
           case "missedCallTape":
               params.putString("callerId", intent.getStringExtra("callerId"));
               sendEvent(mReactContext,"RNWebrtcMissedCallTap", params);
               break;
           default:
               break;
       }
    }

    private void sendEvent(ReactContext reactContext,
                           String eventName,
                           @Nullable WritableMap params) {
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }

}
