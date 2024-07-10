import net.ltgt.gradle.errorprone.errorprone

plugins {
	java
	id("org.springframework.boot") version "3.3.1"
	id("io.spring.dependency-management") version "1.1.5"

	// Code formatter
	id("com.palantir.git-version") version "3.1.0"
	id("com.diffplug.spotless") version "6.25.0"

	// Static code analyzer
	id("net.ltgt.errorprone") version "4.0.1"
	id("com.github.spotbugs") version "6.0.18"
	pmd
}

group = "com.fbm.lazhcsilva"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")

	runtimeOnly("com.h2database:h2")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	errorprone("com.google.errorprone:error_prone_core:2.28.0")
}

// Code Formatter

configure<com.diffplug.gradle.spotless.SpotlessExtension> {
	java {
		importOrder()
		removeUnusedImports()
		palantirJavaFormat().formatJavadoc(true)
		formatAnnotations()
	}
}

// Static Code Analyzer
tasks.withType<JavaCompile>().configureEach {
	options.errorprone.disableWarningsInGeneratedCode.set(true)
}

pmd {
	isIgnoreFailures = false
}

spotbugs {
	ignoreFailures = false
}

tasks.withType<Test> {
	useJUnitPlatform()
}
