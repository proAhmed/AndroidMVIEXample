plugins {
  androidLib
  kotlinAndroid
}

android {
  compileSdk = appConfig.compileSdkVersion
  buildToolsVersion = appConfig.buildToolsVersion

  defaultConfig {
    minSdk = appConfig.minSdkVersion
    targetSdk = appConfig.targetSdkVersion

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = true
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
      )
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions { jvmTarget = JavaVersion.VERSION_1_8.toString() }
}

dependencies {
  implementation(core)
  implementation(domain)

  implementation(deps.coroutines.core)

  implementation(deps.squareup.retrofit)
  implementation(deps.squareup.moshiKotlin)
  implementation(deps.squareup.converterMoshi)
  implementation(deps.squareup.loggingInterceptor)

  implementation(deps.koin.core)
}
