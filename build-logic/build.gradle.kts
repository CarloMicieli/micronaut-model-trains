plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation(libs.spotless.plugin)
    implementation(libs.shadow.plugin)
    implementation(libs.micronaut.plugin)
    implementation(libs.micronaut.aot.plugin)
}
