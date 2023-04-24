plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
}

android {
    namespace 'com.tripbook.data'
    compileSdk 33

    defaultConfig {
        minSdk 24
        targetSdk 33

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles "consumer-rules.pro"
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
}

dependencies {

    //클린 아키텍처 위한 종속성 추가
    implementation project(':domain')

    implementation(Libraries.AndroidX.MATERIAL)
    testImplementation(Libraries.TEST.JUNIT_TEST)
    androidTestImplementation(Libraries.AndroidTest.ESPRESSO_CORE)

    /*testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'*/



    //retrofit, moshi
    implementation(Libraries.Retrofit.RETROFIT)
    implementation(Libraries.Retrofit.MOSHI)

    /*implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-moshi:2.9.0'*/
}