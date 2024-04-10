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
        UIApplication.shared.open(URL(string: UIApplication.openSettingsURLString)!)
    }
}
