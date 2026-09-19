plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)

    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}
android {
    namespace = "com.loc.devradar"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.loc.devradar"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(platform(libs.androidx.compose.bom))
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation("androidx.navigation:navigation-compose:2.8.0")

    // Compose
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Retrofit
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // OkHttp logging
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")

    // Coil
    implementation("io.coil-kt:coil-compose:2.4.0")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.51.1")
    implementation(libs.androidx.paging.common.android)
    kapt("com.google.dagger:hilt-compiler:2.51.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    implementation("androidx.datastore:datastore-preferences:1.1.1")
    // Room
    implementation("androidx.room:room-runtime:2.8.1")
    kapt("androidx.room:room-compiler:2.8.1")
    implementation("androidx.room:room-ktx:2.8.1")

    // Material Icons
    implementation("androidx.compose.material:material-icons-extended")

    // Accompanist (uyumlu sürüm)
    implementation("com.google.accompanist:accompanist-swiperefresh:0.36.0")


    implementation(libs.kotlinx.serialization.json)

// Retrofit Kotlinx Serialization Converter
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")


// Paging 3 Compose Desteği
    implementation("androidx.paging:paging-compose:3.3.0")

    // --- UNIT TEST KÜTÜPHANELERİ ---

    // 1. JUnit (Testleri çalıştırmak için temel motor)
    testImplementation("junit:junit:4.13.2")

    // 2. Coroutines Test (Suspend fonksiyonları test edebilmek için)
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")

    // 3. Google Truth (assertThat gibi okunaklı doğrulama kodları için)
    testImplementation("com.google.truth:truth:1.1.5")
    implementation(kotlin("test"))
    // Flow testleri için Turbine (
    testImplementation("app.cash.turbine:turbine:1.1.0")

    // Paging 3 verilerini test etmek için
    testImplementation("androidx.paging:paging-testing:3.3.0")
}


kapt {
    correctErrorTypes = true

}