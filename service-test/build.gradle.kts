plugins {
    id ("groovy")
}

group = "${project.group}.service-test"
version = project.version

repositories {
    mavenCentral()
}

dependencies {
    implementation( "org.codehaus.groovy:groovy:3.0.4")
    implementation("com.squareup.okhttp3:okhttp:4.7.2")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation( "org.spockframework:spock-core:2.0-M2-groovy-3.0")
    testImplementation("com.nami.backend:service:$version")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-test:2.3.1.RELEASE")
}
