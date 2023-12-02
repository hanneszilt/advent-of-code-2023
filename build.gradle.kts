plugins {
    kotlin("jvm") version "1.9.20"
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("io.kotest:kotest-assertions-core-jvm:5.8.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks {
    wrapper {
        gradleVersion = "8.5"
    }
}
