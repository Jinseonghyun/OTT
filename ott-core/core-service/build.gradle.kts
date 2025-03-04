dependencies {
    implementation(project(":ott-core:core-usecase"))
    implementation(project(":ott-core:core-port"))
    implementation(project(":ott-core:core-domain"))
    implementation(project(":ott-commons"))

    runtimeOnly(project(":ott-adapters:adapter-http"))
    runtimeOnly(project(":ott-adapters:adapter-persistence"))
    runtimeOnly(project(":ott-adapters:adapter-redis"))

    implementation("org.springframework:spring-context")
    implementation("org.springframework.data:spring-data-commons")

    implementation("io.jsonwebtoken:jjwt-api")
    implementation("io.jsonwebtoken:jjwt-impl")
    implementation("io.jsonwebtoken:jjwt-jackson")
}