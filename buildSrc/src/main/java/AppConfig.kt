import org.gradle.api.JavaVersion

object AppConfig {
    const val compileSdk = 33
    const val minSdk = 28
    const val targetSdk = 33
    const val versionCode = 6
    const val versionName = "1.0.5"

    const val appId = "co.dasa.dasarang"
    const val pathData = "co.dasa.dasarang.data"
    const val pathDomain = "co.dasa.dasarang.domain"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    const val release = "release"
    const val isMinifyEnabled = false
    const val proguardFilesTxt = "proguard-android-optimize.txt"
    const val proguardFilesPro = "proguard-rules.pro"

    val javaVersion = JavaVersion.VERSION_1_8

    const val jvmTarget = "1.8"

    const val domain = ":domain"
    const val data = ":data"
}