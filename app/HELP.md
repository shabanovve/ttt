# Getting Started

## Spring Native

This project has been configured to let you generate either a lightweight container or a native executable.


### Executable with Native Build Tools
Use this option if you want to explore more options such as running your tests in a native image.
The GraalVM native-image compiler should be installed and configured on your machine, see [the Getting Started section of the reference guide](https://docs.spring.io/spring-native/docs/0.12.1/reference/htmlsingle/#getting-started-native-build-tools).

### To create the executable, run the following goal:

```
$ ./mvnw package -Pnative -DskipTests
```

Then, you can run the app as follows:
```
$ target/cliapp
```
--------------
### Workflow to build native executable file
- Build TDLib (telegram api library)
- Pack .so file into jar
```
    cd td/tdlib
    jar cMf tdlib.jar -C bin .
```
- Push jar into maven local repository
  (run inside cliapp directory)
```
./mvnw install:install-file \
   -Dfile=telegram.api/td/tdlib/tdlib.jar \
   -DgroupId=tdlib  \
   -DartifactId=tdlib \
   -Dversion=0.0.1-SNAPSHOT \
   -Dpackaging=jar \ 
   -DgeneratePom=true
```
