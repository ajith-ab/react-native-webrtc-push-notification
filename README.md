
# react-native-webrtc-push-notification

## Getting started

`$ npm install react-native-webrtc-push-notification --save`

### Mostly automatic installation

`$ react-native link react-native-webrtc-push-notification`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-webrtc-push-notification` and add `RNWebrtcPushNotification.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNWebrtcPushNotification.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.ajith.RNWebrtcPushNotificationPackage;` to the imports at the top of the file
  - Add `new RNWebrtcPushNotificationPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-webrtc-push-notification'
  	project(':react-native-webrtc-push-notification').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-webrtc-push-notification/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-webrtc-push-notification')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNWebrtcPushNotification.sln` in `node_modules/react-native-webrtc-push-notification/windows/RNWebrtcPushNotification.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Webrtc.Push.Notification.RNWebrtcPushNotification;` to the usings at the top of the file
  - Add `new RNWebrtcPushNotificationPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNWebrtcPushNotification from 'react-native-webrtc-push-notification';

// TODO: What to do with the module?
RNWebrtcPushNotification;
```
