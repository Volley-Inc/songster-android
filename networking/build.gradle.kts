plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.kotlin.android)
}

android { namespace = "com.songster.networking" }

dependencies {
  implementation(libs.kotlinx.serialization.json)
  implementation(libs.coroutines.core)
  implementation(projects.types)
}
