import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(AppLanguagePlugin)
public class AppLanguagePlugin: CAPPlugin {
    private let implementation = AppLanguage()

    @objc func getApplicationLocales(_ call: CAPPluginCall) {
        call.resolve([
            "locales": implementation.getApplicationLocales()
        ])
    }

    @objc func setApplicationLocales(_ call: CAPPluginCall) {
        call.unimplemented("Not implemented on iOS.")
    }

    @objc func resetApplicationLocales(_ call: CAPPluginCall) {
        call.unimplemented("Not implemented on iOS.")
    }

    @objc func getSystemLocales(_ call: CAPPluginCall) {
        call.resolve([
            "locales": implementation.getSystemLocales()
        ])
    }

    @objc func getOverrideLocaleConfig(_ call: CAPPluginCall) {
        call.unimplemented("Not implemented on iOS.")
    }

    @objc func setOverrideLocaleConfig(_ call: CAPPluginCall) {
        call.unimplemented("Not implemented on iOS.")
    }
}
