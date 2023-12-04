dependencyResolutionManagement {
    versionCatalogs {
        create("libs", { from(files("../gradle/libs.versions.toml")) })
    }
}

rootProject.name = "micronaut-model-trains-build-logic"
