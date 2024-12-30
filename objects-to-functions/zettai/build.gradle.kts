plugins {
    kotlin("jvm")
}

group = "kr.gracelove"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    testImplementation(kotlin("test"))

    // https://mvnrepository.com/artifact/org.http4k/http4k-core
    implementation("org.http4k:http4k-core:${project.property("http4Version")}")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}