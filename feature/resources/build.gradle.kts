plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.getwell.feature.resources"
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
    implementation("androidx.navigation:navigation-compose:2.8.2")

    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-extended")

    implementation("androidx.paging:paging-compose:1.0.0-alpha14")
    implementation("com.google.android.exoplayer:exoplayer:2.18.0")
    implementation("androidx.media3:media3-exoplayer:1.0.0")
    implementation("androidx.media3:media3-ui:1.0.0")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
    implementation("com.squareup.okhttp3:okhttp:4.9.3")
    implementation("com.google.accompanist:accompanist-swiperefresh:0.24.3-alpha")

    implementation("io.coil-kt:coil-compose:2.4.0")
    implementation("org.jsoup:jsoup:1.14.3")
    implementation("com.valentinilk.shimmer:compose-shimmer:1.2.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.7.3")

    implementation("com.google.android.gms:play-services-location:21.0.1")
}
