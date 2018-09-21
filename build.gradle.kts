import org.gradle.api.tasks.wrapper.Wrapper.DistributionType.ALL

plugins {
    id("org.gradle.java")
}

repositories {
    mavenCentral()
}

dependencies {
    compile("com.fasterxml.jackson.core:jackson-databind:2.9.7")

    testCompile("commons-io:commons-io:2.6")
    testCompile("junit:junit:4.12")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    withType<Wrapper> {
        distributionType = ALL
        gradleVersion = "4.10.2"
    }
}
