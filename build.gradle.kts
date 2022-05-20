/*
 * Copyright 2021 Intershop Communications AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
plugins {
    java
    `maven-publish`
    // ide plugin
    idea
    // artifact signing - necessary on Maven Central
    signing
}

group = "com.intershop.mycila-guice"
version = "5.1.0-jakarta"
description = "Google Guice - Extensions - Servlet"

val sonatypeUsername: String? by project
val sonatypePassword: String? by project

subprojects {
    group = "com.intershop.mycila-guice"
    version = "5.1.0-jakarta"
    description = "Mycila Guice - Extensions"

    apply(plugin = "java")
    apply(plugin = "maven-publish")
    apply(plugin = "signing")

    java {
        sourceCompatibility = JavaVersion.VERSION_1_8

        withSourcesJar()
        withJavadocJar()
    }

    publishing {
        publications {
            create("intershopMvn", MavenPublication::class.java) {
                from(components["java"])
                pom {
                    name.set(project.name)
                    description.set(project.description)
                    url.set("https://github.com/IntershopCommunicationsAG/${project.name}")
                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                            distribution.set("repo")
                        }
                    }
                    organization {
                        name.set("Intershop Communications AG")
                        url.set("http://intershop.com")
                    }
                    developers {
                        developer {
                            id.set("m-raab")
                            name.set("M. Raab")
                            email.set("mraab@intershop.de")
                            id.set("lead")
                            name.set("S. Saller")
                            email.set("ssaller@intershop.de")
                        }
                    }
                    scm {
                        connection.set("git@github.com:IntershopCommunicationsAG/${project.name}.git")
                        developerConnection.set("git@github.com:IntershopCommunicationsAG/${project.name}.git")
                        url.set("https://github.com/IntershopCommunicationsAG/${project.name}")
                    }
                }
            }
        }
        repositories {

            maven {
                val releasesRepoUrl = "https://oss.sonatype.org/service/local/staging/deploy/maven2"
                val snapshotsRepoUrl = "https://oss.sonatype.org/content/repositories/snapshots"
                url = uri(if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl)
                credentials {
                    username = sonatypeUsername
                    password = sonatypePassword
                }
            }
        }
    }

    signing {
        sign(publishing.publications["intershopMvn"])
    }

    repositories {
        mavenCentral()
    }
}