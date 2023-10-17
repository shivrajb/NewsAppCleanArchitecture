import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.newsappwithcleanarchitecture"
    compileSdk = 34

    val properties = Properties()
    properties.load(project.rootProject.file("local.properties").inputStream())
    val currentsApi = properties.getProperty("CURRENTS_API_KEY")

    defaultConfig {
        applicationId = "com.example.newsappwithcleanarchitecture"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        resValue ("string", "CURRENTS_API_KEY", "\"$currentsApi\"")
    }

    buildTypes {
        debug {
            buildConfigField ("String", "CURRENTS_API_KEY", "\"ehTUs_L7VNOevxSsW301L3Y6KhOmJ573Grs-VKu--uPjKPZF\"")
            buildConfigField ("String", "NEWS_BASE_URL", "\"https://api.currentsapi.services/v1/\"")
        }
        release {
            buildConfigField ("String", "CURRENTS_API_KEY", "ehTUs_L7VNOevxSsW301L3Y6KhOmJ573Grs-VKu--uPjKPZF")
            buildConfigField ("String", "NEWS_BASE_URL", "\"https://api.currentsapi.services/v1/\"")
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.1.0-alpha10")
    implementation(platform("androidx.compose:compose-bom:2023.05.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.github.bumptech.glide:compose:1.0.0-alpha.1")
    implementation ("com.google.dagger:hilt-android:2.45")
    implementation ("androidx.hilt:hilt-navigation-compose:1.1.0-beta01")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.11")
    kapt("com.google.dagger:hilt-android-compiler:2.45")
    testImplementation ("androidx.arch.core:core-testing:2.2.0")

    implementation (project(":domain"))
    implementation (project(":data"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.2")
    testImplementation("junit:junit:4.13.2")
    testImplementation ("io.mockk:mockk:1.13.5")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}