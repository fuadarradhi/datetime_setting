package com.fuadarradhi.datetime_setting;

import android.content.Intent;
import android.os.Build;
import android.provider.Settings;

import androidx.annotation.NonNull;

import android.content.Context;
import android.content.ContextWrapper;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.plugin.common.BinaryMessenger;

/**
 * DatetimeSettingPlugin
 */
public class DatetimeSettingPlugin implements FlutterPlugin, MethodCallHandler {
    private Context applicationContext;
    private MethodChannel methodChannel;

    @Override
    public void onAttachedToEngine(FlutterPluginBinding binding) {
        onAttachedToEngine(binding.getApplicationContext(), binding.getBinaryMessenger());
    }

    private void onAttachedToEngine(Context applicationContext, BinaryMessenger messenger) {
        this.applicationContext = applicationContext;
        methodChannel = new MethodChannel(messenger, "datetime_setting");
        methodChannel.setMethodCallHandler(this);
    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, Result result) {
        switch (call.method) {
            case "timeIsAuto":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    result.success(Settings.Global.getInt(this.applicationContext.getContentResolver(), Settings.Global.AUTO_TIME, 0) == 1);
                } else {
                    result.success(Settings.System.getInt(this.applicationContext.getContentResolver(), Settings.Global.AUTO_TIME, 0) == 1);
                }
                break;

            case "timeZoneIsAuto":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    result.success(Settings.Global.getInt(this.applicationContext.getContentResolver(), Settings.Global.AUTO_TIME_ZONE, 0) == 1);
                } else {
                    result.success(Settings.System.getInt(this.applicationContext.getContentResolver(), Settings.Global.AUTO_TIME_ZONE, 0) == 1);
                }
                break;
            case "openSetting":
                Intent intent = new Intent(android.provider.Settings.ACTION_DATE_SETTINGS);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                applicationContext.startActivity(intent);
                result.success(true);
                break;
            default:
                result.notImplemented();
                break;
        }
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
        applicationContext = null;
        methodChannel.setMethodCallHandler(null);
        methodChannel = null;
    }
}
