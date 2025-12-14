plugins {
    kotlin("jvm") version "2.2.21"
    kotlin("plugin.serialization") version "2.2.21" apply false
    id("org.jetbrains.dokka") version "2.0.0"
    id("com.vanniktech.maven.publish") version "0.35.0"
}
allprojects {
    group = "io.github.colourlessglow"
    version = "0.0.1-SNAPSHOT"
    repositories {
        mavenCentral()
    }
}
subprojects {
    apply(plugin = "kotlin")
    apply(plugin = "org.jetbrains.dokka")
    apply(plugin = "com.vanniktech.maven.publish")
    kotlin {
        jvmToolchain(8)
    }
    dependencies {
        testImplementation(kotlin("test"))
    }
    tasks.test {
        useJUnitPlatform()
    }
    mavenPublishing {
        publishToMavenCentral()
        signAllPublications()
        pom{
            licenses{
                license {
                    name = "MIT License"
                    url = "https://opensource.org/licenses/MIT"
                }
            }
            developers {
                developer {
                    id = "colourlessglow"
                    name = "whitekite"
                    email = "xuxjigsaw@gmail.com"
                }
            }
            scm {
                connection = "scm:git:git://github.com/colourlessglow/zlmediakit-api.git"
                developerConnection = "scm:git:ssh://github.com:colourlessglow/zlmediakit-api.git"
                url = "https://github.com/colourlessglow/zlmediakit-api"
            }
        }
    }
}

dependencies {
    dokka(project(":zlmediakit-client"))
    dokka(project(":zlmediakit-client-core"))
}