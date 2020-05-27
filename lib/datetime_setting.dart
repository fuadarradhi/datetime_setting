import 'dart:async';

import 'package:flutter/services.dart';

class DatetimeSetting {
  static const MethodChannel _channel =
      const MethodChannel('datetime_setting');

  static Future<bool> timeIsAuto() async {
    return await _channel.invokeMethod('timeIsAuto');
  }

  static Future<bool> timeZoneIsAuto() async {
    return await _channel.invokeMethod('timeZoneIsAuto');
  }

  static Future<void> openSetting() async {
    return await _channel.invokeMethod('openSetting');
  }
}
