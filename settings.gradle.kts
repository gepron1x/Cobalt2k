import xyz.jpenilla.toothpick.setupToothpickProject
import java.util.Locale

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://repo.jpenilla.xyz/snapshots")
    }
}

plugins {
    id("xyz.jpenilla.toothpick.settings") version "1.1.0-SNAPSHOT"
}

val forkName = "Cobalt"
rootProject.name = "Cobalt2k"
setupToothpickProject(rootProject, forkName)