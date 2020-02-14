# Example Spring Boot project using Spring Config Server

Project containing a basic Spring Boot webapp which configures 
itself using a remote Spring Config server.

The app and the config server run in different docker 
containers to simulate the remote connection.

## Setup
Create a local git repo and place a single file inside 
it containing the required configuration properties.
~~~
$ touch demo-app-1.yml

$ vi demo-app-1.yml
...
welcome-message: Hello from Demo App 1
...

$ git add demo-app-1.yml
$ git commit ...
~~~

Pass the absolute path to the local git repo to 
docker-compose as shown below.

## Running

~~~
$ export CONFIG_GIT_REPO=<path to local git repo with config>
$ ./gradlew clean build
$ docker-compose build
$ docker-compose up
~~~

## Endpoints
- localhost:8888 is the config server.  Use :8888/example-app-1/default to view the config data
- localhost:8080 is the app

## Notes

- The config-server expects a local volume which is a git repo containing config data for the config server to use, hence the environment variable.
- The app depends on the config-server, but because of its relative simplicity it is likely that it will start before the config server is ready.
To mitigate this, the app must be configured with retry enabled.
This is accomplished by setting the fail-fast
config option and including the retry dependencies in the build.gradle.

## References
- https://spring.io/guides/gs/centralized-configuration/
- https://cloud.spring.io/spring-cloud-config/reference/html/