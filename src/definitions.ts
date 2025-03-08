import type { PluginListenerHandle } from '@capacitor/core';
import type { I18n } from 'i18n-js';

export interface AppLanguagePlugin {
  /**
   * Initializes the plugin and injects dependencies.
   *
   * Only available for Web.
   *
   * @since 1.1.0
   */
  initialize(options?: InitializeOptions): Promise<void>;

  /**
   * Returns the UI locales for the calling app.
   *
   * @since 1.0.0
   */
  getApplicationLocales(): Promise<LocalesResult>;

  /**
   * Sets the UI locales for the calling app.
   *
   * Note: Pass an empty locales list to reset to the system locale.
   *
   * Only available for Android.
   *
   * @since 1.0.0
   */
  setApplicationLocales(options: LocalesOptions): Promise<void>;

  /**
   * Resets the app locale to the system locale.
   *
   * Only available for Android.
   *
   * @since 1.0.0
   */
  resetApplicationLocales(): Promise<void>;

  /**
   * Returns the current system locales, ignoring app-specific overrides.
   *
   * @since 1.0.0
   */
  getSystemLocales(): Promise<LocalesResult>;

  /**
   * Returns the override `LocaleConfig` for the calling app.
   *
   * Only available for Android (>= 34) and later.
   *
   * @since 1.0.0
   */
  getOverrideLocaleConfig(): Promise<LocaleConfigResult>;

  /**
   * Sets the override `LocaleConfig` for the calling app.
   *
   * Note: Only the app itself with the same user can override its own `LocaleConfig`.
   *
   * Only available for Android (>= 34) and later.
   *
   * @since 1.0.0
   */
  setOverrideLocaleConfig(options: LocaleConfigOptions): Promise<void>;

  /**
   * Shows settings to allow configuration of per application locale.
   *
   * Only available for iOS and Android (>= 33) and later.
   *
   * @since 1.0.0
   */
  openSettings(): Promise<void>;

  /**
   * Called when the user's preferred language changes.
   *
   * Only available for Web.
   *
   * @since 1.1.0
   */
  addListener(eventName: 'languageChanged', listenerFunc: LanguageChangedListener): Promise<PluginListenerHandle>;
  /**
   * Remove all listeners for this plugin.
   *
   * Only available for Web.
   *
   * @since 1.1.0
   */
  removeAllListeners(): Promise<void>;
}

/**
 * @since 1.1.0
 */
export interface InitializeOptions {
  /**
   * The instance of i18n.
   *
   * Only available for Web.
   *
   * @since 1.1.0
   */
  i18n?: I18n;
}
export type LocalesOptions = {
  /**
   * The list of locales.
   *
   * @since 1.0.0
   */
  locales?: string[];
};

export type LocalesResult = {
  /**
   * Returns the locales supported by the specified application.
   *
   * @since 1.0.0
   */
  locales?: string[];
};

export type LocaleConfigOptions = LocalesOptions;
export type LocaleConfigResult =
  | LocalesResult
  | {
      /**
       * Get the status of reading the resource file where the `LocaleConfig` was stored.
       *
       * @since 1.0.0
       */
      status: Status;
    };

export enum Status {
  /**
   * Succeeded reading the `LocaleConfig` structure stored in an XML file.
   *
   * @since 1.0.0
   */
  SUCCESS = 0,
  /**
   * No `android:localeConfig` tag on pointing to an XML file that stores the `LocaleConfig`.
   *
   * @since 1.0.0
   */
  NOT_SPECIFIED = 1,
  /**
   * Malformed input in the XML file where the `LocaleConfig` was stored.
   *
   * @since 1.0.0
   */
  PARSING_FAILED = 2,
}

/**
 * Callback to receive when the user's preferred language changes.
 *
 * @since 1.1.0
 */
export type LanguageChangedListener = (event: LanguageChangedEvent) => void;

/**
 * @since 1.1.0
 */
export interface LanguageChangedEvent {
  /**
   * Returns an array of strings representing the user's preferred languages.
   *
   * @since 1.1.0
   */
  locales?: string[];
}
