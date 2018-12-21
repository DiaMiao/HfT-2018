## Recommended Links:

- https://start.spring.io/
- https://spring.io/guides/
- https://www.baeldung.com/spring-boot/

- https://hub.docker.com/
- https://labs.play-with-docker.com/

- https://www.cloudfoundry.org/get-started/
- https://kubernetes.io/

## Lecture Samples:

Spring Data:
- https://gitpitch.com/maeddes/gitpitch-spring-data#/

External Config:
- https://gitpitch.com/maeddes/gitpitch-spring-configuration

Spring Communication:
- https://gitpitch.com/maeddes/gitpitch-spring-communication

Shortcuts :)

docker run --name postgresdb -p 5432:5432 -e POSTGRES_PASSWORD=password -e POSTGRES_USER=matthias -e POSTGRES_DB=mydb -d postgres:latest

mvn -f backend spring-boot:run -Dspring.profiles.active=prod -Dserver.port=8090

mvn -f frontend spring-boot:run -Dserver.port=8081 -Dbackend.endpoint=http://localhost:8090
