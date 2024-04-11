#import <Foundation/Foundation.h>
#import <Capacitor/Capacitor.h>

// Define the plugin using the CAP_PLUGIN Macro, and
// each method the plugin supports using the CAP_PLUGIN_METHOD macro.
CAP_PLUGIN(AppLanguagePlugin, "AppLanguage",
           CAP_PLUGIN_METHOD(getApplicationLocales, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(setApplicationLocales, CAPPluginReturnNone);
           CAP_PLUGIN_METHOD(resetApplicationLocales, CAPPluginReturnNone);

           CAP_PLUGIN_METHOD(getSystemLocales, CAPPluginReturnPromise);

           CAP_PLUGIN_METHOD(getOverrideLocaleConfig, CAPPluginReturnNone);
           CAP_PLUGIN_METHOD(setOverrideLocaleConfig, CAPPluginReturnNone);

           CAP_PLUGIN_METHOD(openSettings, CAPPluginReturnNone);
)
