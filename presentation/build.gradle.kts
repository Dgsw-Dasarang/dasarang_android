plugins {
    id(Plugin.application)
    id(Plugin.kotlin)
    id(Plugin.kotlinKapt)
    id(Plugin.kotlinParcelize)
    id(Plugin.daggerPlugin)
}

android {
    namespace = AppConfig.appId
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.appId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.testInstrumentationRunner
    }

    buildTypes {
        getByName(AppConfig.release) {
            isMinifyEnabled = AppConfig.isMinifyEnabled
            proguardFiles(getDefaultProguardFile(AppConfig.proguardFilesTxt), AppConfig.proguardFilesPro)
        }
    }
    compileOptions {
        sourceCompatibility = AppConfig.javaVersion
        targetCompatibility = AppConfig.javaVersion
    }
    buildFeatures {
        dataBinding = true
    }
    kotlinOptions {
        jvmTarget = AppConfig.jvmTarget
    }
}

dependencies {

    // AndroidX
    implementation(Libraries.AndroidX.APP_COMPAT)
    implementation(Libraries.AndroidX.MATERIAL)
    implementation(Libraries.AndroidX.CONSTRAINT_LAYOUT)

    // KTX
    implementation(Libraries.KTX.CORE)

    // TEST
    testImplementation(Libraries.Test.JUNIT)

    // AndroidTest
    androidTestImplementation(Libraries.AndroidTest.ESPRESSO_CORE)

    // navigation
    implementation(Libraries.AndroidX.NAVIGATION)
    implementation(Libraries.AndroidX.NAVIGATION_UI_KTX)

    // coroutine
    implementation(Kotlin.COROUTINES_ANDROID)
    implementation(Kotlin.COROUTINES_CORE)

    // room
    implementation(Libraries.AndroidX.ROOM_RUNTIME)
    kapt(Libraries.AndroidX.ROOM_COMPILER)
    implementation(Libraries.AndroidX.ROOM_KTX)

    implementation(Libraries.AndroidX.RUNTIME)

    implementation(Libraries.AndroidX.VIEWMODEL)
    implementation(Libraries.AndroidX.VIEWMODEL_KTX)
    implementation(Libraries.AndroidX.FRAGMENT_KTX)

    // hilt
    implementation(Google.HILT_ANDROID)
    kapt(Google.HILT_ANDROID_COMPILER)

    implementation(project(AppConfig.domain))
    implementation(project(AppConfig.data))
}