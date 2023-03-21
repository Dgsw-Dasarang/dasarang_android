object Kotlin {
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.KOTLINX_COROUTINES}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.KOTLINX_COROUTINES}"
}
object Libraries {
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Version.RETROFIT}"
    const val RETROFIT_CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:${Version.RETROFIT}"
    const val OKHTTP = "com.squareup.okhttp3:okhttp:${Version.OKHTTP}"
    const val OKHTTP_LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Version.OKHTTP}"
    const val RETORFIT_CONVERTER_SCALARS = "com.squareup.retrofit2:converter-scalars:${Version.RETROFIT}"

    const val GLIDE = "com.github.bumptech.glide:glide:${Version.GLIDE}"
    const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:${Version.GLIDE}"
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

        const val VIEWPAGER2 = "androidx.viewpager2:viewpager2:${Version.VIEWPAGER2}"
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