import org.gradle.api.tasks.testing.logging.TestExceptionFormat

subprojects {
    tasks.withType(Test::class) {
        testLogging.exceptionFormat = TestExceptionFormat.FULL
    }
}

tasks.create("zipPublications", Zip::class) {
    from("math/build/repo/")
    from("measures/build/repo/")
    archiveFileName.set("publications.zip")
}
