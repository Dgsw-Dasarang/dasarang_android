object Kotlin {
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.KOTLINX_COROUTINES}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.KOTLINX_COROUTINES}"
}
object Libraries {

    object AndroidX {
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Version.APP_COMPAT}"
        const val MATERIAL = "com.google.android.material:material:${Version.MATERIAL}"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Version.CONSTRAINT_LAYOUT}"

        const val NAVIGATION = "androidx.navigation:navigation-fragment-ktx:${Version.NAVIGATION}"
        const val NAVIGATION_UI_KTX = "androidx.navigation:navigation-ui-ktx:${Version.NAVIGATION}"

        const val RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.RUNTIME}"
        const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel:${Version.VIEWMODEL}"
        const val VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.VIEWMODEL}"
        const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Version.FRAGMENT}"

        const val ROOM_RUNTIME = "androidx.room:room-runtime:${Version.ROOM}"
        const val ROOM_KTX = "androidx.room:room-ktx:${Version.ROOM}"
        const val ROOM_COMPILER = "androidx.room:room-compiler:${Version.ROOM}"
    }

    object KTX {
        const val CORE = "androidx.core:core-ktx:${Version.CORE}"
    }

    object Test {
        const val JUNIT = "androidx.test.ext:junit:${Version.JUNIT}"
    }

    object AndroidTest {
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Version.ESPRESSO_CORE}"
    }

}

object Google {
    const val HILT_ANDROID = "com.google.dagger:hilt-android:${Version.HILT}"
    const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:${Version.HILT}"
    const val HILT_ANDROID_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:${Version.HILT}"
    const val MATERIAL = "com.google.android.material:material:${Version.MATERIAL}"
}