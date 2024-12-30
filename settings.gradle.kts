plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "study"
include("book-data-structures-the-fun-way")
include("book-seriously-good-software")
include("discovery")
include("objects-to-functions")
include("objects-to-functions:zettai")
findProject(":objects-to-functions:zettai")?.name = "zettai"
