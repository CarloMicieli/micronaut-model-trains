plugins { id("io.github.carlomicieli.trains.java-library-conventions") }

dependencies {
  implementation(libs.slugify)
  implementation(project(":libs:common"))

  annotationProcessor("io.micronaut.serde:micronaut-serde-processor")
  implementation("io.micronaut.serde:micronaut-serde-jackson")
}
