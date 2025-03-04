# Java Maven Template

This is a minimal template project for Java using Maven. It is configured with

* JUnit 5
* maven-assembly-plugin for bundling dependencies with a JAR
* maven-javadoc-plugin

## Setup

You must have the following installed:

* A Java SDK
* Maven

If you are using VS Code, make sure you have the Java Extension Pack extension installed.

### Structure

Java files are located in `src/main/java`. Within this the folder structure must match the package. The provided files are in the `com.example` package, and therefore are within the `com/example/` folder.

The entry point to the application set within the JAR manifest is `com.example.App`. If you wish the application to start at another entry point, you must update `pom.xml` to replace `com.example.App` with the fully specified class name to use.

## Development

### Build and Run

You can run and debug the program within VS Code from the 'Run and Debug' tab.

Package into a `.jar` using:

    mvn package

The `.jar` can be found in the `target/` folder. If you have added dependencies to your `pom.xml`, you should distribute the version of the `.jar` that contains bundled dependencies, which is called `my-app-1-jar-with-dependencies`.

To run the jar, call Java with the `-jar` option providing the path to the Jar.

    java -jar ./target/my-app-1-jar-with-dependencies.jar

### Create JavaDoc

Create Javadoc using

    mvn javadoc:javadoc

The created documentation website is located in `target/reports/apidocs`.

### Tests

Unit tests are defined in `src/test`. Run tests using 

    mvn test
