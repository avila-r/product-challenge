/**
 * Declaring a property for the main class of the project.
 */
val mainClass: String by project

/**
 * Plugins used in the project:
 * - Spring Boot plugin for building Spring Boot applications.
 * - Dependency management plugin for managing dependencies in Spring Boot projects.
 * - Kotlin plugin for JPA support.
 * - Kotlin JVM plugin for JVM project support.
 * - Kotlin Spring plugin for Spring support in Kotlin projects.
 * - Shadow plugin for creating fat/shadow JARs.
 */
plugins {
    id("org.springframework.boot") version "3.3.1"
    id("io.spring.dependency-management") version "1.1.5"
    kotlin("plugin.jpa") version "1.9.24"
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.spring") version "1.9.24"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "com.avila"
version = "1.0"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

/**
 * Repositories for resolving dependencies:
 * - Maven Central repository for dependency resolution.
 */
repositories {
    mavenCentral()
}

/**
 * Dependencies for the project:
 * - Kotlin Result library for handling results in Kotlin.
 * - Spring Boot starters for data JPA and web support.
 * - Jackson Kotlin module for JSON serialization/deserialization.
 * - Kotlin reflection library.
 * - PostgreSQL JDBC driver for database connectivity.
 * - Springdoc OpenAPI starter for API documentation.
 */
dependencies {
    /*
     * Kotlin-result library for handling results
     */
    implementation("com.michael-bull.kotlin-result:kotlin-result:2.0.0")

    /**
     * Spring Boot starters
     */
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    /**
     * Utils
     */
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    /**
     * PostgreSQL
     */
    runtimeOnly("org.postgresql:postgresql")

    /**
     * Docs
     */
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

/**
 * Config Shadow JAR task
 */
tasks.shadowJar {
    manifest {
        attributes["Main-Class"] = mainClass
    }
}
