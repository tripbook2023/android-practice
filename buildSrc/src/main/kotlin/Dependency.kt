//싱글톤 관리

object Apps {
    const val compileSdk = 33
    const val minSdk = 24
    const val targetSdk = 32
    const val versionCode = 1
    const val versionName = "1.0"

}





object Dependency {

   //AndroidX
    const val APP_COMPAT = "1.6.1"
    const val MATERIAL = "1.8.0"
    const val CONSTRAINT_LAYOUT = "2.1.4"

    //KTX
    const val CORE = "1.7.0"

    //TEST
    const val JUNIT_TEST = "4.13.2"

    //Android Test
    const val JUNIT = "1.1.5"
    const val ESPRESSO_CORE = "1.3.9"

    //coroutines
    const val COROUTINES = "1.3.9"

    //viewmodel
    const val VIEW_MODEL = "2.6.1"

    //glide
    const val GILDE = "4.15.1"

    //hilt
    const val HILT = "2.44"

    //retrofit, moshi
    const val RETROFIT = "2.9.0"
    const val MOSHI = "2.9.0"

}

object Libraries {

    object AndroidX {
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Dependency.APP_COMPAT}"
        const val MATERIAL = "com.google.android.material:material:${Dependency.MATERIAL}"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Dependency.CONSTRAINT_LAYOUT}"
    }

    object KTX {
        const val CORE = "androidx.core:core-ktx:${Dependency.CORE}"
    }

    object TEST {
        const val JUNIT_TEST = "junit:junit:${Dependency.JUNIT_TEST}"
    }

    object AndroidTest {
        const val JUNIT = "androidx.test.ext:junit:${Dependency.JUNIT}"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Dependency.ESPRESSO_CORE}"
    }

    object Coroutines {
        const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Dependency.COROUTINES}"
    }

    object Viewmodel {
        const val VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Dependency.VIEW_MODEL}"
    }

    object Glide {
        const val GILDE = "com.github.bumptech.glide:glide:${Dependency.GILDE}"
    }

    object Hilt {
        const val HILT = "com.google.dagger:hilt-android:${Dependency.HILT}"
    }

    object Retrofit {
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Dependency.RETROFIT}"
        const val MOSHI = "com.squareup.retrofit2:converter-moshi:${Dependency.MOSHI}"
    }
}