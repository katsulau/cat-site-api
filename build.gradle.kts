import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.1"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.spring") version "1.9.21"
}

group = "com.site.cat"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-webflux:3.2.1")
    implementation("io.projectreactor:reactor-core:3.6.1")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    // r2dbc driver
    implementation("org.postgresql:r2dbc-postgresql:1.0.3.RELEASE")

    // spring starter dataがないとliquibaseのmigration実行がされない。多分何かの依存しているものが必要とされるもの
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc:3.2.1")
//    implementation("org.springframework.boot:spring-boot-starter-data-jdbc:3.2.1")

    // jdbc postgresql driver
    // this is required because liquibase does not support r2dbc driver
    implementation("org.postgresql:postgresql:42.7.1")

    // migration tool
    implementation("org.liquibase:liquibase-core:4.25.1")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
