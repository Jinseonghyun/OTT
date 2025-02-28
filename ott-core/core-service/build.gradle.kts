dependencies {
    implementation(project(":ott-core:core-usecase"))
    implementation(project(":ott-core:core-port"))

    runtimeOnly(project(":ott-adapters:adapter-http"))
    runtimeOnly(project(":ott-adapters:adapter-persistence"))

    implementation("org.springframework:spring-context")
}