Eureka-server
=============

## Hosts configuration
In order to run 2 eureka-server on the same machine, you need to change your hosts file
### Linux
in /etc/hosts
    127.0.0.1   localhost peer1 peer2

## Build
    mvn clean package docker:build

## Docker configuration
### Create User-defined Network
    docker network create --driver=bridge eureka_nw

### Run eureka-server peer1 instance
    docker run --hostname="peer1" --net=eureka_nw --name=peer1 -e "SPRING_PROFILES_ACTIVE=peer1" -p 8761:8761 -t jgauthier/eureka-server

### Run eureka-server peer2 instance
    docker run --hostname="peer2" --net=eureka_nw --name=peer2 -e "SPRING_PROFILES_ACTIVE=peer2" -p 8762:8762 -t jgauthier/eureka-server