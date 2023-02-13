FROM eclipse-temurin:latest
MAINTAINER Mayank Soni<mayank.soni@mayanksoni.tech>
ENV PROFILES_ACTIVE=prod
ENV STACK_DEPLOYMENT_ID=id
ENV MONGO_ACCESS_PW=password
ENV MONGO_ATLAS_PASSWORD=meBXdYhEX6stFZqe
COPY build/libs/service-deployer-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=${PROFILES_ACTIVE}","service-deployer-0.0.1-SNAPSHOT.jar"]