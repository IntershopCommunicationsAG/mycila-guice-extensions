/*
 * This file was generated by the Gradle 'init' task.
 *
 * The settings file is used to specify which projects to include in your build.
 *
 * Detailed information about configuring a multi-project build in Gradle can be found
 * in the user manual at https://docs.gradle.org/7.4.2/userguide/multi_project_builds.html
 * This project uses @Incubating APIs which are subject to change.
 */

rootProject.name = "mycila-guice"

include(":mycila-guice-jsr250")
include(":mycila-guice-injection")
include(":mycila-guice-closeable")
project(":mycila-guice-jsr250").projectDir = file("jsr250")
project(":mycila-guice-injection").projectDir = file("injection")
project(":mycila-guice-closeable").projectDir = file("closeable")