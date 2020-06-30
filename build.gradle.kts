import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	val kotlinVersion = "1.3.72"
	id("org.springframework.boot") version "2.3.1.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	kotlin("jvm") version kotlinVersion
	kotlin("plugin.jpa") version kotlinVersion
	kotlin("plugin.spring") version kotlinVersion
}

val kotlinVersion = project.property("kotlinVersion")
val gitVersion: String? = "git rev-list HEAD --count".runCommand(file("$rootDir"))

group = "com.nami"
version = "0.1-$gitVersion"
java.sourceCompatibility = JavaVersion.VERSION_11

logger.lifecycle("Versions: project <$version>, java <${System.getProperty("java.version")}>, " +
		"kotlin <${project.property("kotlinVersion")}>, " +
		"gradle <${project.gradle.gradleVersion}>, groovy <${groovy.lang.GroovySystem.getVersion()}>")

repositories {
	mavenCentral()
	jcenter()
	maven("https://dl.bintray.com/kotlin/kotlin-eap")
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