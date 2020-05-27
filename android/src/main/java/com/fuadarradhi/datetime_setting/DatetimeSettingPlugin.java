package com.fuadarradhi.datetime_setting;

import android.content.Intent;
import android.os.Build;
import android.provider.Settings;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** DatetimeSettingPlugin */
public class DatetimeSettingPlugin implements MethodCallHandler {
  private MethodChannel channel;
  Registrar registrar;

  DatetimeSettingPlugin(Registrar registrar){
    this.registrar = registrar;
  }

  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "datetime_setting");
    channel.setMethodCallHandler(new DatetimeSettingPlugin(registrar));
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    switch (call.method){
      case "timeIsAuto":
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
        result.success(Settings.Global.getInt(registrar.context().getContentResolver(), Settings.Global.AUTO_TIME,0)==1);
        }else{
          result.success(Settings.System.getInt(registrar.context().getContentResolver(), Settings.Global.AUTO_TIME,0)==1);
        }
        break;
      case "timeZoneIsAuto":
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
          result.success(Settings.Global.getInt(registrar.context().getContentResolver(), Settings.Global.AUTO_TIME_ZONE,0) == 1);
        }else{
          result.success(Settings.System.getInt(registrar.context().getContentResolver(), Settings.Global.AUTO_TIME_ZONE, 0) == 1);
        }
        break;

      case "openSetting":
        registrar.activity().startActivity(new Intent(Settings.ACTION_DATE_SETTINGS));
        result.success(true);
        break;
      default:
        result.notImplemented();
        break;
    }
  }

}
