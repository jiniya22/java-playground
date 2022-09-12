import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.5"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
}

group = "xyz.applebox"
version = "1.0.5"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("org.jetbrains:annotations:23.0.0")
    implementation("org.projectlombok:lombok")
    implementation("org.springframework.security:spring-security-core:5.7.2")
    implementation("com.auth0:java-jwt:3.19.2")
    implementation("io.jsonwebtoken:jjwt:0.9.1")

    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.projectlombok:lombok")
    testAnnotationProcessor("org.projectlombok:lombok")

    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}