#!/usr/bin bash

#PROFILE=$ENV
#echo $PROFILE
java -server -Xms2048m -Xmx2048m -Xmn1024m -Djava.net.preferIPv4Stack=true -XX:+UseConcMarkSweepGC -XX:+UseCMSCompactAtFullCollection -XX:CMSInitiatingOccupancyFraction=70 -XX:+CMSParallelRemarkEnabled -XX:+CMSClassUnloadingEnabled -XX:SurvivorRatio=8 -XX:+DisableExplicitGC -XX:+PrintGC -XX:+PrintGCDetails -jar /opt/his/super-jacoco.jar

#if [[ "$PROFILE" == "dev" ]];then
#    java -server -Xms2048m -Xmx2048m -Xmn1024m -Djava.net.preferIPv4Stack=true -XX:+UseConcMarkSweepGC -XX:+UseCMSCompactAtFullCollection -XX:CMSInitiatingOccupancyFraction=70 -XX:+CMSParallelRemarkEnabled -XX:+CMSClassUnloadingEnabled -XX:SurvivorRatio=8 -XX:+DisableExplicitGC -XX:+PrintGC -XX:+PrintGCDetails -jar /opt/his/smart-dm-inter-boot-1.0-SNAPSHOT.jar --spring.profiles.active=dev
#elif [[ "$PROFILE" == "test" ]];then
#    java -server -Xms2048m -Xmx2048m -Xmn1024m -Djava.net.preferIPv4Stack=true -XX:+UseConcMarkSweepGC -XX:+UseCMSCompactAtFullCollection -XX:CMSInitiatingOccupancyFraction=70 -XX:+CMSParallelRemarkEnabled -XX:+CMSClassUnloadingEnabled -XX:SurvivorRatio=8 -XX:+DisableExplicitGC -XX:+PrintGC -XX:+PrintGCDetails -jar /opt/his/smart-dm-inter-boot-1.0-SNAPSHOT.jar --spring.profiles.active=test
#elif [[ "$PROFILE" == "beta" ]];then
#    java -server -Xms2048m -Xmx2048m -Xmn1024m -Djava.net.preferIPv4Stack=true -XX:+UseConcMarkSweepGC -XX:+UseCMSCompactAtFullCollection -XX:CMSInitiatingOccupancyFraction=70 -XX:+CMSParallelRemarkEnabled -XX:+CMSClassUnloadingEnabled -XX:SurvivorRatio=8 -XX:+DisableExplicitGC -XX:+PrintGC -XX:+PrintGCDetails -jar /opt/his/smart-dm-inter-boot-1.0-SNAPSHOT.jar --spring.profiles.active=beta
#elif [[ "$PROFILE" == "alpha" ]];then
#    java -server -Xms2048m -Xmx2048m -Xmn1024m -Djava.net.preferIPv4Stack=true -XX:+UseConcMarkSweepGC -XX:+UseCMSCompactAtFullCollection -XX:CMSInitiatingOccupancyFraction=70 -XX:+CMSParallelRemarkEnabled -XX:+CMSClassUnloadingEnabled -XX:SurvivorRatio=8 -XX:+DisableExplicitGC -XX:+PrintGC -XX:+PrintGCDetails -jar /opt/his/smart-dm-inter-boot-1.0-SNAPSHOT.jar --spring.profiles.active=alpha
#elif [[ "$PROFILE" == "prod" ]];then
#    java -server -Xms2048m -Xmx2048m -Xmn1024m -Djava.net.preferIPv4Stack=true -XX:+UseConcMarkSweepGC -XX:+UseCMSCompactAtFullCollection -XX:CMSInitiatingOccupancyFraction=70 -XX:+CMSParallelRemarkEnabled -XX:+CMSClassUnloadingEnabled -XX:SurvivorRatio=8 -XX:+DisableExplicitGC -XX:+PrintGC -XX:+PrintGCDetails -jar /opt/his/smart-dm-inter-boot-1.0-SNAPSHOT.jar --spring.profiles.active=prod
#fi

