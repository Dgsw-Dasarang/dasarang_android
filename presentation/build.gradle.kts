plugins {
    id(Plugin.application)
    id(Plugin.kotlin)
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

    implementation(project(AppConfig.domain))
    implementation(project(AppConfig.data))
}