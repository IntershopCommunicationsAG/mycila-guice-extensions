/*
 * Copyright 2022 Intershop Communications AG.
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
    id("com.gradle.enterprise").version("3.0")
}

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
    }
}

rootProject.name = "mycila-guice-extensions"

include(":mycila-guice-jsr250")
include(":mycila-guice-injection")
include(":mycila-guice-closeable")
project(":mycila-guice-jsr250").projectDir = file("jsr250")
project(":mycila-guice-injection").projectDir = file("injection")
project(":mycila-guice-closeable").projectDir = file("closeable")