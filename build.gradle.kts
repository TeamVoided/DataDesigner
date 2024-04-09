@file:Suppress("PropertyName")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.fabric.loom)
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.iridium)
}

group = property("maven_group")!!
version = property("mod_version")!!
base.archivesName.set(property("archives_base_name") as String)
description = property("description") as String

val modid: String by project
val mod_name: String by project

repositories {
    mavenCentral()
//    maven("https://teamvoided.org/releases")
}

modSettings {
    modId(modid)
    modName(mod_name)

    entrypoint("main", "org.teamvoided.template.Template::commonInit")
    entrypoint("client", "org.teamvoided.template.Template::clientInit")
    entrypoint("fabric-datagen", "org.teamvoided.template.TemplateData")
    mixinFile("template.mixins.json")

//    accessWidener("template.accesswidener")
}

dependencies {
    modImplementation(fileTree("libs"))

//    modImplementation(libs.reef)
}

loom {
    runs {
        create("DataGen") {
            client()
            ideConfigGenerated(true)
            vmArg("-Dfabric-api.datagen")
            vmArg("-Dfabric-api.datagen.output-dir=${file("src/main/generated")}")
            vmArg("-Dfabric-api.datagen.modid=${modid}")
            runDir("build/datagen")
        }

        create("TestWorld") {
            client()
            ideConfigGenerated(true)
            runDir("run")
            programArgs("--quickPlaySingleplayer", "test")
        }
    }
}

sourceSets["main"].resources.srcDir("src/main/generated")

tasks {
    val targetJavaVersion = 17
    withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.release.set(targetJavaVersion)
    }

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = targetJavaVersion.toString()
    }

    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(JavaVersion.toVersion(targetJavaVersion).toString()))
        withSourcesJar()
    }
}