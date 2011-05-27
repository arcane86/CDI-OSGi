#!/bin/sh
#

clear;
#export DEBUG_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,address=8000"
#mvn clean install;
cd ./cdi-osgi-sample/container/target/container-0.2-all/container-0.2/;
java $DEBUG_OPTS -jar bin/felix.jar;
