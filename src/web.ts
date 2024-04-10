import { WebPlugin } from '@capacitor/core';

import type { AppLanguagePlugin } from './definitions';

export class AppLanguageWeb extends WebPlugin implements AppLanguagePlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
