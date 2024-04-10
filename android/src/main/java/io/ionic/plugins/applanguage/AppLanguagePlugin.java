package io.ionic.plugins.applanguage;

import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import org.json.JSONException;

@CapacitorPlugin(name = "AppLanguage")
public class AppLanguagePlugin extends Plugin {

    private AppLanguage implementation;

    public void load() {
        implementation = new AppLanguage(this);
    }

    @PluginMethod
    public void getApplicationLocales(PluginCall call) {
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
    }

    @PluginMethod
    public void setApplicationLocales(PluginCall call) throws JSONException {
        JSArray jsLocales = call.getArray("locales");

        if (jsLocales != null && jsLocales.length() > 0) {
            StringBuilder locales = new StringBuilder();

            for (Object locale : jsLocales.toList()) {
                locales.append(locale);
            }

            implementation.setApplicationLocales(locales.toString());
        }

        call.resolve();
    }

    @PluginMethod
    public void resetApplicationLocales(PluginCall call) {
        implementation.resetApplicationLocales();

        call.resolve();
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
        } catch (UnsupportedOperationException e) {
            call.unavailable(e.getMessage());
        }
    }

    @PluginMethod
    public void setOverrideLocaleConfig(PluginCall call) throws JSONException {
        JSArray jsLocales = call.getArray("locales");

        if (jsLocales.length() > 0) {
            StringBuilder locales = new StringBuilder();

            for (Object locale : jsLocales.toList()) {
                locales.append(locale);
            }

            try {
                implementation.setOverrideLocaleConfig(locales.toString());
            } catch (UnsupportedOperationException e) {
                call.unavailable(e.getMessage());
            }
        }

        call.resolve();
    }

    @PluginMethod
    public void getSystemLocales(PluginCall call) {
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
    }
}
