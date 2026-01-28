plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.getwell.core.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":core:common"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.6")

    api("com.google.firebase:firebase-firestore:25.1.0")
    implementation("com.google.firebase:firebase-auth-ktx:21.1.0")
    implementation("com.google.firebase:firebase-storage:21.0.1")
    implementation("com.google.firebase:firebase-storage-ktx:21.0.1")
}
