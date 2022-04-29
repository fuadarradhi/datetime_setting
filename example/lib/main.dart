import 'package:datetime_setting/datetime_setting.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: TextButton(
            child: const Text('Get Information'),
            onPressed: () async {
              bool timeAuto = await DatetimeSetting.timeIsAuto();
              bool timezoneAuto = await DatetimeSetting.timeZoneIsAuto();
              print(timeAuto);
              print(timezoneAuto);

              if (!timezoneAuto || !timeAuto) {
                DatetimeSetting.openSetting();
              }
            },
          ),
        ),
      ),
    );
  }
}
