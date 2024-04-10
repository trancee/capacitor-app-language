import Foundation

@objc public class AppLanguage: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
