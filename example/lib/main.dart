import 'package:flutter/material.dart';

import 'package:datetime_setting/datetime_setting.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: TextButton(
            child: Text('Get Information Or Open Setting'),
            onPressed: () async {
              bool timeAuto = await DatetimeSetting.timeIsAuto();
              bool timezoneAuto = await DatetimeSetting.timeZoneIsAuto();
              print(timeAuto);
              print(timezoneAuto);
              if (!timeAuto || !timezoneAuto) {
                await DatetimeSetting.openSetting();
              }
            },
          ),
        ),
      ),
    );
  }
}
