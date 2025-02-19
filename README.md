# Java Maven Template

This is a minimal template project for Java using Maven. It is configured with

* JUnit 5
* maven-assembly-plugin for bundling dependencies with a JAR

## Setup

You must have the following installed:

* A Java SDK
* Maven

If you are using VS Code, make sure you have the Java Extension Pack extension installed.

## Development

You can run and debug the program within VS Code from the 'Run and Debug' tab.

Package into a `.jar` using:

    mvn package

The `.jar` can be found in the `target/` folder. If you have added dependencies to your `pom.xml`, you should distribute the version of the `.jar` that contains bundled dependencies, which is called `my-app-1-jar-with-dependencies`.
