plugins {
    id(Plugin.library)
    id(Plugin.kotlin)
    id(Plugin.kotlinKapt)
    id(Plugin.kotlinParcelize)
    id(Plugin.daggerPlugin)
    id(Plugin.kt_lint) version Version.KT_LINT
}

android {
    namespace = AppConfig.pathDomain
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

    // coroutine
    implementation(Kotlin.COROUTINES_ANDROID)
    implementation(Kotlin.COROUTINES_CORE)

    // room
    implementation(Libraries.AndroidX.ROOM_RUNTIME)
    kapt(Libraries.AndroidX.ROOM_COMPILER)
    implementation(Libraries.AndroidX.ROOM_KTX)

    // retrofit
    implementation(Libraries.RETROFIT)
    implementation(Libraries.RETROFIT_CONVERTER_GSON)
    implementation(Libraries.OKHTTP)
    implementation(Libraries.OKHTTP_LOGGING_INTERCEPTOR)

    // hilt
    implementation(Google.HILT_ANDROID)
    kapt(Google.HILT_ANDROID_COMPILER)
}
