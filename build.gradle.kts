import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.3.0.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"
	kotlin("plugin.noarg") version "1.3.72"
}
apply{
	plugin("kotlin")
	plugin("kotlin-spring")
	plugin("kotlin-jpa")
	plugin("kotlin-noarg")
}
val gitVersion: String? = "git rev-list HEAD --count".runCommand(file("$rootDir"))

group = "com.nami"
version = "0.1-$gitVersion"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
	jcenter()
	maven("https://dl.bintray.com/kotlin/kotlin-eap")
}
buildscript {
	dependencies {
		classpath(kotlin("gradle-plugin", "1.3.72"))
		classpath(kotlin("allopen", "1.3.72"))
		classpath(kotlin("noarg", "1.3.72"))
		classpath("org.jetbrains.kotlin.jvm:org.jetbrains.kotlin.jvm.gradle.plugin:1.3.72")
	}
}
allOpen {
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.MappedSuperclass")
	annotation("javax.persistence.Embeddable")
}
dependencies {
	//implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
	//implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")

	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("com.squareup.retrofit2:retrofit:2.3.0")
	implementation("com.squareup.retrofit2:adapter-rxjava2:2.3.0")
	implementation("com.squareup.retrofit2:converter-gson:2.3.0")
	implementation("io.reactivex.rxjava2:rxandroid:2.0.1")
	implementation("com.zaxxer:HikariCP:3.4.5")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
	//testImplementation("org.springframework.security:spring-security-test")
}
tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

// ******
// Utility methods
// ******
fun String.runCommand(workingDir: File): String? {
	return try {
		val parts = this.split("\\s".toRegex())
		val proc = ProcessBuilder(*parts.toTypedArray())
				.directory(workingDir)
				.redirectOutput(ProcessBuilder.Redirect.PIPE)
				.redirectError(ProcessBuilder.Redirect.PIPE)
				.start()

		proc.waitFor(1, TimeUnit.SECONDS)
		proc.inputStream.bufferedReader().readLine().trim()
	} catch(e: java.io.IOException) {
		e.printStackTrace()
		null
	}
}