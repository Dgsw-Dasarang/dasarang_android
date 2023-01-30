plugins {
    id(Plugin.library)
    id(Plugin.kotlin)
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
}