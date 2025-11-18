#  Java 17.
FROM eclipse-temurin:17-jdk-alpine

RUN apk add --no-cache curl
LABEL maintainer="jhoseph.duort@gmail.com"

# --- CONFIGURACIÓN ---
WORKDIR /app

# COPIAR EL CÓDIGO
COPY build/libs/*.jar app.jar

# -EXPOSICIÓN
# puerto 8099 de Eureka
EXPOSE 8099

#  EJECUCIÓN-
#  Comando para arrancar el servicio.
ENTRYPOINT ["java", "-jar", "/app/app.jar"]