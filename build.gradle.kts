import org.gradle.api.tasks.testing.logging.TestExceptionFormat

repositories {
    mavenCentral()
}
allprojects {
    tasks.withType(Test::class) {
        testLogging.exceptionFormat = TestExceptionFormat.FULL
    }
    repositories {
        mavenCentral()
    }
}
