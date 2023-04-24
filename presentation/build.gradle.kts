plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    //id 'dagger.hilt.android.plugin'
    id ("kotlin-kapt")
}

android {
    namespace 'com.tripbook.suyeontoyproject'
    compileSdk 33

    dataBinding {
        enabled  true
    }

    defaultConfig {
        applicationId "com.tripbook.suyeontoyproject"
        minSdk 24
        targetSdk 32
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = '1.8'
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    //클린 아키텍처 위한 종속성 추가
    implementation project(':data')
    implementation project(':domain')


    implementation(Libraries.AndroidX.APP_COMPAT)
    implementation(Libraries.AndroidX.MATERIAL)
    implementation(Libraries.AndroidX.CONSTRAINT_LAYOUT)

    implementation(Libraries.KTX.CORE)

    testImplementation(Libraries.TEST.JUNIT_TEST)
    androidTestImplementation(Libraries.AndroidTest.JUNIT)
    androidTestImplementation(Libraries.AndroidTest.ESPRESSO_CORE)


    implementation(Libraries.Glide.GILDE)
    annotationProcessor 'com.github.bumptech.glide:compiler:4.15.1'
    implementation(Libraries.Viewmodel.VIEW_MODEL)
    implementation(Libraries.Coroutines.COROUTINES)
    implementation(Libraries.Hilt.HILT)

/*    implementation 'androidx.core:core-ktx:1.7.0'
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.8.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'

    //coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")

    //viewmodel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

    //glide
    implementation 'com.github.bumptech.glide:glide:4.15.1'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.15.1'

    //hilt
    implementation ("com.google.dagger:hilt-android:2.44")*/

}