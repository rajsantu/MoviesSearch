import org.gradle.internal.impldep.bsh.commands.dir

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.mainpackage.moviessearch"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mainpackage.moviessearch"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    //RecyclerView
    implementation(libs.androidx.recyclerview)
    //CardView
    implementation(libs.androidx.cardview)
    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit2.converter.gson)
    // View Model
    implementation(libs.androidx.lifecycle.viewmodel)
    // LiveData
    implementation(libs.androidx.lifecycle.livedata)

    // GLide
    implementation(libs.glide)
    annotationProcessor(libs.compiler)

    // Material Design
    implementation(libs.material.v130alpha03)



}