plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    js {
        browser()
        nodejs()
    }

    sourceSets {
        val jvmTest by getting {
            dependencies {
                api(kotlin("test"))
                api(kotlin("test-annotations-common"))
                api(kotlin("test-junit"))
            }
        }
    }
}
