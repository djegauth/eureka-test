eureka-test
===========
Test Netflix Eureka Service Registry

## Required
 - java 8
 - maven 3
 - docker

## Docker configuration
### Create User-defined Network
    docker network create --driver=bridge eureka_nw

### Run eureka-server peer1 instance
    docker run --hostname="peer1" --net=eureka_nw --name=peer1 -e "SPRING_PROFILES_ACTIVE=peer1" -p 8761:8761 -t jgauthier/eureka-server

### Run eureka-server peer2 instance
    docker run --hostname="peer2" --net=eureka_nw --name=peer2 -e "SPRING_PROFILES_ACTIVE=peer2" -p 8762:8762 -t jgauthier/eureka-server