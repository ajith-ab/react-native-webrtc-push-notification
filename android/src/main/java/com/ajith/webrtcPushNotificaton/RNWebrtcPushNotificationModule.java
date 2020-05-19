
package com.ajith.webrtcPushNotificaton;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.util.Log;

import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Promise;
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
    sendjsData.sentEventToJsModule(intent);
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
  public void clearAllNotifications(){
    rnWebrtcNotificationHelper.clearAllNorifications();
  }


  @ReactMethod
  public void getInitialNotificationActions(Promise promise) {
    Activity activity = getCurrentActivity();
    Intent intent = activity.getIntent();
    sendjsData.sendIntilialData(promise,intent);
  }


  @ReactMethod
  public void playRingtune(String fileName, Boolean isLooping){
    RNWebrtcRingtunePlayer.getInstance(reactContext).playRingtune(fileName, isLooping);
  }

  @ReactMethod
  public void  stopRingtune(){
    RNWebrtcRingtunePlayer.getInstance(reactContext).stopMusic();
  }



  @ReactMethod
  public  void  showMissedCallNotification(String title, String body, String callerId){
    rnWebrtcNotificationHelper.showMissCallNotification(title,body, callerId);
  }
}