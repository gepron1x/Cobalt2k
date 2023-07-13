plugins {
    `java-library`
    `maven-publish`
    id("xyz.jpenilla.toothpick")
}

toothpick {
    forkName = "Cobalt"
    groupId = "ru.decalium.cobalt"
    forkUrl = "https://github.com/decalium/Cobalt2k"
    val versionTag = System.getenv("BUILD_NUMBER")
            ?: "\"${commitHash() ?: error("Could not obtain git hash")}\""
    forkVersion = "git-$forkName-$versionTag"

    minecraftVersion = "1.16.5"
    nmsPackage = "1_16_R3"
    nmsRevision = "R0.1-SNAPSHOT"

    upstream = "Paper"
    upstreamBranch = "origin/master"

    server {
        project = projects.cobaltServer.dependencyProject
        patchesDir = rootProject.projectDir.resolve("patches/server")
    }
    api {
        project = projects.cobaltApi.dependencyProject
        patchesDir = rootProject.projectDir.resolve("patches/api")
    }
}

subprojects {
    repositories {
        maven("https://nexus.velocitypowered.com/repository/velocity-artifacts-snapshots/")
        maven("https://oss.sonatype.org/content/repositories/snapshots/") {
            name = "sonatype-oss-snapshots"
        }
    }

    java {
        sourceCompatibility = JavaVersion.toVersion(17)
        targetCompatibility = JavaVersion.toVersion(17)
    }

    publishing.repositories.maven {
        url = uri("https://repo.pl3x.net/snapshots")
        credentials(PasswordCredentials::class)
    }
}