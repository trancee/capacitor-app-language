import { WebPlugin } from '@capacitor/core';

import type {
  AppLanguagePlugin,
  LocalesOptions,
  LocalesResult,
  LocaleConfigOptions,
  LocaleConfigResult,
} from './definitions';

export class AppLanguageWeb extends WebPlugin implements AppLanguagePlugin {
  async getApplicationLocales(): Promise<LocalesResult> {
    const result: LocalesResult = {};

    console.info('getApplicationLocales', result);

    return result;
  }

  async setApplicationLocales(options?: LocalesOptions): Promise<void> {
    console.info('setApplicationLocales', options);
  }

  async resetApplicationLocales(): Promise<void> {
    console.info('resetApplicationLocales');
  }

  async getSystemLocales(): Promise<LocalesResult> {
    const result: LocalesResult = {};

    console.info('getSystemLocales', result);

    return result;
  }

  async getOverrideLocaleConfig(): Promise<LocaleConfigResult> {
    const result: LocaleConfigResult = {};

    console.info('getOverrideLocaleConfig', result);

    return result;
  }

  async setOverrideLocaleConfig(options?: LocaleConfigOptions): Promise<void> {
    console.info('setOverrideLocaleConfig', options);
  }
}
