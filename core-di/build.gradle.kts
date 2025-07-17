plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    // ksp
    alias(libs.plugins.google.devtools.ksp)
    /// hilt
    alias(libs.plugins.dagger.hilt)
}

android {
    namespace = "com.devtorres.core_di"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
        isCoreLibraryDesugaringEnabled = true
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    // hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)

    // desugar
    coreLibraryDesugaring(libs.desugar.jdk.libs)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}