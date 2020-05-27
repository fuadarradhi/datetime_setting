#import "DatetimeSettingPlugin.h"
#if __has_include(<datetime_setting/datetime_setting-Swift.h>)
#import <datetime_setting/datetime_setting-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "datetime_setting-Swift.h"
#endif

@implementation DatetimeSettingPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftDatetimeSettingPlugin registerWithRegistrar:registrar];
}
@end
