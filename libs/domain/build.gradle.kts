plugins { id("io.github.carlomicieli.trains.java-library-conventions") }

dependencies {
  implementation(libs.slugify)
  implementation(project(":libs:common"))
}
