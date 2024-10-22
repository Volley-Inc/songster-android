import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
  alias(libs.plugins.android.application) apply false
  alias(libs.plugins.kotlin.android) apply false
  alias(libs.plugins.kotlin.compose) apply false
  alias(libs.plugins.android.library) apply false
}

subprojects {
  val commonAndroidConfig: CommonExtension<*, *, *, *, *, *>.() -> Unit = {
    compileSdk = 34
    compileOptions {
      sourceCompatibility = libs.versions.jvmTarget.map(JavaVersion::toVersion).get()
      targetCompatibility = libs.versions.jvmTarget.map(JavaVersion::toVersion).get()
    }
  }
  pluginManager.withPlugin("com.android.library") {
    with(extensions.getByType<LibraryExtension>()) {
      commonAndroidConfig()
      defaultConfig { minSdk = 31 }
    }
  }
}
