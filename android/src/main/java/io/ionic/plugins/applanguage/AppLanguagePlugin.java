package io.ionic.plugins.applanguage;

import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.Logger;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "AppLanguage")
public class AppLanguagePlugin extends Plugin {

    public static final String TAG = "AppLanguage";

    private AppLanguage implementation;

    public void load() {
        implementation = new AppLanguage(this);
    }

    @PluginMethod
    public void initialize(PluginCall call) {
        try {
            implementation.initialize();
            call.resolve();
        } catch (Exception exception) {
            Logger.error(TAG, exception.getMessage(), exception);
            call.reject(exception.getMessage());
        }
    }

    @PluginMethod
    public void getApplicationLocales(PluginCall call) {
        try {
            JSObject result = new JSObject();

            String[] locales = implementation.getApplicationLocales().split(",");

            if (locales.length > 0) {
                JSArray jsLocales = new JSArray();

                for (String locale : locales) {
                    jsLocales.put(locale);
                }

                result.put("locales", jsLocales);
            }

            call.resolve(result);
        } catch (Exception exception) {
            Logger.error(TAG, exception.getMessage(), exception);
            call.reject(exception.getMessage());
        }
    }

    @PluginMethod
    public void setApplicationLocales(PluginCall call) {
        try {
            JSArray jsLocales = call.getArray("locales");

            if (jsLocales != null && jsLocales.length() > 0) {
                StringBuilder locales = new StringBuilder();

                for (Object locale : jsLocales.toList()) {
                    locales.append(locale);
                }

                implementation.setApplicationLocales(locales.toString());
            }

            call.resolve();
        } catch (Exception exception) {
            Logger.error(TAG, exception.getMessage(), exception);
            call.reject(exception.getMessage());
        }
    }

    @PluginMethod
    public void resetApplicationLocales(PluginCall call) {
        try {
            implementation.resetApplicationLocales();

            call.resolve();
        } catch (Exception exception) {
            Logger.error(TAG, exception.getMessage(), exception);
            call.reject(exception.getMessage());
        }
    }

    @PluginMethod
    public void getSystemLocales(PluginCall call) {
        try {
            JSObject result = new JSObject();

            String[] locales = implementation.getSystemLocales().split(",");

            if (locales.length > 0) {
                JSArray jsLocales = new JSArray();

                for (String locale : locales) {
                    jsLocales.put(locale);
                }

                result.put("locales", jsLocales);
            }

            call.resolve(result);
        } catch (Exception exception) {
            Logger.error(TAG, exception.getMessage(), exception);
            call.reject(exception.getMessage());
        }
    }

    @PluginMethod
    public void getOverrideLocaleConfig(PluginCall call) {
        try {
            JSObject result = new JSObject();

            AppLocaleConfig config = implementation.getOverrideLocaleConfig();

            if (config != null) {
                JSArray jsLocales = new JSArray();

                String[] locales = config.getLocales().split(",");

                for (String locale : locales) {
                    jsLocales.put(locale);
                }

                result.put("locales", jsLocales);
                result.put("status", config.getStatus());
            }

            call.resolve(result);
        } catch (UnsupportedOperationException exception) {
            Logger.error(TAG, exception.getMessage(), exception);
            call.unavailable(exception.getMessage());
        } catch (Exception exception) {
            Logger.error(TAG, exception.getMessage(), exception);
            call.reject(exception.getMessage());
        }
    }

    @PluginMethod
    public void setOverrideLocaleConfig(PluginCall call) {
        try {
            JSArray jsLocales = call.getArray("locales");

            if (jsLocales.length() > 0) {
                StringBuilder locales = new StringBuilder();

                for (Object locale : jsLocales.toList()) {
                    locales.append(locale);
                }

                implementation.setOverrideLocaleConfig(locales.toString());
            }

            call.resolve();
        } catch (UnsupportedOperationException exception) {
            Logger.error(TAG, exception.getMessage(), exception);
            call.unavailable(exception.getMessage());
        } catch (Exception exception) {
            Logger.error(TAG, exception.getMessage(), exception);
            call.reject(exception.getMessage());
        }
    }

    @PluginMethod
    public void openSettings(PluginCall call) {
        try {
            implementation.openSettings();

            call.resolve();
        } catch (Exception exception) {
            Logger.error(TAG, exception.getMessage(), exception);
            call.reject(exception.getMessage());
        }
    }
}
