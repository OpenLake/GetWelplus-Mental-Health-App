plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.getwell.feature.auth"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
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
    implementation(project(":core:ui"))

    implementation("androidx.activity:activity-compose:1.9.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.0")
    implementation("androidx.navigation:navigation-compose:2.8.2")

    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-extended:1.6.0-alpha08")

    implementation("com.google.firebase:firebase-auth-ktx:21.1.0")
    implementation("com.google.firebase:firebase-firestore:25.1.0")
    implementation("com.google.firebase:firebase-storage:21.0.1")
    implementation("com.google.android.gms:play-services-auth:20.4.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
}
