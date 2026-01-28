plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("org.jetbrains.kotlin.kapt")
}

import java.util.Properties

val localProperties = Properties().apply {
    val file = rootProject.file("local.properties")
    if (file.exists()) {
        file.inputStream().use { load(it) }
    }
}

fun localProperty(key: String): String = localProperties.getProperty(key) ?: ""

android {
    namespace = "com.example.getwell.feature.chatbot"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        buildConfigField("String", "GEMINI_API_KEY", "\"${localProperty("GEMINI_API_KEY")}\"")
    }

    buildFeatures {
        compose = true
        buildConfig = true
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
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.0")

    implementation("io.getstream:stream-chat-android-compose:6.4.3")
    implementation("io.getstream:stream-chat-android-offline:6.4.3")
    implementation("com.google.firebase:firebase-auth-ktx:21.1.0")
    implementation("com.google.firebase:firebase-firestore:25.1.0")
    implementation("com.google.ai.client.generativeai:generativeai:0.1.1")

    implementation("com.google.dagger:hilt-android:2.50")
    kapt("com.google.dagger:hilt-android-compiler:2.50")
    kapt("androidx.hilt:hilt-compiler:1.1.0")
}
