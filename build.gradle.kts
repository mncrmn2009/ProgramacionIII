plugins {
    id("application")
    id("java")
}



group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Jakarta Persistence API (JPA 3.1)
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")

    // Hibernate (implementación de JPA)
    implementation("org.hibernate.orm:hibernate-core:6.4.4.Final")

    // Base de datos H2 en memoria
    runtimeOnly("com.h2database:h2:2.2.224")

    // Lombok
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")

    // JUnit (opcional)
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
application {
    mainClass.set("Unidad_10.Main")
}

tasks.test {
    useJUnitPlatform()
}