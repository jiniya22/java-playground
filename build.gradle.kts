plugins {
    id("org.springframework.boot") version("2.6.5") apply false
	id("io.spring.dependency-management") version("1.0.11.RELEASE")
	id("java")
}

java.sourceCompatibility = JavaVersion.VERSION_17

val developmentOnly: Configuration by configurations.creating
configurations {
    runtimeClasspath {
        extendsFrom(developmentOnly)
        extendsFrom(configurations.annotationProcessor.get())
    }
}

allprojects {
    group = "xyz.applebox"
    version = "1.0.5"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    dependencies {
        implementation("com.google.code.gson:gson:2.9.0")
        implementation("org.jetbrains:annotations:23.0.0")
        implementation("org.projectlombok:lombok")
        annotationProcessor("org.projectlombok:lombok")
        testImplementation("org.projectlombok:lombok")
        testAnnotationProcessor("org.projectlombok:lombok")
        implementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        implementation("org.springframework.boot:spring-boot-devtools")
        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    }

    dependencyManagement {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

