export interface AppLanguagePlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
