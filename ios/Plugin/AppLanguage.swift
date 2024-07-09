import Foundation
import SwiftUI

@objc public class AppLanguage: NSObject {
    @objc public func getApplicationLocales() -> [String] {
        return Bundle.main.preferredLocalizations
    }

    @objc public func getSystemLocales() -> [String] {
        return Locale.preferredLanguages
    }

    @objc public func openSettings() {
        // Create the URL that deep links to your app's custom settings.
        if let url: URL = .init(string: UIApplication.openSettingsURLString), UIApplication.shared.canOpenURL(url) {
            // Ask the system to open that URL.
            UIApplication.shared.open(url)
        }
    }
}
