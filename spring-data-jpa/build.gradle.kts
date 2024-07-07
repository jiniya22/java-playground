dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.11.0-M2")
    runtimeOnly("mysql:mysql-connector-java")
}
