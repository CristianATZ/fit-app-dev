plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    // ksp
    alias(libs.plugins.google.devtools.ksp)
    /// hilt
    alias(libs.plugins.dagger.hilt)
}

// Excluir globalmente el JAR conflictivo de IntelliJ
configurations.all {
    exclude(group = "com.intellij", module = "annotations")
}

android {
    namespace = "com.devtorres.fit_app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.devtorres.fit_app"
        minSdk = 26
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
        isCoreLibraryDesugaringEnabled = true

    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    /*En caso de que se requiera instalar en la computadora
    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }*/
}

dependencies {
    implementation(project(":feature-splash"))
    implementation(project(":feature-home"))
    implementation(project(":core-designsystem"))


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // splash screen
    implementation(libs.androidx.core.splashscreen)

    // hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)

    // navigation
    implementation(libs.androidx.navigation.compose)

    // desugar
    coreLibraryDesugaring(libs.desugar.jdk.libs)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}