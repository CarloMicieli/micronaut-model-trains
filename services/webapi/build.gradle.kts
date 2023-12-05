plugins { id("io.github.carlomicieli.trains.java-application-conventions") }

application { mainClass.set("io.github.carlomicieli.trains.app.App") }

dependencies {
  implementation(project(":libs:domain"))
  implementation(project(":libs:application"))
  implementation(project(":libs:framework"))

  annotationProcessor("io.micronaut:micronaut-http-validation")
  annotationProcessor("io.micronaut.serde:micronaut-serde-processor")
  implementation("io.micronaut:micronaut-management")
  implementation("io.micronaut.serde:micronaut-serde-jackson")
  compileOnly("io.micronaut:micronaut-http-client")
  runtimeOnly("ch.qos.logback:logback-classic")
  runtimeOnly("org.yaml:snakeyaml")
  testImplementation("io.micronaut:micronaut-http-client")
}

graalvmNative.toolchainDetection.set(false)

micronaut {
  runtime("netty")
  testRuntime("junit5")
  processing {
    incremental(true)
    annotations("io.github.carlomicieli.trains.*")
  }
  aot {
    // Please review carefully the optimizations enabled below
    // Check https://micronaut-projects.github.io/micronaut-aot/latest/guide/ for more details
    optimizeServiceLoading.set(false)
    convertYamlToJava.set(false)
    precomputeOperations.set(true)
    cacheEnvironment.set(true)
    optimizeClassLoading.set(true)
    deduceEnvironment.set(true)
    optimizeNetty.set(true)
  }
}
