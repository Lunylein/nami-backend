import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	val kotlinVersion = "1.3.72"
	id("org.springframework.boot") version "2.3.1.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	kotlin("jvm") version kotlinVersion
	kotlin("plugin.jpa") version kotlinVersion
	kotlin("plugin.spring") version kotlinVersion
	id("org.liquibase.gradle") version "2.0.4"
}

val kotlinVersion:String by project
val gitVersion: String? = "git rev-list HEAD --count".runCommand(file("$rootDir"))

group = "com.nami"
version = "0.1-$gitVersion"
java.sourceCompatibility = JavaVersion.VERSION_11

logger.lifecycle("Versions: project <$version>, java <${System.getProperty("java.version")}>, " +
		"kotlin <$kotlinVersion>, " +
		"gradle <${project.gradle.gradleVersion}>, groovy <${groovy.lang.GroovySystem.getVersion()}>")

repositories {
	mavenCentral()
	jcenter()
	maven("https://dl.bintray.com/kotlin/kotlin-eap")
}

dependencies {
	// Spring Boot Core
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa") {
		exclude(group = "org.apache.tomcat", module = "tomcat-jdbc")
	}
	implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	// Database
	runtimeOnly("org.postgresql:postgresql")
	implementation("com.zaxxer:HikariCP:2.5.1") {
		exclude(group = "org.hibernate", module = "hibernate-core")
	}
	implementation("org.hibernate:hibernate-hikaricp:5.2.11.Final") {
		exclude(group = "com.zaxxer", module = "HikariCP")
		exclude(group = "org.hibernate", module = "hibernate-core")
	}
	implementation("org.liquibase:liquibase-core:3.10.0")
	liquibaseRuntime("org.liquibase:liquibase-core")
	liquibaseRuntime("org.liquibase.ext:liquibase-hibernate5:3.8")
	liquibaseRuntime("org.postgresql:postgresql")
	liquibaseRuntime("org.springframework.boot:spring-boot:$2.3.1.RELEASE")

	// Testing Core
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
		exclude(group = "junit", module = "junit")
	}
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