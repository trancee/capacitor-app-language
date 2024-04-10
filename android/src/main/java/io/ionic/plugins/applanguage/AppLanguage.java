package io.ionic.plugins.applanguage;

import android.app.LocaleConfig;
import android.app.LocaleManager;
import android.os.Build;
import android.os.LocaleList;
import android.util.Log;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.LocaleManagerCompat;
import androidx.core.os.LocaleListCompat;

public class AppLanguage {

    private final AppLanguagePlugin plugin;

    public AppLanguage(AppLanguagePlugin plugin) {
        this.plugin = plugin;
    }

    public String getApplicationLocales() {
        Log.i("getApplicationLocales", "");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            LocaleList locales = plugin
                .getContext()
                .getSystemService(LocaleManager.class)
                .getApplicationLocales(plugin.getContext().getPackageName());

            return locales.toLanguageTags();
            /*
        } else {
            LocaleListCompat locales =
                    LocaleManagerCompat.getApplicationLocales(this.context);

            return locales.toLanguageTags();
        */
        } else {
            LocaleListCompat locales = AppCompatDelegate.getApplicationLocales();

            return locales.toLanguageTags();
        }
    }

    public void setApplicationLocales(String locales) {
        Log.i("setApplicationLocales", locales);

        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(locales));
    }

    public void resetApplicationLocales() {
        Log.i("resetApplicationLocales", "");

        AppCompatDelegate.setApplicationLocales(LocaleListCompat.getEmptyLocaleList());
    }

    public AppLocaleConfig getOverrideLocaleConfig() throws UnsupportedOperationException {
        Log.i("getOverrideLocaleConfig", "");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            AppLocaleConfig result = new AppLocaleConfig();

            LocaleConfig overrideLocaleConfig = plugin.getContext().getSystemService(LocaleManager.class).getOverrideLocaleConfig();

            if (overrideLocaleConfig != null) {
                LocaleList supportedLocales = overrideLocaleConfig.getSupportedLocales();

                if (supportedLocales != null) {
                    result.setLocales(supportedLocales.toLanguageTags());
                }

                result.setStatus(overrideLocaleConfig.getStatus());
            }

            return result;
        } else {
            throw new UnsupportedOperationException("Only available on Android API 34 and later.");
        }
    }

    public void setOverrideLocaleConfig(String locales) throws UnsupportedOperationException {
        Log.i("setOverrideLocaleConfig", locales);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            LocaleConfig localeConfig = new LocaleConfig(LocaleList.forLanguageTags(locales));

            plugin.getContext().getSystemService(LocaleManager.class).setOverrideLocaleConfig(localeConfig);
        } else {
            throw new UnsupportedOperationException("Only available on Android API 34 and later.");
        }
    }

    public String getSystemLocales() {
        Log.i("getSystemLocales", "");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            LocaleList locales = plugin.getContext().getSystemService(LocaleManager.class).getSystemLocales();

            return locales.toLanguageTags();
        } else {
            LocaleListCompat locales = LocaleManagerCompat.getSystemLocales(plugin.getContext());

            return locales.toLanguageTags();
        }
    }
}
