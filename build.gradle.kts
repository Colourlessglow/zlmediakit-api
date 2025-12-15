plugins {
    kotlin("jvm") version "2.2.21"
    kotlin("plugin.serialization") version "2.2.21" apply false
    id("org.jetbrains.dokka") version "2.0.0"
    id("com.vanniktech.maven.publish") version "0.35.0"
}
allprojects {
    group = "io.github.colourlessglow"
    version = "0.0.9"
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
        coordinates(group.toString(), project.name, version.toString())
        pom {
            // 添加项目基本信息
            name.set("zlmediakit-api-${project.name}") // 使用项目名称作为后缀
            description.set("ZLMediaKit API Client for ${project.name}")
            url.set("https://github.com/colourlessglow/zlmediakit-api")
            licenses {
                license {
                    name.set("MIT License")
                    url.set("https://opensource.org/licenses/MIT")
                }
            }
            developers {
                developer {
                    id.set("colourlessglow")
                    name.set("whitekite")
                    email.set("xuxjigsaw@gmail.com")
                    organization.set("colourlessglow")
                    organizationUrl.set("https://github.com/Colourlessglow")
                }
            }
            scm {
                connection.set("scm:git:git://github.com/colourlessglow/zlmediakit-api.git")
                developerConnection.set("scm:git:ssh://github.com:colourlessglow/zlmediakit-api.git")
                url.set("https://github.com/colourlessglow/zlmediakit-api")
            }
        }
    }
}

dependencies {
    dokka(project(":zlmediakit-client"))
    dokka(project(":zlmediakit-client-core"))
}
