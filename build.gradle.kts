import org.gradle.api.tasks.testing.logging.TestExceptionFormat

buildscript {
    repositories {
        mavenCentral()
    }
}

subprojects {
    tasks.withType(Test::class) {
        testLogging.exceptionFormat = TestExceptionFormat.FULL
    }
    repositories {
        mavenCentral()
    }
}

tasks.create("zipPublications", Zip::class) {
    from("math/build/repo/")
    from("measures/build/repo/")
    archiveFileName.set("publications.zip")
}
