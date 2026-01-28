plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.getwell.feature.stress"
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
    implementation(project(":core:data"))
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

    implementation("androidx.camera:camera-camera2:1.3.1")
    implementation("androidx.camera:camera-lifecycle:1.3.1")
    implementation("androidx.camera:camera-view:1.3.1")
    implementation("com.google.mlkit:face-detection:16.1.5")
    implementation("org.tensorflow:tensorflow-lite-support:0.3.0")
    implementation("org.tensorflow:tensorflow-lite-metadata:0.3.0")
    implementation("com.google.ai.client.generativeai:generativeai:0.1.1")
    implementation("com.google.android.gms:play-services-mlkit-text-recognition:19.0.0")

    implementation("androidx.work:work-runtime-ktx:2.8.1")

    implementation("com.google.firebase:firebase-firestore:25.1.0")
    implementation("com.google.firebase:firebase-auth-ktx:21.1.0")
}
