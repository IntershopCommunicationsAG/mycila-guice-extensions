
dependencies {
    implementation("com.google.inject:guice:5.1.0")
    implementation(project(":mycila-guice-injection"))
    implementation(project(":mycila-guice-closeable"))
    implementation("jakarta.annotation:jakarta.annotation-api:2.0.0")
    testImplementation("junit:junit:4.13.1")
}