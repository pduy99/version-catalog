plugins {
    `version-catalog`
    `maven-publish`
    id("nl.littlerobots.version-catalog-update") version "1.0.1" // For CI to automatically update the catalog
}

catalog {
    versionCatalog {
        from(files("gradle/libs.versions.toml"))
    }
}

versionCatalogUpdate {
    sortByKey.set(false)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.helios"
            from(components["versionCatalog"])
            version = "2026.06.00"
            artifactId = "version-catalog"
        }
    }
    repositories {
        mavenLocal()
    }

}