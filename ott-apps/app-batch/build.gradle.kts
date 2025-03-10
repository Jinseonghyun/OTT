dependencies {
    implementation(project(":ott-core:core-usecase"))
    implementation(project(":ott-core:core-domain"))
    implementation(project(":ott-commons"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-batch")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework:spring-tx")


    runtimeOnly(project(":ott-core:core-service"))
}