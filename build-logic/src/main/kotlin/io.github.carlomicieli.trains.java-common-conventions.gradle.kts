@file:Suppress("UnstableApiUsage")

import org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
import org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED
import org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED
import org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED

plugins {
    java
    id("com.diffplug.spotless")
}

configurations {
    all {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    implementation {
        resolutionStrategy {
            failOnVersionConflict()
        }
    }
}

configurations {
    compileClasspath {
        resolutionStrategy.activateDependencyLocking()
    }
}

repositories {
    mavenCentral()
}

dependencies {
    versionCatalogs.named("libs")
        .findLibrary("record-builder-processor")
        .ifPresent {
        annotationProcessor(it)
    }
    versionCatalogs.named("libs")
        .findLibrary("record-builder")
        .ifPresent {
            implementation(it)
        }
}

testing {
    suites {
        // Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
            // Use JUnit Jupiter test framework
            useJUnitJupiter("5.10.0")
        }
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks {
    withType<JavaCompile> {
        options.isIncremental = true
        options.isFork = true
        options.isFailOnError = true

        options.compilerArgs.addAll(
            arrayOf(
                "-Xlint:all",
                "-Xlint:-processing",
                "-Werror"
            )
        )
    }
    test {
        useJUnitPlatform()

        minHeapSize = "512m"
        maxHeapSize = "1G"
        failFast = false
        ignoreFailures = false

        testLogging {
            showStandardStreams = false
            events(PASSED, FAILED, SKIPPED)
            showExceptions = true
            showCauses = true
            showStackTraces = true
            exceptionFormat = FULL
        }
    }
}

spotless {
    java {
        // optional: you can specify import groups directly
        // note: you can use an empty string for all the imports you didn't specify explicitly,
        // '|' to join group without blank line, and '\\#` prefix for static imports
        importOrder("java|javax", "io.github.carlomicieli.trains", "", "\\#io.github.carlomicieli.trains", "\\#")
        removeUnusedImports()

        targetExclude(
            "build/generated/aot*/**",
            "build/generated/openapi/generateServerOpenApiApis/**",
            "build/generated/openapi/generateServerOpenApiModels/**",
        )

        palantirJavaFormat("2.38.0")

        formatAnnotations()  // fixes formatting of type annotations

        licenseHeaderFile("${project.rootDir}/.spotless/header.txt")

        toggleOffOn("fmt:off", "fmt:on")
        indentWithSpaces()
        trimTrailingWhitespace()
        endWithNewline()
    }

    kotlinGradle {
        endWithNewline()
        ktfmt("0.30")
        indentWithSpaces()
        trimTrailingWhitespace()
    }
}
