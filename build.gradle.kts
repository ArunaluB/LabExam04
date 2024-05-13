// Top-level build file where you can add configuration options common to all sub-projects/modules.
<<<<<<< HEAD
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
=======
buildscript {
    repositories {
        google()
    }

    dependencies {
        val navVersion = "2.7.5"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion")
    }
}


plugins {
    id ("com.android.application") version "8.4.0" apply false
    id ("com.android.library") version "8.4.0" apply false
    id ("org.jetbrains.kotlin.android") version "1.7.20" apply false
    id("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false
>>>>>>> da2a4638a9c82c81a6b94a0613994101627ab190
}