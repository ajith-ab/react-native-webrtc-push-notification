
package com.ajith.webrtcPushNotificaton;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.util.Log;

import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;


public class RNWebrtcPushNotificationModule extends ReactContextBaseJavaModule implements ActivityEventListener {

  private final ReactApplicationContext reactContext;
  private RNWebrtcNotificationHelper rnWebrtcNotificationHelper;
  private RNWebrtcsSendData sendjsData;
  public static final String LogTag = "WebrtcPushNotification";

  @Override
  public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent intent) {

  }

  @Override
  public void onNewIntent(Intent intent){
    sendjsData.sentEventToJsModule(intent);
  }


  RNWebrtcPushNotificationModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
    reactContext.addActivityEventListener(this);
    Application applicationContext = (Application) reactContext.getApplicationContext();
    rnWebrtcNotificationHelper = new RNWebrtcNotificationHelper(applicationContext);
    sendjsData = new RNWebrtcsSendData(reactContext);
  }


  @Override
  public String getName() {
    return "RNWebrtcPushNotification";
  }



  @ReactMethod
  public void showCallNotification(ReadableMap jsonObject){
    ReadableMap data = RNWebrtcBroadcastConfig.callNotificationConfig(jsonObject);
    rnWebrtcNotificationHelper.sendCallNotification(data);
  }


  @ReactMethod
  public  void clearNotificationById(int id){
    rnWebrtcNotificationHelper.clearNotification(id);
  }

  @ReactMethod
  public  void  sendMissedCallNotification(){
    rnWebrtcNotificationHelper.showMissCallNotification("adas","asdasd", "asdsd");
    Log.i(LogTag, "Missed Call");
  }
}