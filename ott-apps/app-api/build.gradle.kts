dependencies {
    implementation(project(":ott-core:core-usecase"))

    runtimeOnly(project(":ott-core:core-service"))

    implementation("org.springframework.boot:spring-boot-starter-web")

}