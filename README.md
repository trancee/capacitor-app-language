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

**Since:** 0.0.1

--------------------


### setApplicationLocales(...)

```typescript
setApplicationLocales(options: LocalesOptions) => Promise<void>
```

Sets the UI locales for the calling app.

Note: Pass an empty locales list to reset to the system locale.

| Param         | Type                                                      |
| ------------- | --------------------------------------------------------- |
| **`options`** | <code><a href="#localesoptions">LocalesOptions</a></code> |

**Since:** 0.0.1

--------------------


### resetApplicationLocales()

```typescript
resetApplicationLocales() => Promise<void>
```

Resets the app locale to the system locale.

**Since:** 0.0.1

--------------------


### getSystemLocales()

```typescript
getSystemLocales() => Promise<LocalesResult>
```

Returns the current system locales, ignoring app-specific overrides.

**Returns:** <code>Promise&lt;<a href="#localesresult">LocalesResult</a>&gt;</code>

**Since:** 0.0.1

--------------------


### getOverrideLocaleConfig()

```typescript
getOverrideLocaleConfig() => Promise<LocaleConfigResult>
```

Returns the override `LocaleConfig` for the calling app.

**Returns:** <code>Promise&lt;<a href="#localeconfigresult">LocaleConfigResult</a>&gt;</code>

**Since:** 0.0.1

--------------------


### setOverrideLocaleConfig(...)

```typescript
setOverrideLocaleConfig(options: LocaleConfigOptions) => Promise<void>
```

Sets the override `LocaleConfig` for the calling app.

Note: Only the app itself with the same user can override its own `LocaleConfig`.

| Param         | Type                                                      |
| ------------- | --------------------------------------------------------- |
| **`options`** | <code><a href="#localesoptions">LocalesOptions</a></code> |

**Since:** 0.0.1

--------------------


### Type Aliases


#### LocalesResult

<code>{ /** * Returns the locales supported by the specified application. * * @since 0.0.1 */ locales?: string[]; }</code>


#### LocalesOptions

<code>{ /** * The list of locales. * * @since 0.0.1 */ locales: string[]; }</code>


#### LocaleConfigResult

<code><a href="#localesresult">LocalesResult</a> | { /** * Get the status of reading the resource file where the `LocaleConfig` was stored. * * @since 0.0.1 */ status: <a href="#status">Status</a>; }</code>


#### LocaleConfigOptions

<code><a href="#localesoptions">LocalesOptions</a></code>


### Enums


#### Status

| Members              | Value          | Description                                                                              | Since |
| -------------------- | -------------- | ---------------------------------------------------------------------------------------- | ----- |
| **`SUCCESS`**        | <code>0</code> | Succeeded reading the `LocaleConfig` structure stored in an XML file.                    | 0.0.1 |
| **`NOT_SPECIFIED`**  | <code>1</code> | No `android:localeConfig` tag on pointing to an XML file that stores the `LocaleConfig`. | 0.0.1 |
| **`PARSING_FAILED`** | <code>2</code> | Malformed input in the XML file where the `LocaleConfig` was stored.                     | 0.0.1 |

</docgen-api>
