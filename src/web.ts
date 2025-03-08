import { WebPlugin } from '@capacitor/core';
import { I18n } from 'i18n-js';

import type {
  AppLanguagePlugin,
  InitializeOptions,
  LanguageChangedEvent,
  LocalesOptions,
  LocalesResult,
  LocaleConfigOptions,
  LocaleConfigResult,
} from './definitions';

export class AppLanguageWeb extends WebPlugin implements AppLanguagePlugin {
  public static readonly languageChangeEvent = 'languagechange';
  public static readonly languageChangedEvent = 'languageChanged';

  public static readonly errorNotAvailable = 'Not available on Web.';
  public static readonly errorNotImplemented = 'Not implemented on Web.';

  private _i18n: I18n | undefined;
  get i18n(): I18n | undefined {
    return this._i18n;
  }
  set i18n(i18n: I18n | undefined) {
    this._i18n = i18n;
  }

  async initialize(options?: InitializeOptions): Promise<void> {
    this.i18n = options?.i18n || new I18n();

    this.registerOnLanguageChangedListener();
  }

  async getApplicationLocales(): Promise<LocalesResult> {
    const result: LocalesResult = {};

    const locale = this.i18n?.defaultLocale;
    if (locale) result.locales = [locale];

    return result;
  }

  async setApplicationLocales(options?: LocalesOptions): Promise<void> {
    if (this.i18n) {
      this.i18n.locale = options?.locales?.shift() || '';
    }
  }

  async resetApplicationLocales(): Promise<void> {
    throw this.unimplemented(AppLanguageWeb.errorNotImplemented);
  }

  async getSystemLocales(): Promise<LocalesResult> {
    const result: LocalesResult = {};

    result.locales = navigator.languages.map((locale) => locale);

    return result;
  }

  async getOverrideLocaleConfig(): Promise<LocaleConfigResult> {
    throw this.unavailable(AppLanguageWeb.errorNotAvailable);
  }

  async setOverrideLocaleConfig(options?: LocaleConfigOptions): Promise<void> {
    options; // TS6133: 'options' is declared but its value is never read.
    throw this.unavailable(AppLanguageWeb.errorNotAvailable);
  }

  async openSettings(): Promise<void> {
    throw this.unimplemented(AppLanguageWeb.errorNotImplemented);
  }

  private registerOnLanguageChangedListener(): void {
    addEventListener(
      AppLanguageWeb.languageChangeEvent,

      async () => {
        const result = await this.getSystemLocales();

        const event: LanguageChangedEvent = {
          locales: result.locales,
        };

        this.notifyListeners(AppLanguageWeb.languageChangedEvent, event);
      },
    );
  }
}
