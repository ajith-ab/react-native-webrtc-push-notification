
import { NativeModules, NativeEventEmitter } from 'react-native';

const { RNWebrtcPushNotification } = NativeModules;

export const RNWebrtcPushNotificationEvents = new NativeEventEmitter(RNWebrtcPushNotification);

export default RNWebrtcPushNotification;
