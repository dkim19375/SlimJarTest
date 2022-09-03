@file:Suppress("SpellCheckingInspection", "PropertyName")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.cadixdev.licenser") version "0.6.1"
    id("org.jetbrains.kotlin.jvm") version "1.7.10"
    id("com.github.johnrengelman.shadow") version "7.1.2"

    id("io.github.slimjar") version "1.3.0"
}

val KT_VER = "1.7.10"
val ADVENTURE_VER = "4.9.3"

group = "me.dkim19375"
version = "1.0.0"

val shadowJar = tasks.shadowJar.get()

val basePackage = "me.dkim19375.${project.name.toLowerCase()}.libs"
val fileName = shadowJar.archiveFileName.get()

tasks.withType<JavaCompile> {
    sourceCompatibility = "16"
    targetCompatibility = "16"
    options.encoding = "UTF-8"
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "16"
    }
}

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://jitpack.io/")
    maven("https://m2.dv8tion.net/releases")
    maven("https://repo.maven.apache.org/maven2/")
    maven("https://repo.triumphteam.dev/snapshots/")
    maven("https://repo.viaversion.com/everything/")
    maven("https://repo.dmulloy2.net/repository/public/")
    maven("https://nexus.scarsz.me/content/groups/public/")
    maven("https://repo.codemc.org/repository/maven-public/")
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://repo.dmulloy2.net/nexus/repository/public/")
    maven("https://ci.ender.zone/plugin/repository/everything/")
    maven("https://oss.sonatype.org/content/repositories/central")
    maven("https://nexus.umbcraft.online/repository/umbcraft-pub/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
    maven("https://nexus.velocitypowered.com/repository/maven-public/")
    maven("https://s01.oss.sonatype.org/content/repositories/releases/")
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven("https://papermc.io/repo/service/rest/repository/browse/maven-public/")
    maven("https://raw.githubusercontent.com/TeamVK/maven-repository/master/release/")

    maven("https://repo.essentialsx.net/releases/")
    maven("https://repo.essentialsx.net/snapshots/")
}

dependencies {
    implementation("io.github.slimjar:slimjar:1.2.6")

    compileOnly("org.jetbrains.kotlin:kotlin-stdlib:$KT_VER") {
        exclude(module = "annotations")
        exclude(group = "org.jetbrains.kotlin")
    }

    compileOnly("com.destroystokyo.paper:paper-api:1.16.4-R0.1-SNAPSHOT")
    
    implementation("me.mattstudios:triumph-config:1.0.5-SNAPSHOT")
    compileOnly("io.github.dkim19375:dkim-bukkit-core:3.3.43") {
        exclude(group = "org.jetbrains.kotlin")
        exclude(group = "org.jetbrains.kotlinx")
    }
    
    compileOnly("net.luckperms:api:5.4")
    compileOnly("me.clip:placeholderapi:2.11.2")
    compileOnly("com.gitlab.ruany:LiteBansAPI:0.3.5")
    compileOnly("com.github.NEZNAMY.TAB:tab-api:3.1.4") {
        exclude(module = "yamlassist")
    }
    compileOnly("com.comphenix.protocol:ProtocolLib:5.0.0-SNAPSHOT")
    
    compileOnly("net.essentialsx:EssentialsX:2.19.7") {
        exclude(group = "org.spigotmc")
        exclude(group = "org.bukkit")
        exclude(group = "org.bstats")
        exclude(group = "net.md5")
    }

    slim("org.jsoup:jsoup:1.15.3")
    // slim("net.dv8tion:JDA:5.0.0-alpha.13")
    slim("com.github.dkim19375:JDA:6713255963")
    slim("net.time4j:time4j-base:5.9.1")
    slim("net.kyori:adventure-api:4.11.0")
    slim("net.time4j:time4j-tzdata:5.0-2022c")
    slim("com.squareup.okhttp3:okhttp:4.10.0")
    slim("club.minnced:discord-webhooks:0.8.2")
    slim("com.github.PiggyPiglet:TimeAPI:1675a8771e")
    slim("net.kyori:adventure-platform-bukkit:4.1.2")
    slim("org.jetbrains.kotlin:kotlin-reflect:1.7.10")
    slim("org.jetbrains.kotlin:kotlin-main-kts:1.7.10")
    slim("com.googlecode.json-simple:json-simple:1.1.1")
    slim("io.github.dkim19375:item-move-detection-lib:1.1.8")
    slim("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    slim("com.github.minndevelopment:jda-ktx:0.9.4-alpha.18")
    slim("org.jetbrains.kotlin:kotlin-scripting-jsr223:1.7.10")

    slim("dev.triumphteam:triumph-gui:3.1.2")
    slim("io.github.dkim19375:dkim19375jdautils:2.10.3")

    slim("net.kyori:adventure-extra-kotlin:4.11.0")
    slim("net.kyori:adventure-text-minimessage:4.11.0")
    slim("net.kyori:adventure-platform-bungeecord:4.1.2")
    slim("net.kyori:adventure-text-serializer-plain:4.11.0")
}

val relocations = setOf(
    "okio",
    "junit",
    // "kotlin",
    "groovy",
    "mozilla",
    "natives",
    "reactor",
    "kotlinx",
    "okhttp3",
    "org.json",
    "de.tr7zw",
    "javaslang",
    "org.jsoup",
    "org.slf4j",
    "javassist",
    "net.kyori",
    "gnu.trove",
    "org.junit",
    "javassist",
    "com.iwebpp",
    "net.time4j",
    "com.sun.jna",
    "kong.unirest",
    "javax.inject",
    "org.hamcrest",
    "org.objectweb",
    "sh.okx.timeapi",
    "me.mattstudios",
    // "com.google.gson",
    "org.apache.http",
    "groovyjarjarasm",
    "net.dv8tion.jda",
    "dev.minn.jda.ktx",
    "javax.annotation",
    // "io.github.slimjar",
    "club.minnced.opus",
    "groovyjarjarantlr",
    "org.jetbrains.jps",
    "org.yaml.snakeyaml",
    "tomp2p.opuswrapper",
    "groovyjarjarantlr4",
    "org.codehaus.groovy",
    "org.openjdk.nashorn",
    "dev.triumphteam.gui",
    "org.apache.commmons",
    "groovyjarjarpicocli",
    "org.reactivestreams",
    "org.jetbrains.kotlin",
    "com.fasterxml.jackson",
    "me.dkim19375.dkimcore",
    "com.neovisionaries.ws",
    "org.apache.commons.codec",
    "org.jetbrains.annotations",
    "net.kyori.adventure.extra",
    "online.umbcraft.libraries",
    "org.jetbrains.concurrency",
    "me.dkim19375.dkimbukkitcore",
    "club.minnced.discord.webhook",
    "net.kyori.adventure.platform",
    "org.intellij.lang.annotations",
    "me.dkim19375.dkim19375jdautils",
    "org.apache.commons.collections4",
    "org.jetbrains.org.objectweb.asm",
    "me.dkim19375.itemmovedetectionlib",
    "net.kyori.adventure.text.minimessage",
    "net.kyori.adventure.text.serializer.bungeecord",
    "net.kyori.adventure.text.serializer.craftbukkit",
    "net.kyori.adventure.text.serializer.gson.legacyimpl",
)

tasks.shadowJar {
    exclude("DebugProblesKt.bin")
    mergeServiceFiles()
    relocations.forEach { name ->
        relocate(name, "${basePackage}.$name")
    }
}