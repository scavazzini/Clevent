plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.protobuf)
    id("kotlin-kapt")
}

android {
    namespace = "dev.scavazzini.clevent.domain.core"
    compileSdk = 34

    defaultConfig {
        minSdk = 23

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    protobuf {
        protoc {
            artifact = libs.protobuf.protoc.get().toString()
        }

        generateProtoTasks {
            all().forEach { task ->
                task.builtins {
                    register("java") {
                        option("lite")
                    }
                }
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    implementation(project(":data:core"))

    // Protobuf
    implementation(libs.protobuf.javalite)

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}
