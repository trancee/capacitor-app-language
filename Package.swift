// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorTranceeAppLanguage",
    platforms: [.iOS(.v14)],
    products: [
        .library(
            name: "CapacitorTranceeAppLanguage",
            targets: ["AppLanguagePlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", from: "7.0.1")
    ],
    targets: [
        .target(
            name: "AppLanguagePlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/AppLanguagePlugin"),
        .testTarget(
            name: "AppLanguagePluginTests",
            dependencies: ["AppLanguagePlugin"],
            path: "ios/Tests/AppLanguagePluginTests")
    ]
)
