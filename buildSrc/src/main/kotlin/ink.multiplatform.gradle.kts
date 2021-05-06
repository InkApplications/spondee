plugins {
    kotlin("multiplatform")
}

repositories {
    mavenCentral()
}

kotlin {
    jvm()
    js {
        nodejs()
        browser()
    }
    linuxArm64()
    linuxArm32Hfp()
    linuxMips32()
    linuxX64()
    mingwX64()
    macosX64()

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
