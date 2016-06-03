#!/usr/bin/env bash
entier=1
while true
do
    sleep 1
    echo "${entier}"
    curl http://localhost:8080/breaker?fallback=false
    (( entier++ ))
    if ((entier%10 == 0 )); then
        curl http://localhost:8080/breaker?fallback=true
    fi
done