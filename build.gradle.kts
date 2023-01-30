buildscript {
    dependencies {
        classpath(Google.HILT_ANDROID_PLUGIN)
    }
}

plugins {
    id(Plugin.application).version(Version.ANDROID).apply(false)
    id(Plugin.library).version(Version.ANDROID).apply(false)
    id(Plugin.jetbrains).version(Version.JETBRAINS).apply(false)
    id(Plugin.jetbrainsJvm).version(Version.JETBRAINS).apply(false)
}