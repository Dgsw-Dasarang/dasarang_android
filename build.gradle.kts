// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugin.application).version(Version.ANDROID).apply(false)
    id(Plugin.library).version(Version.ANDROID).apply(false)
    id(Plugin.jetbrains).version(Version.JETBRAINS).apply(false)
    id(Plugin.jetbrainsJvm).version(Version.JETBRAINS).apply(false)
}