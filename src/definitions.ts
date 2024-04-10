export interface AppLanguagePlugin {
  /**
   * Returns the UI locales for the calling app.
   *
   * @since 0.0.1
   */
  getApplicationLocales(): Promise<LocalesResult>;

  /**
   * Sets the UI locales for the calling app.
   *
   * Note: Pass an empty locales list to reset to the system locale.
   *
   * @since 0.0.1
   */
  setApplicationLocales(options: LocalesOptions): Promise<void>;

  /**
   * Resets the app locale to the system locale.
   *
   * @since 0.0.1
   */
  resetApplicationLocales(): Promise<void>;

  /**
   * Returns the current system locales, ignoring app-specific overrides.
   *
   * @since 0.0.1
   */
  getSystemLocales(): Promise<LocalesResult>;

  /**
   * Returns the override `LocaleConfig` for the calling app.
   *
   * @since 0.0.1
   */
  getOverrideLocaleConfig(): Promise<LocaleConfigResult>;

  /**
   * Sets the override `LocaleConfig` for the calling app.
   *
   * Note: Only the app itself with the same user can override its own `LocaleConfig`.
   *
   * @since 0.0.1
   */
  setOverrideLocaleConfig(options: LocaleConfigOptions): Promise<void>;
}

export type LocalesOptions = {
  /**
   * The list of locales.
   *
   * @since 0.0.1
   */
  locales: string[];
};

export type LocalesResult = {
  /**
   * Returns the locales supported by the specified application.
   *
   * @since 0.0.1
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
       * @since 0.0.1
       */
      status: Status;
    };

export enum Status {
  /**
   * Succeeded reading the `LocaleConfig` structure stored in an XML file.
   *
   * @since 0.0.1
   */
  SUCCESS = 0,
  /**
   * No `android:localeConfig` tag on pointing to an XML file that stores the `LocaleConfig`.
   *
   * @since 0.0.1
   */
  NOT_SPECIFIED = 1,
  /**
   * Malformed input in the XML file where the `LocaleConfig` was stored.
   *
   * @since 0.0.1
   */
  PARSING_FAILED = 2,
}
