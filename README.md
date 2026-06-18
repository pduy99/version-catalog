# Helios Version Catalog

A shared [Gradle version catalog](https://docs.gradle.org/current/userguide/version_catalogs.html)
for Helios projects, published to Maven Central. It centralizes dependency and
plugin versions in one place so consuming projects stay in sync.

- **Coordinates:** `info.phpduy:version-catalog:2026.06.00`
- **Catalog source:** [`gradle/libs.versions.toml`](gradle/libs.versions.toml)

## Usage

Add the catalog in your consuming project's `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from("info.phpduy:version-catalog:2026.06.00")
        }
    }
}
```

Then reference entries as usual, e.g. `libs.androidx.core` or
`alias(libs.plugins.kotlin.android)`.
