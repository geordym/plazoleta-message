FROM eclipse-temurin:17.0.12_7-jre

WORKDIR /root

# Copia el JAR ya construido desde tu máquina local
COPY ./build/libs/messaging-0.0.1-SNAPSHOT.jar ./messaging-0.0.1-SNAPSHOT.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "/root/messaging-0.0.1-SNAPSHOT.jar"]
