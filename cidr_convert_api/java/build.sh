#!/bin/bash

set -ex


cd cidr_convert_api || exit 1
cd java
cd cidr-api
pwd
ls
mvn package
#java -cp target/cidr-api-1.0-SNAPSHOT-jar-with-dependencies.jar com.dott.App
