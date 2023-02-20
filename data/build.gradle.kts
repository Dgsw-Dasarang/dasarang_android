plugins {
    id(Plugin.library)
    id(Plugin.kotlin)
    id(Plugin.kotlinKapt)
    id(Plugin.kotlinParcelize)
    id(Plugin.daggerPlugin)
    id(Plugin.kt_lint) version Version.KT_LINT
}

android {
    namespace = AppConfig.pathData
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = AppConfig.testInstrumentationRunner
    }

    compileOptions {
        sourceCompatibility = AppConfig.javaVersion
        targetCompatibility = AppConfig.javaVersion
    }
    kotlinOptions {
        jvmTarget = AppConfig.jvmTarget
    }
}

dependencies {
    testImplementation(Libraries.Test.JUNIT)
    androidTestImplementation(Libraries.AndroidTest.ESPRESSO_CORE)

    // hilt
    implementation(Google.HILT_ANDROID)
    kapt(Google.HILT_ANDROID_COMPILER)

    implementation(project(AppConfig.domain))
}