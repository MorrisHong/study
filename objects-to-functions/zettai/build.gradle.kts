val slf4jVersion="2.0.16"

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
    implementation(platform("org.http4k:http4k-bom:5.41.0.0"))
    implementation("org.http4k:http4k-core")
    implementation("org.http4k:http4k-server-jetty")
    implementation("org.slf4j:slf4j-simple:${slf4jVersion}")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}