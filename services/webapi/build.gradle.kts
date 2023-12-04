plugins { id("io.github.carlomicieli.trains.java-application-conventions") }

application { mainClass.set("io.github.carlomicieli.trains.app.App") }

dependencies {
  implementation(project(":libs:domain"))
  implementation(project(":libs:application"))
  implementation(project(":libs:framework"))
}
