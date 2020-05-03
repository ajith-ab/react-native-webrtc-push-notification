
package com.ajith.webrtcPushNotificaton;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class RNWebrtcPushNotificationModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNWebrtcPushNotificationModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNWebrtcPushNotification";
  }
}