package io.ionic.plugins.applanguage;

public class AppLocaleConfig {

    private String locales;
    private int status;

    AppLocaleConfig() {}

    public String getLocales() {
        return locales;
    }

    public void setLocales(String locals) {
        this.locales = locals;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
