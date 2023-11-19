val compose_version = "1.5.1"
val nav_version = "2.7.3"
val target_sdk = 34
val package_name = "com.example.android_graphql"

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
    id("com.apollographql.apollo3").version("3.7.3")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}


apollo {
    service("service") {
        packageName.set(package_name)
    }
}
android {
    namespace = package_name
    compileSdk = target_sdk

    defaultConfig {
        applicationId = package_name
        minSdk = 24
        targetSdk = target_sdk
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String","BASE_URL","\"https://rickandmortyapi.com/graphql\"")
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
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
        buildConfig=true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = compose_version
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.2"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("androidx.fragment:fragment-ktx:1.6.1")

    //Compose
//    implementation(platform("androidx.compose:compose-bom:2023.10.01"))
//    implementation("androidx.compose.material:material")
//    implementation("androidx.compose.ui:ui-tooling-preview")
//    implementation("androidx.compose.runtime:runtime")
//    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
//    androidTestImplementation( "androidx.compose.ui:ui-tooling")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //Navigation Component
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")

    //GraphQL
    implementation("com.apollographql.apollo3:apollo-runtime:3.7.3")

    //coil
    implementation("io.coil-kt:coil-compose:2.4.0")

   // kapt ("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.4.2")

    //Hilt
    implementation("com.google.dagger:hilt-android:2.48.1")
    kapt("com.google.dagger:hilt-android-compiler:2.48.1")
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    implementation("androidx.hilt:hilt-navigation-fragment:1.0.0")




}

kapt {
    correctErrorTypes = true
}
