plugins {
  //noinspection JavaPluginLanguageLevel
  id("java-library")
  alias(libs.plugins.jetbrains.kotlin.jvm)
  alias(libs.plugins.kotlin.plugin.serialization)
}

dependencies {
  implementation(libs.kotlinx.serialization.json)
}
