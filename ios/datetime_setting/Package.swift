// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "datetime_setting",
    platforms: [
        .iOS("12.0")
    ],
    products: [
        .library(name: "datetime-setting", targets: ["datetime_setting"])
    ],
    dependencies: [],
    targets: [
        .target(
            name: "datetime_setting",
            dependencies: [],
            path: "Sources/datetime_setting"
        )
    ]
)
