import net.ltgt.gradle.errorprone.CheckSeverity
import net.ltgt.gradle.errorprone.errorprone

val codeCoverageThreshold = "0.01".toBigDecimal()

plugins {
	java
	id("org.springframework.boot") version "3.5.3"
	id("io.spring.dependency-management") version "1.1.7"

	// Code Coverage
	jacoco

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
	errorprone("com.uber.nullaway:nullaway:0.11.0")
}

// Code Coverage
tasks.test {
	finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
	dependsOn(tasks.test)
}

tasks.jacocoTestCoverageVerification {
	violationRules {
		rule {
			limit {
				minimum = codeCoverageThreshold
			}
		}
	}
}

tasks.named("check") {
	dependsOn (tasks.jacocoTestCoverageVerification)
}

// Code Formatter
configure<com.diffplug.gradle.spotless.SpotlessExtension> {
	java {
		importOrder()
		removeUnusedImports()
		palantirJavaFormat("2.50.0").formatJavadoc(true)
		formatAnnotations()
	}
}

// Static Code Analyzer
tasks.withType<JavaCompile>().configureEach {
	options.errorprone.disableWarningsInGeneratedCode.set(true)
	options.errorprone {
		check("NullAway", CheckSeverity.ERROR)
		option("NullAway:AnnotatedPackages", "com.fbm.lazhcsilva")
	}
	finalizedBy(tasks.spotlessApply)
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
