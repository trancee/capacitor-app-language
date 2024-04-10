# @capacitor-community/app-language

Per-app language preferences

https://developer.android.com/guide/topics/resources/app-languages

## Install

```bash
npm install @capacitor-community/app-language
npx cap sync
```

## API

<docgen-index>

* [`getApplicationLocales()`](#getapplicationlocales)
* [`setApplicationLocales(...)`](#setapplicationlocales)
* [`resetApplicationLocales()`](#resetapplicationlocales)
* [`getSystemLocales()`](#getsystemlocales)
* [`getOverrideLocaleConfig()`](#getoverridelocaleconfig)
* [`setOverrideLocaleConfig(...)`](#setoverridelocaleconfig)
* [Type Aliases](#type-aliases)
* [Enums](#enums)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### getApplicationLocales()

```typescript
getApplicationLocales() => Promise<LocalesResult>
```

Returns the UI locales for the calling app.

**Returns:** <code>Promise&lt;<a href="#localesresult">LocalesResult</a>&gt;</code>

**Since:** 1.0.0

--------------------


### setApplicationLocales(...)

```typescript
setApplicationLocales(options: LocalesOptions) => Promise<void>
```

Sets the UI locales for the calling app.

Note: Pass an empty locales list to reset to the system locale.

Only available for Android.

| Param         | Type                                                      |
| ------------- | --------------------------------------------------------- |
| **`options`** | <code><a href="#localesoptions">LocalesOptions</a></code> |

**Since:** 1.0.0

--------------------


### resetApplicationLocales()

```typescript
resetApplicationLocales() => Promise<void>
```

Resets the app locale to the system locale.

Only available for Android.

**Since:** 1.0.0

--------------------


### getSystemLocales()

```typescript
getSystemLocales() => Promise<LocalesResult>
```

Returns the current system locales, ignoring app-specific overrides.

**Returns:** <code>Promise&lt;<a href="#localesresult">LocalesResult</a>&gt;</code>

**Since:** 1.0.0

--------------------


### getOverrideLocaleConfig()

```typescript
getOverrideLocaleConfig() => Promise<LocaleConfigResult>
```

Returns the override `LocaleConfig` for the calling app.

Only available for Android API 34 and later.

**Returns:** <code>Promise&lt;<a href="#localeconfigresult">LocaleConfigResult</a>&gt;</code>

**Since:** 1.0.0

--------------------


### setOverrideLocaleConfig(...)

```typescript
setOverrideLocaleConfig(options: LocaleConfigOptions) => Promise<void>
```

Sets the override `LocaleConfig` for the calling app.

Note: Only the app itself with the same user can override its own `LocaleConfig`.

Only available for Android API 34 and later.

| Param         | Type                                                      |
| ------------- | --------------------------------------------------------- |
| **`options`** | <code><a href="#localesoptions">LocalesOptions</a></code> |

**Since:** 1.0.0

--------------------


### Type Aliases


#### LocalesResult

<code>{ /** * Returns the locales supported by the specified application. * * @since 1.0.0 */ locales?: string[]; }</code>


#### LocalesOptions

<code>{ /** * The list of locales. * * @since 1.0.0 */ locales: string[]; }</code>


#### LocaleConfigResult

<code><a href="#localesresult">LocalesResult</a> | { /** * Get the status of reading the resource file where the `LocaleConfig` was stored. * * @since 1.0.0 */ status: <a href="#status">Status</a>; }</code>


#### LocaleConfigOptions

<code><a href="#localesoptions">LocalesOptions</a></code>


### Enums


#### Status

| Members              | Value          | Description                                                                              | Since |
| -------------------- | -------------- | ---------------------------------------------------------------------------------------- | ----- |
| **`SUCCESS`**        | <code>0</code> | Succeeded reading the `LocaleConfig` structure stored in an XML file.                    | 1.0.0 |
| **`NOT_SPECIFIED`**  | <code>1</code> | No `android:localeConfig` tag on pointing to an XML file that stores the `LocaleConfig`. | 1.0.0 |
| **`PARSING_FAILED`** | <code>2</code> | Malformed input in the XML file where the `LocaleConfig` was stored.                     | 1.0.0 |

</docgen-api>
