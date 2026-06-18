import com.vanniktech.maven.publish.VersionCatalog

plugins {
    `version-catalog`
    id("com.vanniktech.maven.publish") version "0.36.0"
    id("nl.littlerobots.version-catalog-update") version "1.0.1" // For CI to automatically update the catalog
}

group = "info.phpduy"
version = "2026.06.00"

catalog {
    versionCatalog {
        from(files("gradle/libs.versions.toml"))
    }
}

versionCatalogUpdate {
    sortByKey.set(false)
}

mavenPublishing {
    configure(VersionCatalog())

    publishToMavenCentral()

    signAllPublications()

    coordinates("info.phpduy", "version-catalog", "2026.06.00")

    pom {
        name.set("Version Catalog")
        description.set("Shared Gradle version catalog.")
        inceptionYear.set("2026")
        url.set("https://github.com/pduy99/version-catalog")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("pduy99")
                name.set("Duy Pham")
                url.set("https://github.com/pduy99")
            }
        }
        scm {
            url.set("https://github.com/pduy99/version-catalog")
            connection.set("scm:git:git://github.com/pduy99/version-catalog.git")
            developerConnection.set("scm:git:ssh://git@github.com/pduy99/version-catalog.git")
        }
    }
}
